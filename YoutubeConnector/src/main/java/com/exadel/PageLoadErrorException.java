/**
 * Copyright (C) 2013 Vladimir Kishinskiy
 *
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.exadel;


/**
 * Created by Vladimir Kishinskiy
 * Date: 29.01.13
 */

/**
 * Exception, which throws when cannot connect to Youtube site of fake Youtube page
 */
import java.io.IOException;

public class PageLoadErrorException extends IOException {
	public PageLoadErrorException(String text){
		super(text);
	}
	public PageLoadErrorException(String text, Exception innerEx){
		super(text,innerEx);
	}
}
