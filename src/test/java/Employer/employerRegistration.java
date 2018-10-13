package Employer;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import coreClasses.BaseTestScript;
import coreClasses.itTopTalentProperties;
import employer_PageObjects.Employer_LoginPage;
import employer_PageObjects.Employer_RegisterPage;

public class employerRegistration extends BaseTestScript {

	Employer_RegisterPage emp_reg;
	Employer_LoginPage emp_login;
	String emailaddress = "inaamalvi3"+getRandomString(3)+"@gmail.com";
	String APPLICATION_URL;
	String  password = "test";
	@Test(priority=1)
	public void successful_registration() throws InterruptedException, IOException {
		Reporter.log("Scenarnio 1-> Started");
		Reporter.log("===============================================");
		System.out.print(emailaddress);
		Reporter.log(emailaddress);
		emp_reg = new Employer_RegisterPage(BaseTestScript.driver);
		Reporter.log("Step-1 Registration Started");
		emp_reg.register(emailaddress);
		APPLICATION_URL = itTopTalentProperties.getInstance().getProperty("qa_DEV_URL").trim();
		driver.navigate().to(APPLICATION_URL);
		Thread.sleep(5000);
		Reporter.log("Step-2 Registration ended");
		emp_login = new Employer_LoginPage(BaseTestScript.driver);
		emp_login.login(emailaddress, password);
		Reporter.log("login ended..");
		expectedResult();
		Reporter.log("Registration and login successfully.");
		Thread.sleep(10000);
//		Assert.assertEquals(true, emp_reg.successRegistrationMethod().equalsIgnoreCase("Success in Registration"));

	}

}
