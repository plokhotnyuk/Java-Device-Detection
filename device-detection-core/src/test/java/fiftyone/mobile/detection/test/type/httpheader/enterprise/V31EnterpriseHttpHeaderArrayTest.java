/*
 * This Source Code Form is copyright of 51Degrees Mobile Experts Limited.
 * Copyright © 2014 51Degrees Mobile Experts Limited, 5 Charlotte Close,
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
 * This Source Code Form is "Incompatible With Secondary Licenses", as
 * defined by the Mozilla Public License, v. 2.0.
 */

package fiftyone.mobile.detection.test.type.httpheader.enterprise;

import fiftyone.mobile.detection.test.TestType;
import fiftyone.mobile.detection.test.type.httpheader.Combinations;
import fiftyone.mobile.detection.Filename;
import fiftyone.mobile.detection.factories.StreamFactory;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(TestType.DataSetEnterprise.class)
public class V31EnterpriseHttpHeaderArrayTest extends Combinations {

    public V31EnterpriseHttpHeaderArrayTest() {
        super(Filename.ENTERPRISE_PATTERN_V31);
    }

    @Before
    public void createDataSet() throws IOException
    {
        assertFileExists(super.dataFile);
        super.dataSet = StreamFactory.create(readAllBytes(super.dataFile));
    }

    @Test
    public void EnterpriseV31Array_OperaMiniSamsung() throws IOException
    {
        super.OperaMini_Samsung();
    }

    @Test
    public void EnterpriseV31Array_OperaMini_HTC() throws IOException
    {
        super.OperaMini_HTC();
    }

    @Test
    public void EnterpriseV31Array_OperaMini_iPhone() throws IOException
    {
        super.OperaMini_iPhone();
    } 
}