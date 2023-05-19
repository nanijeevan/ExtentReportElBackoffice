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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test4 extends ExtentReport_BaseClass {
	ExtentReports extent=new ExtentReports();
// ExtentReports extent;
    ExtentTest test;
	
    WebDriver driver;
	
	
	
  
     
    @Test
    public void captureScreenshot()
    {
        test = extent.createTest("captureScreenshot");
      //driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        
        driver.get("http://automationtesting.in");
        String title = driver.getTitle();
        Assert.assertEquals("Home - Automation Test", title);
        test.log(Status.PASS, "Test Passed");
    }
//	@Test
//	public void test1()
//	{
//	ExtentTest test= extent.createTest("Verify Test1");
//	test.info("Test1 has started executed");
//	test.pass("Test1 passed");
//	}
//	
//	
//	@Test
//	public void test2()
//	{
//		ExtentTest test= extent.createTest("Verify Test2");
//		test.info("Test2 has started executed");
//		test.pass("Test2 passed");
//	}
	

}
