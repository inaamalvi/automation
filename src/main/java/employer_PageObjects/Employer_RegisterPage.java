package employer_PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class Employer_RegisterPage extends BasePageObject {

	public Employer_RegisterPage(WebDriver driver) {

		super(driver);
	}

	public void register(String email) throws IOException {

		click(By.xpath("//div[@class='careerfy-right']//li//a[text()='Register']"));
		click(By.id("EmployeeRegister"));
		sendkeys(By.xpath("//*[@id='SingupEmployee']//input[@name='firstname']"), "Test1");
		sendkeys(By.xpath("//*[@id='SingupEmployee']//input[@name='lastname']"), "ITTT");
		sendkeys(By.xpath("//*[@id='SingupEmployee']//input[@name='company']"), "Testcompany");
		sendkeys(By.xpath("//*[@id='SingupEmployee']//input[@name='email']"), email);
		sendkeys(By.xpath("//*[@id='SingupEmployee']//input[@name='password']"), "test");
		sendkeys(By.xpath("//*[@id='SingupEmployee']//input[@name='confirm_password']"), "test");
		click(By.xpath("/*[@id='SingupEmployee']//input[@type='submit']"));

	}

}
