package coreClasses;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.apache.commons.io.FileUtils;

public class BaseTestScript {

	public static WebDriver driver;
	String APPLICATION_URL;
	String downloadFilePath = "C:\\InamAlvi\\Selenium_downloads";

	@BeforeTest
	public void beoferTest() {

		driver = setUp();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	public WebDriver setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\InamAlvi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1);
		prefs.put("download.default_directory", downloadFilePath);
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable -extensions");
		options.addArguments("--start-maximized");
		options.setExperimentalOption("prefs", prefs);
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
	protected static void CaptureErrorScreen(String screen_name) throws IOException
	{

		String date_str = systemTime();
		if (screen_name.startsWith("http"))
		{
			StringTokenizer split = new StringTokenizer(screen_name, "?");
			screen_name = split.nextToken();
			screen_name = screen_name.replace("/", "_");
			screen_name = screen_name.replace(":", "");
		}
		else if (screen_name.contains("/") || screen_name.contains(":") || screen_name.contains("?")
				|| screen_name.contains("\\") || screen_name.contains("*") || screen_name.contains("<")
				|| screen_name.contains(">"))
		{
			screen_name = screen_name.replace("/", "_");
			screen_name = screen_name.replace(":", "");
			screen_name = screen_name.replace("\\", "");
			screen_name = screen_name.replace("?", "");
			screen_name = screen_name.replace("*", "");
			screen_name = screen_name.replace("<", "");
			screen_name = screen_name.replace(">", "");
		}
		System.out.println("Screen Name : " + screen_name);
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		String path = "C:\\BugScreenShort\\" + screen_name + "_" + date_str + ".jpeg";
		File error = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(error, new File(path));
	}

}
