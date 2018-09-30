package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class Employer_Loginpage extends BasePageObject {

	public Employer_Loginpage(WebDriver driver) {
		super(driver);

	}
	public void login(String email, String password) throws IOException {
		
		click(By.xpath("//*[@id=\'careerfy-header\']/div/div/aside[3]/div/ul/li[2]/a"));
		click(By.id("EmployeeLogin"));
		sendkeys(By.xpath("//*[@id=\'LoginCandidateEmp\']/div[3]/ul/li[1]/input[2]"), email);
		sendkeys(By.xpath("//*[@id=\'LoginCandidateEmp\']/div[3]/ul/li[2]/input"), password);
		click(By.xpath("//*[@id=\'LoginCandidateEmp\']/div[3]/ul/li[3]/div[2]/input"));
		
		
	}
	public boolean verifyUseronLoginPage()
	{
		System.out.println(getCurrentPageUrl());
		if (getCurrentPageUrl().contains("company_jobs"))
		{
			return true;
		}
		return false;
		
	}

}
