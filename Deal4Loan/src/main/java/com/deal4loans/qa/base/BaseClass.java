package com.deal4loans.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass 
{
	BrowserFactory bf = BrowserFactory.getInstanceOfBrowserFactory();
	WebDriver driver = bf.getDriver();
	@BeforeSuite
	public void init()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.deal4loans.com/");
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}

}
