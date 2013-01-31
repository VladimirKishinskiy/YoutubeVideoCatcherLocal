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

/**
 * Class provides store and output information about video
 *
 */
public class Video {
	private String name;
	private String link;
	private String viewcount;

    /**
     * Default constructor
     * @param name
     * @param link
     * @param viewcount
     */
	Video(String name,String link,String viewcount){
		this.name = name;
		this.link = link;
		this.viewcount = viewcount;
	}

    /**
     * Output information in console about video
     */
	public void output(){
		System.out.println(this.name);
		System.out.println(this.link);
		System.out.println(this.viewcount);
	}
}
