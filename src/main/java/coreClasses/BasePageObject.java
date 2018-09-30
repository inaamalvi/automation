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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

	private WebDriver driver;
	Actions build;
	Alert alert;
	int Seconds = 10;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
		build = new Actions(driver);
	}

	public void click(By by) throws IOException {

		try {
			WebElement element = driver.findElement(by);
			getHighlightElement(element);
			timeinterval(1);
			build.moveToElement(element).click().perform();

		} catch (NoSuchElementException e) {
			driver.findElement(by).click();
		} catch (Exception e) {
			// Assert.assertTrue(false, "Fail to click on link : " + by + " on page : " +
			// e.getMessage());
			// rootLogger.warn("Fail to click on link : " + by + " on page : " +
			// selenium.getWrappedDriver().getCurrentUrl());
		}
	}

	public void getHighlightElement(final WebElement element) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, 10);
			// Wait for search to complete
			wait.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver webDriver) {
					return element != null;
				}
			});
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid red'", element);
		} catch (Exception e) {
			// logger.info("Fail to highlight the Element");
		}

	}

	public void timeinterval(int i) throws InterruptedException {

		Thread.sleep(1000 * i);

	}

	public void sendkeys(By by, String keys) {
		getHighlightElement(driver.findElement(by));
		driver.findElement(by).sendKeys(keys);
	}

	public String getPageTitle() {
		String actualTitle = driver.getTitle();
		return actualTitle;

	}

	public String getCurrentPageUrl() {
		// String actualTitle = driver.getCurrentUrl();
		return (driver.getCurrentUrl());

		// return actualTitle;

	}

	public String getText(By by) throws IOException, InterruptedException {
		// waitForParticularElement(by, Seconds);
		try {
			getHighlightElement(driver.findElement(by));
			return driver.findElement(by).getText().trim();
		} catch (NoSuchElementException e) {
			// Assert.assertTrue(false, "Fail to get text value from : " + by + " on page :
			// " + e.getMessage());

		} catch (Exception e) {
			// logger.info(e.getMessage());

		}
		return null;
	}

	public void selectOptionFromDropDown(By by, String option) throws IOException {

		// waitForParticularElement(by, Seconds);
		Select select_list = null;
		try {
			moveToElement(by);
			// timeInterval();
			select_list = new Select(driver.findElement(by));
			// timeInterval();
			select_list.selectByVisibleText(option);
		} catch (NoSuchElementException e) {
			// Assert.assertTrue(false, "Fail to find drop down box to select option : " +
			// by + " on page : " + e.getMessage());
		} catch (Exception e) {
			// rootLogger.warn("Fail to select stetus : " + e.getMessage());
		}

	}

	public void moveToElement(By by) throws IOException {
		WebElement element;

		try {
			element = driver.findElement(by);
			getHighlightElement(driver.findElement(by));
			build.moveToElement(element).build().perform();
		} catch (NoSuchElementException e) {
			// rootLogger.warn("Fail to find Element: " + by + " on page : " +
			// detectPage());
		} catch (Exception e) {
			// rootLogger.warn("Fail to find Element: " + by + " on page : " +
			// detectPage());
		}
	}

	
}
