package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import coreClasses.BasePageObject;

public class Employer_RegisterPage extends BasePageObject {
	WebDriver driver;
	

	public Employer_RegisterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	public void register() throws IOException
	{
		
		click(By.xpath("//div[@class='careerfy-right']//li//a[text()='Register']"));
		click(By.id("EmployeeRegister"));
		//sendkeys(By.name("firstname"),"Test1");
	}
	
}
