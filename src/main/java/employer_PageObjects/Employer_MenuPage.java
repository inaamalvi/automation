package employer_PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import coreClasses.BasePageObject;
import coreClasses.BaseTestScript;

public class Employer_MenuPage extends BasePageObject {

	int x = 10;

	public Employer_MenuPage(WebDriver driver) {
		super(driver);

	}

	public void navigationfromsidemenu(String menu) throws IOException {

		List<WebElement> l = BaseTestScript.driver
				.findElements(By.xpath("//div[@class='careerfy-employer-dashboard-nav']//ul//li//a"));

		for (WebElement e : l) {
			System.out.println(e.getAttribute("href"));
			if (e.getAttribute("href").endsWith(menu)) {

				System.out.println("inside if statement");
				click(e);
			}
		}

	}

	public void navigationfromheader(String menu) throws IOException {

	}

}