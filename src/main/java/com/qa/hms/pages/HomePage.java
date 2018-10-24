package com.qa.hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hms.base.TestBase;

public class HomePage extends TestBase {
	
//	pagefactory
	
	@FindBy(xpath = "//a[@class='selected']")
	WebElement feedback;
	
	@FindBy(xpath = "//div[@class='box']//p[2]")
	WebElement hmsimg;
	
	@FindBy(xpath="(//a[@href='perminent_registraion.php'])[1]")
	WebElement regstrnLink;
	
	//initialize driver with pagefactory
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Pagelibrary or methods or actions on pagefactory
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyImage()
	{
		return hmsimg.isDisplayed();
	}
	
	public FeedbackFormPage verifyclickOnFeedback()
	{
		feedback.click();
		return new FeedbackFormPage();
	}
	
	public RegistrationPage verifyRegstrnLink()
	{
		regstrnLink.click();
		return new RegistrationPage();
	}
	
}
