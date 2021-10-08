package com.deal4loans.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory
{
	private static BrowserFactory bf=null;
	public WebDriver driver=null;
	private BrowserFactory()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public static BrowserFactory getInstanceOfBrowserFactory()
	{
		if(bf==null)
		{
			bf = new BrowserFactory();
		}
		return bf;
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}

}
