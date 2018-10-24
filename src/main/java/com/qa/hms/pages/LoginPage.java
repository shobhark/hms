package com.qa.hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hms.base.TestBase;

public class LoginPage extends TestBase{
	
	//page factory or OR(object repository
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "submit")
	WebElement login;
	
	//initialising the objects with driver
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//actions or pageLibraries
	
	public String verifytitle()
	{
		return driver.getTitle();
	}
	
	
	public HomePage verifylogIN(String usn, String pwd)
	{
		username.sendKeys(usn);
		password.sendKeys(pwd);
		login.click();
		
		return new HomePage();
	}

}
