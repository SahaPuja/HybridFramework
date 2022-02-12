package com.learnAutomation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
	Properties prop;
	public ConfigProperties()
	{
	prop = new Properties();
	
	try {
		FileInputStream fin = new FileInputStream("./Configurations/Config.properties");
		prop.load(fin);
	} catch (Exception e) {
		System.out.println("Unable to read Properties File"+e.getMessage());
	}
	}
	
	
	public String getData(String keyToSearch)
	{
		return prop.getProperty(keyToSearch);
	}
	
	public String getBrowser() {
		return prop.getProperty("Browser");
	}
	
	public String getURL() {
		return prop.getProperty("qaURL");
	}
}
