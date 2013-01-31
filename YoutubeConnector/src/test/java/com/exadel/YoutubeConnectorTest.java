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

/**
 * Unit test for simple YoutubeConnector.
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
     * Testing normal behavior of YoutubeConnector with given youtube video URL
     * Result of testing must be true
     * @throws PageLoadErrorException
     */
    public void testYoutubeConnectorNormal() throws PageLoadErrorException {
        String URL = "https://www.youtube.com/watch?v=YWrIVsXstcs";
        YoutubeConnector connector = new YoutubeConnector();
        Document page = connector.getPage(URL);
        assertTrue( page != null );
    }

    /**
     * Testing exception behavior of YoutubeConnector with given video URL
     * Result must be a console message "Exception is catched. Test successful"
     * @throws PageLoadErrorException
     */
    public void testYoutubeConnectorAbnormal() throws PageLoadErrorException {
        String URL = "http://www.meteoprog.ua/ru/weather/Donetsk/";
        YoutubeConnector connector = new YoutubeConnector();
        try{
        Document page = connector.getPage(URL);
        }
        catch(PageLoadErrorException E){
               System.out.println("Exception is catched. Test successful");
        }
    }
}
