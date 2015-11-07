package com.epitech.simplecount.models;

import java.util.Properties;

public class Settings
{
	private static Settings ourInstance = new Settings();
	private Properties properties = new Properties();

	private Settings()
	{
		try
		{
			properties.load(this.getClass().getResourceAsStream("/application.properties"));
		}
		catch (Exception e)
		{
			System.out.println("Error occurred while loading configuration files: " + e.toString());
			System.exit(-1);
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
