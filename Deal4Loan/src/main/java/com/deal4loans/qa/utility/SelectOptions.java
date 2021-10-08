package com.deal4loans.qa.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectOptions
{
	public static void selectByText(WebElement element,String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public static String getSelectedOptionText(WebElement element)
	{
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
}
