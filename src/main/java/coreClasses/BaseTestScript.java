package coreClasses;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTestScript {

	WebDriver driver;
	String APPLICATION_URL;

	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\InamAlvi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable -extensions");
		options.addArguments("--start-maximized");

	// old version use Desired Capabilities before 3.0
	//	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	//	capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
	//	capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		driver = new ChromeDriver(options);

	// will not use it, we use options  
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	driver.manage().window().maximize();

	}
	
	public void tearDown()
	{
		driver.close();
		driver.quit();
		
	}
	public void navigatetourl() throws InterruptedException, IOException{
		
		//Thread.sleep(5000);	
		APPLICATION_URL = itTopTalentProperties.getInstance().getProperty("qa_DEV_URL").trim();
		driver.navigate().to(APPLICATION_URL);
		
	}

}


