package com.qa.hms.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hms.base.TestBase;
import com.qa.hms.pages.HomePage;
import com.qa.hms.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUP()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		
	}
	
	@Test(priority = 1)
	public void verifytitleTest()
	{
		String title = loginPage.verifytitle();
		Assert.assertEquals(title, "User Login Page", "Title is not matching");
	}
	
	@Test(priority = 2)
	public void verifyloginTest()
	{
		homePage = loginPage.verifylogIN(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
