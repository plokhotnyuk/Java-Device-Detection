package fiftyone.mobile.detection.entities.stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/* *********************************************************************
 * This Source Code Form is copyright of 51Degrees Mobile Experts Limited. 
 * Copyright 2014 51Degrees Mobile Experts Limited, 5 Charlotte Close,
 * Caversham, Reading, Berkshire, United Kingdom RG4 7BY
 * 
 * This Source Code Form is the subject of the following patent 
 * applications, owned by 51Degrees Mobile Experts Limited of 5 Charlotte
 * Close, Caversham, Reading, Berkshire, United Kingdom RG4 7BY: 
 * European Patent Application No. 13192291.6; and 
 * United States Patent Application Nos. 14/085,223 and 14/085,301.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0.
 * 
 * If a copy of the MPL was not distributed with this file, You can obtain
 * one at http://mozilla.org/MPL/2.0/.
 * 
 * This Source Code Form is ?Incompatible With Secondary Licenses?, as
 * defined by the Mozilla Public License, v. 2.0.
 * ********************************************************************* */
/**
 * Base class for file sources.
 */
public abstract class SourceFileBase extends SourceBase {

    /**
     * The file containing the source data.
     */
    private final File fileInfo;
    
    /**
     * True if the file is temporary and should be deleted when the source 
     * is disposed of.
     */
    private final boolean isTempFile;
    
    /**
     * Construct a new source from file on disk.
     * @param fileName File source of the data.
     * @param isTempFile True if the file should be deleted when the 
     * source is disposed.
     */
    public SourceFileBase(String fileName, boolean isTempFile) {
        this.fileInfo = new File(fileName);
        this.fileInfo.setReadOnly();
        this.isTempFile = isTempFile;
    }
    
    /**
     * Delete the file if it's a temporary file and it still exists.
     */
    public void deleteFile() {
        if (this.isTempFile) {
            try {
                Files.delete(fileInfo.toPath());
            } catch (IOException ex) {
                // Not critical, file may be in use by another process.
                Logger.getLogger(SourceFileBase.class.getName())
                                               .log(Level.INFO, null, ex);
            } 
        }
    }
    
    /**
     * Returns the file used to construct this Source.
     * @return  the file used to construct this Source.
     */
    public File getFile() {
        return fileInfo;
    }
}
