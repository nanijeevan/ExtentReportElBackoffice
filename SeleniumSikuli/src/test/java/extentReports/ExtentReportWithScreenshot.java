package extentReports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.hc.client5.http.utils.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportWithScreenshot {
	
	   ExtentReports extent;
       ExtentTest test;
       WebDriver driver;
       ExtentTest Parent;
       ExtentTest child1,child;
       
       @BeforeMethod
       public void setup(){
           
           DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss"); 
           String destDir = dateFormat.format(new Date());
           ExtentSparkReporter esp=new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReport/ExtentReports_"+destDir+"/SwarupExtentReport.html");
           extent=new ExtentReports();
           extent.attachReporter(esp);
           extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
       }
       
       @Test (testName="Chrome browser Testing")public void chromeBrowser() throws IOException{
           /*extent.attachReporter(spark);
           extent.createTest("chromeBrowser").log(Status.PASS  , "This is logging event for the setup and it is passed");
           extent.flush();*/
           Parent=extent.createTest("CMO");
           child1=Parent.createNode("Test1");
           child=child1.createNode("Chrome browser Testing");
           
           System.out.println("The tread value for Chrome browser is "+ Thread.currentThread().getId());
      //     System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32 (2)\\chromedriver.exe");
           WebDriverManager.chromedriver().setup();
           driver=new ChromeDriver();
           child.log(Status.PASS, "Chrome browser has opened",MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
           driver.get("https://www.icicibank.com");
           
           child.log(Status.PASS,"Expected was its should open the bank website",MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
           
           child.log(Status.PASS, "Need to open the URL "+" http://www.icicibank.com");
           driver.manage().window().maximize();
           child.log(Status.PASS, "Test Case is passed",MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
           
           
           
       }
       
       @AfterMethod
       public void getResult(ITestResult result){
           if(result.getStatus()==ITestResult.SUCCESS){
               child.log(Status.PASS, "Test case is passed "+result.getStatus()+" "+result.getTestClass()+"  "+result.getName());
               child.log(Status.PASS, "Test case is passed "+result.getTestName());
               
           }
           if(result.getStatus()==ITestResult.FAILURE){
               child.log(Status.FAIL, "Test case is failed at below location "+result.getThrowable());
           }
           extent.flush();
       }
       
       
       /*@Test public void operaTesting(){
           System.out.println("The tread value for Opera browser is "+ Thread.currentThread().getId());
           System.setProperty("webdriver.opera.driver","E:\\operadriver_win32\\operadriver_win32\\operadriver.exe");
           Reporter.log("opera driver has been set",true);
           driver=new OperaDriver();
           driver.manage().window().maximize();
           driver.get("https://www.irctc.co.in");
       }
       @Test public void FirefoxTesting(){
           System.out.println("The tread value for Firefox browser is "+ Thread.currentThread().getId());
           System.setProperty("webdriver.gecko.driver","E:\\gecodriver\\geckodriver-v0.29.0-win32\\geckodriver.exe");
           Reporter.log("Gecko Driver has been set",true);
           driver=new FirefoxDriver();
           driver.manage().window().maximize();
           Reporter.log("firefox driver has been initialsed",true);
           driver.get("https://www.primevideo.com/");
       }
       @Test public void InternetExplorerTesting(){
           System.out.println("The tread value for IE browser is "+ Thread.currentThread().getId());
           System.setProperty("webdriver.ie.driver","E:\\IEDriverServer_Win32_3.4.0\\IEDriverServer.exe");
           Reporter.log("IE driver has been set",true);
           driver=new InternetExplorerDriver();
           driver.manage().window().maximize();
           driver.get("https://www.hotstar.com/in");
       }*/
       
       public static String captureBase64(WebDriver driver) throws IOException {
           String encodedBase64 = null;
           FileInputStream fileInputStream = null;
           File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
           File Dest = new File("src/../BStackImages/" + System.currentTimeMillis()
           + ".png");
           String errflpath = Dest.getAbsolutePath();
           FileUtils.copyFile(scrFile, Dest);
            
           try {
               
               fileInputStream =new FileInputStream(Dest);
               byte[] bytes =new byte[(int)Dest.length()];
               fileInputStream.read(bytes);
               encodedBase64 = new String(Base64.encodeBase64(bytes));

           }catch (FileNotFoundException e){
               e.printStackTrace();
           }
           return "data:image/png;base64,"+encodedBase64;
           
           
           }
       
       public static String capture(WebDriver driver) throws IOException {
           
           File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
           File Dest = new File("src/../BStackImages/" + System.currentTimeMillis()
           + ".png");
           String errflpath = Dest.getAbsolutePath();
           FileUtils.copyFile(scrFile, Dest);
           return errflpath;
           }

}
