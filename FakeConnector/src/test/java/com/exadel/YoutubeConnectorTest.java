/**
 * Copyright (C) 2013 Vladimir Kishinskiy
 *
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.exadel;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

/**
 * Unit test for simple FakeYoutubeConnector.
 */
public class YoutubeConnectorTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public YoutubeConnectorTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( YoutubeConnectorTest.class );
    }

    /**
     * Testing normal behavior of FakeYoutubeConnector with given youtube video URL
     * Result of testing must be true, because Youtube page load independently and URL does not matter
     * @throws PageLoadErrorException
     */
    public void testYoutubeConnectorNormal() throws PageLoadErrorException {
        String URL = "http://www.meteoprog.ua/ru/weather/Donetsk/";
        YoutubeConnector connector = new YoutubeConnector();
        Document page = connector.getPage(URL);
        assertTrue( page != null );
    }
}
