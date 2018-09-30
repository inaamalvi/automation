package coreClasses;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
public class BaseTestScript {

	public static WebDriver driver;
	String APPLICATION_URL;

	@BeforeTest
	public void beoferTest() {

		driver = setUp();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	public WebDriver setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\InamAlvi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable -extensions");
		options.addArguments("--start-maximized");
		return new ChromeDriver(options);

	}

	@BeforeMethod
	protected void beforeMethod() throws InterruptedException, IOException {
		// driver.get(APPLICATION_URL);
		APPLICATION_URL = itTopTalentProperties.getInstance().getProperty("qa_DEV_URL").trim();
		driver.navigate().to(APPLICATION_URL);
	}

	@AfterTest
	public void tearDown() {
	driver.close();
	driver.quit();

	}
	protected String getRandomString(int lenghtOfNumber)
	{
		return RandomStringUtils.randomAlphabetic(lenghtOfNumber);
	}

	protected static String GenerateRandomNumber(int charLength)
	{
		return RandomStringUtils.randomNumeric(charLength);
	}
	protected void expectedResult() {
		Reporter.log("");
		Reporter.log("Expected :");
		Reporter.log("=========");
	}

	protected void scenarioHeading(int i, String heading) {
		System.out.println(" ####################### START SCENARIO " + i + "  #######################");
		Reporter.log("Scenario " + i + " : " + heading);
		Reporter.log("==================================");
		Reporter.log("Steps : ");
		Reporter.log("");
	}

	protected void scenarioHeadingWithPreCondition(String precondition) {
		Reporter.log("PreCondition:\n" + precondition);
		Reporter.log("==================================");
		Reporter.log("");
		Reporter.log("Steps : ");
		Reporter.log("");
	}

	protected void scenarioHeadingWithPreCondition(int i, String heading, String precondition) {
		System.out.println(" ####################### START SCENARIO " + i + "  #######################");
		Reporter.log("Scenario " + i + " : " + heading);
		Reporter.log("==================================");
		Reporter.log("");
	}

	protected void testCaseDevelopedBy(String scriptWriterName, String testCaseName) {
		Reporter.log("Automation Case Developed by : " + scriptWriterName);
		Reporter.log("TestCase Name : " + testCaseName);
		Reporter.log("TestCase Start Time : " + systemTime());
		Reporter.log("==================================================");
	}

	protected void testExecutionWithUserHeading(String user, String start_end) {
		Reporter.log("\n=================================================================");
		Reporter.log(start_end + " : Testing of All Scnarios using \"" + user + "\"");
		Reporter.log("=================================================================\n");

	}

	protected static String systemTime() {
		Calendar calendar = new GregorianCalendar();
		String am_pm;
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		if (calendar.get(Calendar.AM_PM) == 0) {
			am_pm = "AM";
		} else {
			am_pm = "PM";
		}
		String fix_time = hour + "_" + minute + "_" + second + "_" + am_pm;

		return fix_time;
	}

	protected void BugReport(String bugDescription) {
		Reporter.log("==============================================================");
		Reporter.log("BUG DESCRIPTION : " + bugDescription);
		Reporter.log("==============================================================");
	}

}
