package extentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport_BaseClass {

	public static WebDriver driver;
	public static String screenshotssubFolderName;
	//public String Stagging_Url = "https://homecare.gleecus.com/login";
	//public String Production_Url = "https://homecaredashboard.gleecus.com/login";
	public String dev_Url = "https://dev.vigeodash.com/login";
	public String vigeodash_Url = "https://hnts.vigeodash.com/login";
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
	
	
	@BeforeTest
	public void setup(ITestContext context) 
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
       
        /*--To set download file into a specific path ------------------*/
        Map<String, Object> prefs = new HashMap<String, Object>();
		//prefs.put("download.default_directory","E:\\workspace\\his\\testcases\\HIS_Automation\\Export_Data");
		prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "Export_Data");
		option.setExperimentalOption("prefs", prefs);
		/*--------------------*/
		
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		extentTest = extentReports.createTest(context.getName());
	}
	
	
	@AfterTest
	public void teardown() throws Exception, IOException {
		driver.quit();
	}
	
	@BeforeSuite
	public void initialiseExtentReports() {
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTests.html");
		sparkReporter_all.config().setReportName("All Tests report");
		
		ExtentSparkReporter sparkReporter_failed = new ExtentSparkReporter("FailedTests.html");
		sparkReporter_failed.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		sparkReporter_failed.config().setReportName("Failure report");
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter_all, sparkReporter_failed);
		
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		extentReports.setSystemInfo("Instance", dev_Url);
	}
	
	@AfterSuite
	public void generateExtentReports()throws Exception{
		extentReports.flush();
		Desktop.getDesktop().browse(new File("AllTests1.html").toURI());
		Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
	}

	@AfterMethod
	public void screenshotCapture(Method m, ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = null;
			screenshotPath = captureScreenshot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+ ".jpg");
			extentTest.addScreenCaptureFromPath(screenshotPath);
			extentTest.fail(result.getThrowable());
		} else if(result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(m.getName() + " is passed");
		}
		
		extentTest.assignCategory(m.getAnnotation(Test.class).groups());
	}
	
	
	
	public String captureScreenshot(String filename) {
		if(screenshotssubFolderName == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
		    //DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
		    screenshotssubFolderName = myDateObj.format(myFormatObj);
		   }
		
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+ screenshotssubFolderName+"/" + filename);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		return destFile.getAbsolutePath();
	}
	
}
