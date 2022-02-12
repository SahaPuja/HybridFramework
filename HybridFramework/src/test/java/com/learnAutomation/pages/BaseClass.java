package com.learnAutomation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import com.learnAutomation.utilities.BrowserFactory;
import com.learnAutomation.utilities.ConfigProperties;
import com.learnAutomation.utilities.ExcelDataProvider;
import com.learnAutomation.utilities.Helper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigProperties config;
	public Helper helper;
	public ExtentTest test;
	public ExtentReports report;
	
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("Setting up report and test is getting ready", true);
		excel = new ExcelDataProvider();
		config = new ConfigProperties();
		helper = new Helper();
	
		report = new ExtentReports(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html", true);
		//report = new ExtentReports("./Reports/FreeCRM.html");
		Reporter.log("Setting up done- Test can be started", true);
	}
	@BeforeClass
	public void setUp() 
	{
		Reporter.log("Browser is about to Launch", true);
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
		Reporter.log("Browser is up and Running", true);
	}
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void ScreenCaptureForFailure(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus()) 
		{
			String ScreenPath = helper.captureScreenshot(driver);
			test.log(LogStatus.FAIL, test.addScreenCapture(ScreenPath));
		}
		
		if(ITestResult.SUCCESS==result.getStatus()) 
		{
			String ScreenPath = helper.captureScreenshot(driver);
			test.log(LogStatus.PASS, test.addScreenCapture(ScreenPath));
		}
	}
  @AfterSuite
  public void tearDownSuite()
  {
	 
	  report.flush();
	  //report.close();
	  Reporter.log("Test Completed", true);
  }
}
