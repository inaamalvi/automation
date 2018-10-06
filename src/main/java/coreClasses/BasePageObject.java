package coreClasses;

import java.io.IOException;
import java.util.List;
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
import org.testng.Assert;

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

	public void click(WebElement element) throws IOException {

		try {
			getHighlightElement(element);
			timeinterval(1);
			build.moveToElement(element).click().perform();

		} catch (NoSuchElementException e) {
			element.click();
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

	// radio button

	public void clearkeys(By by) {

		getHighlightElement(driver.findElement(by));
		driver.findElement(by).clear();
	}

	public void switchtoiframe(String nameorid) {
		driver.switchTo().frame(nameorid);

	}

	public void switchtodefaultconents() {
		driver.switchTo().defaultContent();

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

	public boolean isDisplayed(By by) throws IOException {
		try {
			moveToElement(by);
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			// rootLogger.warn("Fail to isDisplayed element : " + by + " on page : " +
			// selenium.getWrappedDriver().getCurrentUrl());
			return false;
		} catch (Exception e) {
			// CaptureErrorScreen(selenium.getWrappedDriver().getCurrentUrl());
			System.out.println("Exception 2:" + e);
		}
		return false;
	}

	public boolean isDisplayed(WebElement webElement, By locator) throws IOException {
		// timeInterval(1);
		try {
			if ((webElement == null)) {
				return driver.findElement(locator).isDisplayed();
			}
			getHighlightElement(webElement.findElement(locator));
			return webElement.findElement(locator).isDisplayed();
		} catch (Exception e) {
			// CaptureErrorScreen(selenium.getWrappedDriver().getCurrentUrl());
			// rootLogger.warn("Fail to isDisplayed element : " + webElement + " on page : "
			// + selenium.getWrappedDriver().getCurrentUrl());
		}
		return false;
	}

	public boolean isSelected(By by) throws IOException {

		try {
			moveToElement(by);
			getHighlightElement(driver.findElement(by));
			return driver.findElement(by).isSelected();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Fail to find element to check isSelected : " + by + " on page : ");
			return false;
		} catch (Exception e) {
			// rootLogger.warn("Fail to check isSelected : " + by + " : " + e.getMessage());
			return false;
		}
	}

	public boolean isEnabled(By by) throws IOException {

		try {
			getHighlightElement(driver.findElement(by));
			return driver.findElement(by).isEnabled();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(false, "Fail to find element to check isEnabled : " + by + " on page : ");
			return false;
		} catch (Exception e) {
		//	rootLogger.warn("Fail to check isEnabled : " + by + " on page : " + e.getMessage());
			return false;
		}
	}

}
