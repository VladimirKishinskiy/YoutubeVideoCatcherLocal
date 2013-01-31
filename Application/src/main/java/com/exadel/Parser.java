/**
 * Copyright (C) 2013 Vladimir Kishinskiy
 *
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.exadel;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by Vladimir Kishinskiy
 * Date: 27.01.13
 */

/**
 * Class provides search the related video in Youtube HTML page
 * Using Jsoup 1.7.1 plugin to parse the HTML page
 */
public class Parser {

    /**
     * Provides a search in entered Jsoup document
     * with Youtube HTML tags
     * @param page Jsoup document which consists parsed Youtube HTML page
     * @return name, reference and view count of related videos
     */
	public static ArrayList<Video> getRelatedVideos(Document page){
        String youtubeURL = "http://www.youtube.com";
        String urlTag = "href";
        String titleTag = "span.title";
        String relatedVideoTag = "a.related-video";
        String viewCountTag = "span.view-count";
		ArrayList<Video> relatedVideos = new ArrayList<Video>();
		Elements relatedVideoElements = page.select(relatedVideoTag);
		for(Element element : relatedVideoElements) {
			String name = element.select(titleTag).text();
			String link = youtubeURL + element.select(relatedVideoTag).attr(urlTag);
			String viewcount = element.select(viewCountTag).text();
			relatedVideos.add(new Video(name, link, viewcount));
		}
		return relatedVideos;
	}
}
