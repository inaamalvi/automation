package employer_PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import coreClasses.BasePageObject;

public class Employer_PostJobPage extends BasePageObject {

	public Employer_PostJobPage(WebDriver driver) {
		super(driver);

	}

	public void clickPostJobTab() throws IOException
	{
		click(By.xpath("(//div[@class='careerfy-employer-dashboard-nav']//a)[3]"));
		
		
	}
	public void employer_PasteJob() throws IOException {
		
		
		selectOptionFromDropDown(By.name("jobcode"), "Front End Developer");
		sendkeys(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/form/div/ul/li[2]/input"), "Sr backend Developer");
		switchtoiframe("job_details_ifr");
		sendkeys(By.id("tinymce"), "This is text");
	//	clearkeys(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/form/div/ul/li[3]/input"));
	//	sendkeys(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/form/div/ul/li[3]/input"), "New York, NY");
	//	sendkeys(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/form/div/ul/li[6]/input"), "Bachelor's Degree");
		
	//	selectOptionFromDropDown(By.name("experience"), "3 Years");
		
	//	selectOptionFromDropDown(By.name("jobtype"), "Contract Position ");
	//	selectOptionFromDropDown(By.name("salarystart"), "$70,000 -$74,000");
		
		
		//Driver

	}
	
	
}
