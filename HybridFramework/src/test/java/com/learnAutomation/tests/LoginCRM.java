package com.learnAutomation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnAutomation.pages.BaseClass;
import com.learnAutomation.pages.LoginPage;
import com.learnAutomation.utilities.BrowserFactory;
import com.learnAutomation.utilities.ExcelDataProvider;
import com.relevantcodes.extentreports.LogStatus;

public class LoginCRM extends BaseClass{
	
	//This test is created by Puja
	@Test
	public void loginApp()
	{
		test = report.startTest("Login to Application");
		test.log(LogStatus.PASS, "Navigated to the specified URL");
		LoginPage loginPageObj= PageFactory.initElements(driver, LoginPage.class);
		
		loginPageObj.loginToCRM(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
		//helper.captureScreenshot(driver);
		test.log(LogStatus.PASS, "Logged in Successfully");		
	}

}
