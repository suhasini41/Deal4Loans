package com.deal4loans.qa.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	//WebElements
	@FindBy(xpath="//div[@class='col span_1_of_3 scrollpoint sp-effect1'][1]//div")
	private WebElement quotesLink;
	
	@FindBy(xpath="//td[@bgcolor='#CCCCCC']//tr")
	private List<WebElement> rows;
	
	@FindBy(xpath="//td[@bgcolor='#CCCCCC']//tr[1]/td")
	private List<WebElement> cols;
	
	@FindBy(xpath="//td[@bgcolor='#CCCCCC']//tr//td")
	private List<WebElement> cell;
	
	@FindBy(xpath="//td[@bgcolor='#CCCCCC']//tr//td[1]")
	private List<WebElement> bankName;
	
	@FindBy(xpath ="//td[@bgcolor='#CCCCCC']//tr//td[2]")
	private List<WebElement> rateOfInterest;
	
	@FindBy(xpath ="//td[@bgcolor='#CCCCCC']//tr//td[3]")
	private List<WebElement> processingFee;
	
	@FindBy(xpath ="//td[@bgcolor='#CCCCCC']//tr//td[4]")
	private List<WebElement> loanAmount;
	
	@FindBy(xpath ="//td[@bgcolor='#CCCCCC']//tr//td[5]")
	private List<WebElement> prePayment;
	
	@FindBy(xpath ="//td[@bgcolor='#CCCCCC']//tr//td[6]")
	private List<WebElement> disbursal;
	
	@FindBy(xpath ="//td[@bgcolor='#CCCCCC']//tr//td[7]")
	private List<WebElement> partOption;
	
	@FindBy(xpath="//div[@id='show_button_area']//input[@value='Get Quote']")
	private WebElement getQuote;
	
	@FindBy(xpath="//input[@id='Loan_Amount']")
	private WebElement amount;
	
	@FindBy(id="Employment_Status")
	private WebElement employment_Status;
	
	@FindBy(id="IncomeAmount")
	WebElement incomeAmount;
	
	@FindBy(id="City")
	WebElement city;
	
	@FindAll({
		@FindBy(id="Employment_Status"),
		@FindBy(id="IncomeAmount"),
		@FindBy(id="City")
	}
	)
	List<WebElement> three_fields;
	
	public void clickQuotesButton()
	{
		quotesLink.click();
	}
	public int numOfRows()
	{
		return rows.size();
	}
	public int numOfCols()
	{
		return cols.size();
	}
	public HashMap<String,List<String>> getCell()
	{
		HashMap<String,List<String>> map = new HashMap<>();
		for(int i=0;i<numOfRows();i++)
		{
			List<String> list = new ArrayList<>();
			list.add(rateOfInterest.get(i).getText());
			list.add(processingFee.get(i).getText());
			list.add(loanAmount.get(i).getText());
			list.add(prePayment.get(i).getText());
			list.add(disbursal.get(i).getText());
			list.add(partOption.get(i).getText());
			map.put(bankName.get(i).getText(), list);
		}
		return map;	
	}
	
	public WebElement getQuote()
	{
		return getQuote;
	}
	
	public void enterAmount(int amt)
	{
		amount.sendKeys(Integer.toString(amt));
	}
	public List<WebElement> getThreefields()
	{
		return three_fields;
	}
	public WebElement getEmploymentStatus()
	{
		return employment_Status;
	}
	
	public WebElement getIncomeAmount()
	{
		return incomeAmount;
	}
	public WebElement getCity()
	{
		return city;
	}
}
