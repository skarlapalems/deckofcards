package com.swetha.deckofcards.util;

import java.io.IOException;
import java.util.Properties;

public class DataUtil {

	private static Properties properties = new Properties();
	
	static{
		
		try {
			properties.load(DataUtil.class.getResourceAsStream("/config.properties"));
			properties.load(DataUtil.class.getResourceAsStream("/apis.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key) {
		return properties.getProperty(key);
	}
}
