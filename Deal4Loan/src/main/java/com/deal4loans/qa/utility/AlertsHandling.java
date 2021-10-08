package com.deal4loans.qa.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.deal4loans.qa.base.BrowserFactory;

public class AlertsHandling 
{
	static BrowserFactory bf = BrowserFactory.getInstanceOfBrowserFactory();
	static WebDriver driver = bf.getDriver();
	
	public static boolean isAlertPresent()
	{
		try
		{
			Waits.waitForAlert();
			return true;
		}
		catch(WebDriverException e)
		{
			return false;
		}
	}
	public static Alert switchToAlert()
	{
		Alert alert=null;
		if(isAlertPresent())
		{
			alert = driver.switchTo().alert();
		}
		return alert;
	}
	public static String alertMessage()
	{
		String msg=null;
		if(isAlertPresent())
		{
			msg = switchToAlert().getText();
			System.out.println(msg);
		}
		else
		{
			System.out.println("No alert present");
			return null;
		}
		return msg;
	}
	
	public static void switchAndOk()
	{
		if(isAlertPresent())
		{
			switchToAlert().accept();
		}
		else
		{
			System.out.println("No alert present");
		}
	}

}
