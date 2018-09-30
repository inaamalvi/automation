package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import coreClasses.BasePageObject;

public class Employer_PostJob extends BasePageObject {

	public Employer_PostJob(WebDriver driver) {
		super(driver);

	}

	public void clickPostJobTab() throws IOException
	{
		click(By.xpath("(//div[@class='careerfy-employer-dashboard-nav']//a)[3]"));
	}
	public void employer_PasteJob() throws IOException {
		
		selectOptionFromDropDown(By.name("jobcode"), "Front End Developer");
		

	}
}
