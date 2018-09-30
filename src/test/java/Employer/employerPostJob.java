package Employer;

import java.io.IOException;

import org.testng.annotations.Test;

import coreClasses.BaseTestScript;
import pageObjects.Employer_Loginpage;
import pageObjects.Employer_PostJob;

public class employerPostJob extends BaseTestScript {
	

	Employer_Loginpage emp_login;
	Employer_PostJob  emp_postjob;
	
	@Test
	public void postJob() throws IOException
	{
	emp_login = new Employer_Loginpage(BaseTestScript.driver);
	emp_login.login("inaamalvi2@gmail.com", "testing");
	
	emp_postjob = new Employer_PostJob(BaseTestScript.driver);
	emp_postjob.clickPostJobTab();
	emp_postjob.employer_PasteJob();	
	}
}
