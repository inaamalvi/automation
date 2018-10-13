package Employer;

import java.io.IOException;

import org.testng.annotations.Test;

import coreClasses.BaseTestScript;
import employer_PageObjects.Employer_LoginPage;
import employer_PageObjects.Employer_MenuPage;
import employer_PageObjects.Employer_PostJobPage;

public class employerPostJob extends BaseTestScript {
	

	Employer_LoginPage emp_login;
	Employer_PostJobPage  emp_postjob;
	Employer_MenuPage     emp_menu;
	
	@Test
	public void postJob() throws IOException, InterruptedException
	{
	emp_login = new Employer_LoginPage(BaseTestScript.driver);
	emp_login.login("inaamalvi2@gmail.com", "testing");
	
	emp_postjob = new Employer_PostJobPage(BaseTestScript.driver);
	//emp_postjob.clickPostJobTab();
	
	emp_menu = new Employer_MenuPage(BaseTestScript.driver);
	emp_menu.navigationfromsidemenu("addpost");
	emp_postjob.employer_PasteJob();
	Thread.sleep(10000);
	}
}
