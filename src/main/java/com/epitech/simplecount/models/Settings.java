package com.epitech.simplecount.models;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings
{
	private static Settings ourInstance = new Settings();
	private Properties properties = new Properties();

	private Settings()
	{
		try
		{
			properties.load(new FileInputStream("src/main/resources/config.properties"));
		} catch (IOException e)
		{
			System.out.println("Error occurred: " + e.toString());
		}
	}

	private static Settings getInstance()
	{
		return (ourInstance);
	}

	public static String get(String key)
	{
		return (Settings.getInstance().properties.getProperty(key));
	}

	public static int asInt(String key)
	{
		return (Integer.parseInt(Settings.getInstance().properties.getProperty(key)));
	}
	public static int asInt(String key, int base)
	{
		return (Integer.parseInt(Settings.getInstance().properties.getProperty(key), base));
	}
}
