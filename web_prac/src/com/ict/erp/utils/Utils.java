package com.ict.erp.utils;

public class Utils {
	
	private static final String WI  = "/WEB-INF";
	private static final String J = ".jsp";
	
	public static String makeUri(String uri) {
		return WI + uri + J;
		
	}
	
	public static String getCmd(String uri) {
		if(uri.lastIndexOf("/") == -1) {
			return null;
		}
		
		return uri.substring(uri.lastIndexOf("/")+1, uri.length());
	}
	


}
