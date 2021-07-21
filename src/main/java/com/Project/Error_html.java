package com.Project;

import org.springframework.stereotype.Service;

@Service
public class Error_html {
	
	public String error(int i) {
		
		if( i == 1) {
			String err = "<h2 style ='text-align: center;   color: #cc0033;font-family: Helvetica, Arial, sans-serif;font-size: 13px;font-weight: bold;line-height: 20px;text-shadow: 1px 1px rgba(250,250,250,.3);' class='error_text'>This Account exists already</h2> ";
			
			return err;

		}
		else if ( i == 2) {
			String err = "<h2 style ='text-align: center;   color: #cc0033;font-family: Helvetica, Arial, sans-serif;font-size: 13px;font-weight: bold;line-height: 20px;text-shadow: 1px 1px rgba(250,250,250,.3);' class='error_text'>Passwords do not match</h2>";

			return err;
		}
		else if ( i == 3 ) {
			String err = "<h2 style ='text-align: center;   color: #cc0033;font-family: Helvetica, Arial, sans-serif;font-size: 13px;font-weight: bold;line-height: 20px;text-shadow: 1px 1px rgba(250,250,250,.3);' class='error_text'>Uploading ERROR</h2>";
			
			return err;
			
		}
		else if(i == 4) {
			
			String err = "<h2 style ='text-align: center;   color: #cc0033;font-family: Helvetica, Arial, sans-serif;font-size: 13px;font-weight: bold;line-height: 20px;text-shadow: 1px 1px rgba(250,250,250,.3);' class='error_text'>Old password is not Valid</h2>";
					
			return err;
		}
		else if(i == 5) {
			
			String err ="<h2 style ='text-align: center;   color: #cc0033;font-family: Helvetica, Arial, sans-serif;font-size: 13px;font-weight: bold;line-height: 20px;text-shadow: 1px 1px rgba(250,250,250,.3);' class='error_text'>Passwords DO NOT Match</h2>";

					
			return err;
		}
		else {
			return "";
		}
	}
}
