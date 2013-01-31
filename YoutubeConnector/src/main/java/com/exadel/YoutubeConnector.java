/**
 * Copyright (C) 2013 Vladimir Kishinskiy
 *
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.exadel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Vladimir Kishinskiy
 * Date: 27.01.13
 */

/**
 * Provides interface for get Youtube HTML page
 * Using Jsoup 1.7.1 plugin for get connect to Youtube and parsing
 */
public class YoutubeConnector
{
    /**
     * provides connect to Youtube
     * @param pageURL is an address of Youtube video
     * @return a document, witch consists a parsed HTML page
     * @throws PageLoadErrorException
     */
	public Document getPage(String pageURL) throws PageLoadErrorException {

		try{
			Document youtubePage = Jsoup.connect(pageURL).get();
			return youtubePage;
		}
		catch(IOException E){
			throw new PageLoadErrorException("Page not found");
		}
	}
}
