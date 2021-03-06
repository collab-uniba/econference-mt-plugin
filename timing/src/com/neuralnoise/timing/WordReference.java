package com.neuralnoise.timing;
import java.net.*;

public class WordReference {
	private static final String baseUrl = "http://www.wordreference.com";
	private static final String baseQuery = "/%s%s/%s";
	
	public static String translate(String lemma, String src, String dest) throws Exception {
		String ret = null;
		URL url = new URL(baseUrl + String.format(baseQuery, src, dest, URLEncoder.encode(lemma, "UTF-8")));
		URLConnection conn = url.openConnection();

		conn.setRequestProperty("User-Agent", "Hello world");
		conn.setRequestProperty("Referer", baseUrl);
		
		return ret;
	}
}
