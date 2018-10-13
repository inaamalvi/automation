package candidate_PageObjects;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import coreClasses.BasePageObject;

public class Candidate_RegisterPage extends BasePageObject {

	public Candidate_RegisterPage(WebDriver driver) {
		super(driver);

	}

	public void Register() throws IOException {
		//click(By.xpath("//div[@class='careerfy-right']//li//a[text()='Register']"));
		//click(By.id("CandidateRegister"));
	//	sendkeys(By.name("firstname"), "Zakir");
		String path = new File("../itTopTalent/src/test/resources/job_summary.txt").getCanonicalPath().trim();

		System.out.println(path);
	//	sendkeys(By.name("resume"), path);
		click(By.xpath("//*[@id=\"program-header\"]/div[2]/div/a[1]"));
		
	}
}
