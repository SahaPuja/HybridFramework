package com.learnAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
	 this.driver=driver;
	}
	
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	public void loginToCRM(String userNameApp, String passwordApp)
	{
		username.sendKeys(userNameApp);
		password.sendKeys(passwordApp);
		loginBtn.click();
	}
	
}
