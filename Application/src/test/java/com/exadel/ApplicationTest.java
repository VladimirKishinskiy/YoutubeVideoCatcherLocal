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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exadel.Parser;

/**
 * Unit test for application.
 */
public class ApplicationTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ApplicationTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ApplicationTest.class );
    }

    /**
     * Parser test, which tested parser work
     * if Parser don`t parse the page, count of related videos will be zero
     * Result of this test must be true
     */
    public void testParser() {
        String URL = "https://www.youtube.com/watch?v=YWrIVsXstcs";
        YoutubeConnector myConnector = new YoutubeConnector();
        ArrayList<Video> myVideos = new ArrayList<Video>();
        Document myPage;
        try {
            myPage = myConnector.getPage(URL);
            myVideos = Parser.getRelatedVideos(myPage);
        } catch (PageLoadErrorException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        assertTrue(myVideos.size() > 0);
    }

    /**
     * Testing normal behavior of validator
     * URL is correst and must be a valid
     * result must be true
     */
    public void  testValidateNormal(){
        String URL = "http://www.youtube.com/watch?v=i_Yp64ZaAJs";
        Application App = new Application();
        assertTrue(App.validate(URL));
    }

    /**
     * Testing abnormal behavior of validator
     * URL is incorrest and must be a not valid
     * result must be false
     */
    public void  testValidateAbnormal(){
        String URL = "http://www.meteoprog.ua/ru/weather/Donetsk/";
        Application App = new Application();
        assertFalse(App.validate(URL));
    }
}
