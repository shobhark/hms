package com.qa.hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.hms.base.TestBase;

public class FeedbackFormPage extends TestBase {
	
	//page factory or object repository
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//select[@id='car']")
	WebElement car;
	
	@FindBy(xpath ="(//input[@name='radio'])[1]")
	WebElement radioBtn;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkBox;
	
	@FindBy(xpath = "//input[@type='file']")
	WebElement file;
	
	@FindBy(xpath = "//textarea[@id='message']")
	WebElement message;
	
	@FindBy(xpath = "//button[@class='action']")
	WebElement submit;
	
//initialize pagefactory with driver
	
	public FeedbackFormPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
//actions on pagefactory or pagelibrary	
	
	public String verifyPageTitle()
	{
		
		return driver.getTitle();
	}
	
	public RegistrationPage fillFeedbackForm(String nm, String eml, String carr, String fle, String mess)
	{
		name.sendKeys(nm);
		email.sendKeys(eml); 
		Select select = new Select(car);
		select.selectByVisibleText(carr);
		radioBtn.click();
		checkBox.click();
		file.sendKeys(fle);
		message.sendKeys(mess);
		submit.click();
		
		return new RegistrationPage();
		
	}
	
}
