/**
 * Copyright (C) 2013 Vladimir Kishinskiy
 *
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.exadel;
/**
 * Created by Vladimir Kishinskiy
 * Date: 27.01.13
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;

import java.util.Scanner;

/**
 * Provides interface for get fake Youtube HTML page
 * Using Jsoup 1.7.1 plugin for parsing
 */
public class YoutubeConnector
{
    /**
     * provides connect to fake Youtube page
     * @param pageURL is an address of Youtube video
     *                using for compatibility with the real version of Youtube Connector
     * @return a document, witch consists a parsed fake HTML page
     * @throws PageLoadErrorException
     */
	public Document getPage(String pageURL) throws PageLoadErrorException {
		pageURL = "/YouTube.htm";
        StringBuilder fakePage = new StringBuilder();
		try{
            InputStream readFile = YoutubeConnector.class.getResourceAsStream(pageURL);
            Scanner sc = new Scanner(readFile);
            while (sc.hasNext()){
                fakePage.append(sc.nextLine());
            }
			Document youtubePage = Jsoup.parse(fakePage.toString());
			return youtubePage;
		}
		catch(Exception E){
			throw new PageLoadErrorException("Page not found");
		}
	}
}
