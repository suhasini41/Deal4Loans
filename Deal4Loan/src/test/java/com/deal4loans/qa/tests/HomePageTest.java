package com.deal4loans.qa.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.deal4loans.qa.base.BaseClass;
import com.deal4loans.qa.base.BrowserFactory;
import com.deal4loans.qa.pages.HomePage;
import com.deal4loans.qa.utility.AlertsHandling;
import com.deal4loans.qa.utility.ReadExcelData;
import com.deal4loans.qa.utility.SelectOptions;
import com.deal4loans.qa.utility.Waits;

public class HomePageTest extends BaseClass
{
	BrowserFactory bf = BrowserFactory.getInstanceOfBrowserFactory();
	WebDriver driver = bf.getDriver();
	final String EXCEL_FILE_PATH = "./TestData\\Deal4Loans.xlsx";
	final String EXCEL_FILE_PATH1 = "./TestData\\ApplyLoan.xlsx";
	
	HomePage hp = PageFactory.initElements(driver, HomePage.class);
	
	@Test
	public void testCase1() throws InterruptedException
	{
		hp.clickQuotesButton();
		Thread.sleep(5000);
		Assert.assertEquals(hp.numOfRows(), 12);
		Assert.assertEquals(hp.numOfCols(), 7);
	}
	
	@DataProvider(name = "readExcelData")
	public Object[][] readData()
	{
		Object[][] data = ReadExcelData.readExcel(EXCEL_FILE_PATH,"Banks");
		return data;
	}
	
	@Test(priority=1,dataProvider = "readExcelData")
	public void tableTest(String bankName, String rateOfInterest, String processingFee, String loanAmount, String prePayment, String disbursal, String partOption)
	{
		HashMap<String,List<String>> map = hp.getCell();
		Assert.assertTrue(map.containsKey(bankName));
		List<String> fields = new ArrayList<>();
		fields.add(rateOfInterest);
		fields.add(processingFee);
		fields.add(loanAmount);
		fields.add(prePayment);
		fields.add(disbursal);
		fields.add(partOption);
		Assert.assertEquals(map.get(bankName), fields);
//		This works too!!		
//		Assert.assertTrue(map.get(bankName).contains(rateOfInterest));
//		Assert.assertTrue(map.get(bankName).contains(processingFee));
//		Assert.assertTrue(map.get(bankName).contains(loanAmount));
//		Assert.assertTrue(map.get(bankName).contains(prePayment));
//		Assert.assertTrue(map.get(bankName).contains(disbursal));
//		Assert.assertTrue(map.get(bankName).contains(partOption));
	}
	@Test(priority=1)
	public void rowCountTest()
	{
		Assert.assertEquals(hp.numOfRows(), ReadExcelData.rowCount(EXCEL_FILE_PATH,"Banks"));
	}
	@Test(priority=1)
	public void columnCountTest()
	{
		Assert.assertEquals(hp.numOfCols(), ReadExcelData.columnCount(EXCEL_FILE_PATH,"Banks"));
	}
	
	@Test(priority = 2)
	public void noLoanAmountAlertTest()
	{
		hp.getQuote().click();
		Assert.assertEquals(AlertsHandling.alertMessage(), "Please enter only numbers in Loan Amount .");
		AlertsHandling.switchAndOk();
	}
	
	@Test(priority=3)
	public void enterAmountTest()
	{
		hp.enterAmount(2000);
		hp.getQuote().click();
		Waits.waitForPresenceOfAllElements(hp.getThreefields());
		Assert.assertTrue(hp.getEmploymentStatus().isDisplayed());
		Assert.assertTrue(hp.getIncomeAmount().isDisplayed());
		Assert.assertTrue(hp.getCity().isDisplayed());
	}
	
	@DataProvider(name = "readDataEmploymentStatus")
	public Object[][] readDataforEmploymentStatus()
	{
		Object[][] data = ReadExcelData.readExcel(EXCEL_FILE_PATH1,"Employment_Status");
		return data;
	}
	
	@Test(priority=4, dataProvider = "readDataEmploymentStatus")
	public void employmentStatusDropDownTest(String status)
	{
		SelectOptions.selectByText(hp.getEmploymentStatus(), status);
		Assert.assertEquals(SelectOptions.getSelectedOptionText(hp.getEmploymentStatus()), status);
	}
	
	@Test(priority=4)
	public void cityDropDownTest()
	{
		for(int i=0;i<2;i++)
		{
			String city = ReadExcelData.getCell(EXCEL_FILE_PATH1, "City", i, 0);
			SelectOptions.selectByText(hp.getCity(), city);
			Assert.assertEquals(SelectOptions.getSelectedOptionText(hp.getCity()), city);
		}
		
	}

}
