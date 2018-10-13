package Candidate;

import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import candidate_PageObjects.Candidate_RegisterPage;
import coreClasses.BaseTestScript;

public class candidateRegistration extends BaseTestScript {
	Candidate_RegisterPage can_reg;
	String emailaddress = "inaamalvi3" + getRandomString(3) + "@gmail.com";
	String APPLICATION_URL;
	String password = "test";

	@Test(priority = 1)
	public void successful_registration() throws InterruptedException, IOException {
		Reporter.log("Scenarnio 1-> Started");
		Reporter.log("===============================================");
		System.out.print(emailaddress);
		Reporter.log(emailaddress);
	//	driver.navigate().to("https://filehippo.com/download_vlc_media_player/64/");
		can_reg = new Candidate_RegisterPage(BaseTestScript.driver);
		Reporter.log("Step-1 Registration Started");
		can_reg.Register();

		
			
		Thread.sleep(10000);
	}
}
