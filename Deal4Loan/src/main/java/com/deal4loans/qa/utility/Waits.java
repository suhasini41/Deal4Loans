package com.deal4loans.qa.utility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.deal4loans.qa.base.BrowserFactory;

public class Waits
{
	static BrowserFactory bf = BrowserFactory.getInstanceOfBrowserFactory();
	static WebDriver driver = bf.getDriver();
	public static WebDriverWait wait = new WebDriverWait(driver,10);
	
	public static void waitForPresenceOfAllElements(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	public static void waitForAlert()
	{
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public static void waitForPresenceOfAllElements(List<WebElement> elements)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	

}
