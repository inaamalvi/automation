package Employer;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import coreClasses.BaseTestScript;
import pageObjects.Employer_RegisterPage;

public class employerRegistration extends BaseTestScript {
	
	WebDriver driver;
	Employer_RegisterPage emp_reg = new Employer_RegisterPage(driver);
	
	@Test
	public void successful_registration() throws InterruptedException, IOException
	{
		setUp();
		navigatetourl();
		emp_reg.register();
		
		
		
	}
	

}
