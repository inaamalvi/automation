package Employer;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class successfulRegistration_old {
	
	@Test
	public void registration()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\InamAlvi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		driver.get("http://ittoptalent.com/");
	//	driver.findElement(By.xpath("//div[@class='careerfy-right']//li//a[text()='Register']")).click();
		driver.findElement(By.id("EmployeeRegister")).click();
	}

}
