package coreClasses;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class BasePageObject {
	
	private WebDriver driver;
	Actions build ;
	Alert alert;
	
	
	public  BasePageObject (WebDriver driver)
	{
		this.driver = driver;
				build = new Actions(driver);
		
	}
	public void click(By by) throws IOException
	{
		
		try
		{					
			WebElement element = driver.findElement(by);
			getHighlightElement(element);
			timeinterval(1);
			build.moveToElement(element).click().perform();
		
			
		}
		catch (NoSuchElementException e)
		{
			driver.findElement(by).click();
		}
		catch (Exception e)
		{
			//Assert.assertTrue(false, "Fail to click on link : " + by + " on page : " + e.getMessage());
			//rootLogger.warn("Fail to click on link : " + by + " on page : " + selenium.getWrappedDriver().getCurrentUrl());
		}
	}
	
	public void getHighlightElement(final WebElement element)
	{
		try
		{
			Wait<WebDriver> wait = new WebDriverWait(driver, 10);
			// Wait for search to complete
			wait.until(new ExpectedCondition<Boolean>()
			{
				
				public Boolean apply(WebDriver webDriver)
				{
					return element != null;
				}
			});
			((JavascriptExecutor) driver)
			.executeScript("arguments[0].style.border='2px solid red'", element);
		}
		catch (Exception e)
		{
			//logger.info("Fail to highlight the Element");
		}
		
	}
	public void timeinterval(int i) throws InterruptedException{
		
		Thread.sleep(1000 * i );
		
	}
	public void sendkeys(By by,String keys){
		getHighlightElement(driver.findElement(by));
		driver.findElement(by).sendKeys(keys);
	}
}
