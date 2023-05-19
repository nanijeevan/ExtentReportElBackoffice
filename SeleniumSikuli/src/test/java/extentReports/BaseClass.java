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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static 	ExtentReports extent=new ExtentReports();
	public static 	ExtentSparkReporter spark=new ExtentSparkReporter("EL_BO_CompareAndSaveExtentReportNewReport.html");
	//ExtentReports report;
	public static 	ExtentTest logger; 
	public static 	WebDriver driver;
	public static String screenshotssubFolderName;
	public static ExtentTest extentTest;
	
	
	
	
	@BeforeSuite
	public void extentreport()
	{
		extent.attachReporter(spark);
		
	}
		
	
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
		driver.close();
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

	
	@AfterSuite
	public void flush()
	{
		extent.flush();
	}
	
}
