package javaScriptExecutor;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighlightElmntinWebPage {
	
	

	
	public static void flash(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0;i<=5;i++)
		{
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgcolor, element, driver);
		}
		
	}
	
	
	public static void changeColor(String color, WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			
		}
	}
	
	public static void border(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
	}
	
	public static void generateAlert(WebDriver driver, String message)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}
	
//	click using javaScript Executor
	public static void clickElementJS(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}
	
//	to refresh page by using javascriptExecutor
	public static void refreshByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	
//	getTitle by using JavascriptExecutor
	
	public static String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static String getInnerText(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void main(String[] args) throws IOException, Exception {
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "D:/workspace/orangeHRMapp/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://selenium4testing.com/hms/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@name='submit']"));
		
				
//		change the background colour
			flash(loginBtn, driver);
			
//			draw the boarder before clicking on it
			border(loginBtn, driver);
			
//			Taking the screen shot
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("D:/workspace/orangeHRMapp/pic1.png"));
			
//			generating user defined alert 
//			generateAlert(driver,"There is a problem with LoginButton on Loginpage");
//			
//			String alert = driver.switchTo().alert().getText();
//			System.out.println(alert);
//			driver.switchTo().alert().accept();
			
			clickElementJS(loginBtn, driver);
			scrollDown(driver);
			Thread.sleep(2000);
			System.out.println(getTitleByJS(driver));
			System.out.println(getInnerText(driver));
			refreshByJS(driver);
			
			WebElement logoutBtn=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			clickElementJS(logoutBtn, driver);
			
			
	}

}
