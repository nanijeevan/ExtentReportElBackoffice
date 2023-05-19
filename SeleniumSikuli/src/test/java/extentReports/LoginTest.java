package extentReports;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ibm.icu.impl.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	ExtentReports extent=new ExtentReports();
	ExtentSparkReporter spark=new ExtentSparkReporter("ExtentReport13.html");
	//ExtentReports report;
	ExtentTest logger; 
	WebDriver driver;
	public static String screenshotssubFolderName;
	public static ExtentTest extentTest;
	
	
	@BeforeSuite
	public void extentreport()
	{
		extent.attachReporter(spark);
	}
	
	
	@Test
	public void test1()
	{
		System.out.println("Test has executed");
	extentTest= extent.createTest("Verify Test1");
//	extentTest.info("Test1 has started executed");
//	extentTest.pass("Test1 passed");
	
	}
	
	
	@Test
	public void test2()
	{
		 extentTest= extent.createTest("Verify Test2");
		extentTest.info("Test2 has started executed");
	//	extentTest.pass("Test2 passed");
	}
	
	
//	
//	@Test
//	public void test3()
//	{
//		extentTest= extent.createTest("Verify Test3");
//		extentTest.info("Test3 has started executed");
//		
//		//	test.fail("Test1 passed");
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.get("https://www.softwaretestingmaterial.com");
//			String currentURL = driver.getCurrentUrl();
//			Assert.assertEquals(currentURL, "NoTitle");
//			logger.log(Status.PASS, "Test Case (failTest) Status is passed");
//			
//		}
//		
		
	@AfterMethod
	public void screenshotCapture(Method m, ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = null;
			screenshotPath = captureScreenshot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+ ".jpg");
			extentTest.addScreenCaptureFromPath(screenshotPath);
			extentTest.fail(result.getThrowable());
			extentTest.pass(m.getName() + " is failed");
		} 
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
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


	
	
//	@AfterMethod
//	public void screenshotCapture(Method m, ITestResult result) {
//		ExtentTest extentTest= extent.createTest("Capturing the Screenshots for Failed Test Cases");
//		if(result.getStatus() == ITestResult.FAILURE) {
//			String screenshotPath = null;
//			screenshotPath = captureScreenshot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+ ".jpg");
//			extentTest.addScreenCaptureFromPath(screenshotPath);
//			extentTest.fail(result.getThrowable());
//		} else if(result.getStatus() == ITestResult.SUCCESS) {
//			extentTest.pass(m.getName() + " is passed");
//		}
//		
//		extentTest.assignCategory(m.getAnnotation(Test.class).groups());
//	}
//	
//	public String captureScreenshot(String filename) {
//		if(screenshotssubFolderName == null) {
//			LocalDateTime myDateObj = LocalDateTime.now();
//		    //DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//			
//		    screenshotssubFolderName = myDateObj.format(myFormatObj);
//		   }
//		
//		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
//		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//		File destFile = new File("./Screenshots/"+ screenshotssubFolderName+"/" + filename);
//		try {
//			FileUtils.copyFile(sourceFile, destFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Screenshot saved successfully");
//		return destFile.getAbsolutePath();
//	}
//		
//	private static String getScreenshot(WebDriver driver2, String name) {
//	// TODO Auto-generated method stub
//	return null;
//}


	@AfterSuite
	public void flush()
	{
		extent.flush();
	}

}
