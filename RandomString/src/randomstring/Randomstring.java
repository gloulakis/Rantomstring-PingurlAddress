/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomstring;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 *
 * @author georgiosloulakis
 */


public class Randomstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
		 // Get the size n 
        int n = 10; 
     
        String url1 = "http://www.google.com/"; // put your url
        while ( true) {
        	
        String code = RandomString 
                               .getAlphaNumericString(n); 
        
        
       String done = url1+code+".jpg";
       //String done = url1+code;
        String[] hostList = { done };
        
		for (int i = 0; i < hostList.length; i++) {
 
			String url = hostList[i];
			getStatus(url);
 
		}}

	}
 
    /**
     *
     */
     public static class RandomString { 
		  
	    static String getAlphaNumericString(int n) 
	    { 
	  
	        // chose a Character random from this String 
	        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                                    + "0123456789"
	                                   + "abcdefghijklmnopqrstuvxyz";
	        //String AlphaNumericString = "0123456789"; 
	  
	        // create StringBuffer size of AlphaNumericString 
	        StringBuilder sb = new StringBuilder(n); 
	  
	        for (int i = 0; i < n; i++) { 
	  
	            // generate a random number between 
	            // 0 to AlphaNumericString variable length 
	            int index 
	                = (int)(AlphaNumericString.length() 
	                        * Math.random()); 
	  
	            // add Character one by one in end of sb 
	            sb.append(AlphaNumericString 
	                          .charAt(index)); 
	        } 
	  
	        return sb.toString(); 
	    } 
	  
	} 

	public static String getStatus(String url) throws IOException {
		 
		String result = "";
		int code = 200;
		try {
			URL siteURL = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(3000);
			connection.connect();
 
			code = connection.getResponseCode();
			if (code == 200) {
				result = "-> Done <-\t" + "Code: " + code;
				;
			} else {
				result = "-> No Ping <-\t" + "Code: " + code;
			}
		} catch (Exception e) {
			result = "-> Red <-\t" + "Wrong domain - Exception: " + e.getMessage();
 
		}
		System.out.println(url + "\t\tStatus:" + result);
		return result;
	}


}

    

