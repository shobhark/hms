package com.qa.hms.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hms.base.TestBase;
import com.qa.hms.pages.FeedbackFormPage;
import com.qa.hms.pages.HomePage;
import com.qa.hms.pages.LoginPage;
import com.qa.hms.pages.RegistrationPage;
import com.qa.hms.util.TestUtil;

public class FeedbackFormPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	FeedbackFormPage feedbackFormPage;
	RegistrationPage thankyouformPage;
	TestUtil testUtil;
	String sheetname = "feedback";
	
	
	public FeedbackFormPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUP()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		feedbackFormPage = new FeedbackFormPage();
		testUtil = new TestUtil();
		homePage=loginPage.verifylogIN(prop.getProperty("username"), prop.getProperty("password"));
		feedbackFormPage=homePage.verifyclickOnFeedback();
		TestUtil.switchToWindow();
		
	}
	
	@Test(priority = 1)
	public void verifyPageTitle()
	{
		
		String title = feedbackFormPage.verifyPageTitle();
		Assert.assertEquals(title, "Feedback Form", "Title is not matching");
		
	}
	
	
	@DataProvider
	public Object[][] testdata()
	{
		Object[][] data=TestUtil.getTestData(sheetname);
		return data;
	}
	
	
	@Test(priority = 2, dataProvider="testdata")
	public void verifyfeedbackformFillTest(String name, String email, String car, String file, String mess)
	{
	
		thankyouformPage=feedbackFormPage.fillFeedbackForm(name, email, car, file, mess);
	}
	
	
	@AfterMethod
	public void tearDOWN()
	{
		driver.quit();
	}
}
