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

import com.exadel.PageLoadErrorException;
import com.exadel.YoutubeConnector;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exadel.Video;

/**
 * Main class of YoutubeVideoCatcher
 * It manage the other modules
 */
public class Application {

    /**
     * provides a dialog with the user to enter the address video
     * If user enters invalid data output a message about an incorrect entry
     * @return Youtube video address in string
     */
	private String getURL() {
		String URL;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter youtube video URL");
		URL = sc.nextLine();
		while (!this.validate(URL)) {
			System.out.println("Enter correct youtube video URL with http:\\\\");
			URL = sc.nextLine();
		}
		return URL;
	}

    /**
     * output name, reference and view count of relater videos in console
     * @param videos ArrayList of Video, what consists a related videos
     */
	private void outputVideos(ArrayList<Video> videos){
		for(int i=0;i<videos.size();i++){
			System.out.print((i+1) + ". ");
			videos.get(i).output();
			System.out.println("\n\r");
		}
	}

    /**
     * provide validate URL address, entered by user
     * URL must have "http:\\" parts and don`t consists an excess youtube URL parameters
     * for example: "http://www.youtube.com/watch?v=i_Yp64ZaAJs"
     * @param URL the validate URL address
     * @return true if URL is valid and false else
     */
	public boolean validate(String URL) {
        Pattern pattern = Pattern.compile("(((https:\\/\\/)|(http:\\/\\/))(www\\.)?(youtube\\.com\\/watch\\?v\\=).{11})");
        Matcher matcher = pattern.matcher(URL);
		return matcher.matches();
	}

    /**
     * Main function of Application class
     * @param args console input parameters
     * @throws IOException
     */
	public static void main(String[] args) throws IOException {
        boolean workFlag = true;
        String command;
        Scanner sk = new Scanner(System.in);
        while(workFlag == true)
        {
            try{
                System.setOut(new PrintStream(System.out,true,"Cp866"));
                ArrayList<Video> videos = new ArrayList<Video>();
                Application App = new Application();
                String URL = App.getURL();
                YoutubeConnector connector = new YoutubeConnector();
                Document page = connector.getPage(URL);
                videos = Parser.getRelatedVideos(page);
                App.outputVideos(videos);

            }
            catch (Exception e) {
                System.out.println("Page not found");
            }
            System.out.println("please type 'q' for quit or any other key for repeat");
            command = sk.next();
            if(command.equals("q"))
                workFlag = false;
        }
    }
}
