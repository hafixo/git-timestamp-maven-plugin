/*
 * Copyright 2018 Stephen Connolly.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it;

import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class VerificationTest {
    @Test
    public void timestamps() throws Exception {
        InputStream stream = getClass().getResourceAsStream("/timestamp.txt");
        assertThat(stream, notNullValue());
        String timestampFromFile;
        try {
            timestampFromFile = IOUtils.toString(stream, "UTF-8");
        } finally {
            IOUtils.closeQuietly(stream);
        }
        stream = getClass().getResourceAsStream("/timestamp.filtered.txt");
        assertThat(stream, notNullValue());
        String timestampFromProperty;
        try {
            timestampFromProperty = IOUtils.toString(stream, "UTF-8");
        } finally {
            IOUtils.closeQuietly(stream);
        }
        assertThat(timestampFromFile.trim(), is(timestampFromProperty.trim()));
    }

    @Test
    public void versions() throws Exception {
        InputStream stream = getClass().getResourceAsStream("/version.txt");
        assertThat(stream, notNullValue());
        String versionFromFile;
        try {
            versionFromFile = IOUtils.toString(stream, "UTF-8");
        } finally {
            IOUtils.closeQuietly(stream);
        }
        stream = getClass().getResourceAsStream("/version.filtered.txt");
        assertThat(stream, notNullValue());
        String versionFromProperty;
        try {
            versionFromProperty = IOUtils.toString(stream, "UTF-8");
        } finally {
            IOUtils.closeQuietly(stream);
        }
        assertThat(versionFromFile.trim(), is(versionFromProperty.trim()));
    }
}
