package com.qa.hms.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hms.base.TestBase;
import com.qa.hms.pages.FeedbackFormPage;
import com.qa.hms.pages.HomePage;
import com.qa.hms.pages.LoginPage;
import com.qa.hms.pages.RegistrationPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	FeedbackFormPage feedBackFormPage;
	RegistrationPage registrationPage;
	
	
	
	//constructor to call parent class constructor to initialize properties file 
	public HomePageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUP()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		feedBackFormPage = new FeedbackFormPage();
		registrationPage = new RegistrationPage();
		homePage=loginPage.verifylogIN(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	
	@Test(enabled = false)
	public void VerifyTitleTest()
	{
		String title = homePage.verifyTitle();
		Assert.assertEquals(title, "Master Page", "Title is not matching");
	}
	
	@Test(enabled = false)
	public void verifyImageTest()
	{
		boolean flag = homePage.verifyImage();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void clickOnRegstrnLinkTest()
	{
		registrationPage=homePage.verifyRegstrnLink();
	}
	
	
	@Test(enabled = false)
	public void clickonFeedbackFormPageTest()
	{
		feedBackFormPage=homePage.verifyclickOnFeedback();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
