package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import extentReports.BaseClass;
import extentReports.CompareAndSavePOM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BO_CompareANDSave_Execution extends BaseClass {
	
	CompareAndSavePOM obj;
	
	
 


	
	
	

	
	@BeforeMethod
	public void LaunchBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev-admin.elderlylife.co.uk/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@el.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin@1234");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]/div[1]")).click();
		Thread.sleep(3000);
		obj=new CompareAndSavePOM(driver);
		obj.ClickonPrimaryDataManageMent();
		Thread.sleep(1000);
	}

//	@AfterMethod
//	public void closeBrowser() throws Exception
//	{
//		Thread.sleep(1000);
//		driver.close();
//	}
	
	

	@Test
	public void VerifyTheFunctionalityofCompareandSaveLink() throws Exception
	{
		 extentTest= extent.createTest("VerifyTheFunctionalityofCompareandSaveLink");
		obj.ClickonCompareandSaveLink();
		obj.NavigateToCompareandSavePage();
		
	}
	
	@Test
	public void VerifyTheUIofCompareandSavePage() throws Exception
	{
		 extentTest= extent.createTest("VerifyTheUIofCompareandSavePage");
		obj.ClickonCompareandSaveLink();
		obj.CompareandSavePageUI();
	
	}
	
	@Test
	public void VerifyTheFunctionalityOfAddNewCompareAndSaveButton() throws Exception
	{
		 extentTest= extent.createTest("VerifyTheFunctionalityOfAddNewCompareAndSaveButton");
		obj.ClickonCompareandSaveLink();
		obj.ClickOnAddNewCompareandSave();
		
	}
	
	
	@Test
	public void VerifyTheFunctionalityOfCloseIconInAddNewCompareAndSaveModalPage() throws Exception
	{
		 extentTest= extent.createTest("VerifyTheFunctionalityOfCloseIconInAddNewCompareAndSaveModalPage");
		obj.ClickonCompareandSaveLink();
		Thread.sleep(1000);
		obj.ClickOnAddNewCompareandSave();
		Thread.sleep(1000);
		obj.ClickonCloseIconInAddNewCompareandSaveModalPage();
		
	}
	
	
	@Test(priority=1)
	public void VerifyTheFunctionalityOfAddingNewCompareAndSave() throws Exception
	{
		extentTest= extent.createTest("VerifyTheFunctionalityOfAddingNewCompareAndSave");
		obj.ClickonCompareandSaveLink();
		obj.ClickOnAddNewCompareandSave();
		Thread.sleep(1000);
		obj.EnterCategoryNameInAddNewCompareAndSaveModalPage("testa11");
		obj.EnterExternalLinkInAddNewCompareAndSaveModalPage();
		obj.UploadLogoImageInAddNewCompareAndSaveModalPage();
		obj.ClickonSubmitButtonInAddNewCompareAndSaveModalPage();
		obj.CompareAndSaveCreateSuccessFully();
		//extentTest= extent.createTest("VerifyTheFunctionalityOfAddingNewCompareAndSave");
	}
	@Test(priority=2)
	public void VerifyTheFunctionalityOfAddingExistingCompareAndSave() throws Exception
	{
		 extentTest= extent.createTest("VerifyTheFunctionalityOfAddingExistingCompareAndSave");
		obj.ClickonCompareandSaveLink();
		obj.ClickOnAddNewCompareandSave();
		obj.EnterCategoryNameInAddNewCompareAndSaveModalPage("Testing1575");
		Thread.sleep(1000);
		obj.EnterExternalLinkInAddNewCompareAndSaveModalPage();
		Thread.sleep(2000);
		obj.UploadLogoImageInAddNewCompareAndSaveModalPage();
		Thread.sleep(1000);
		obj.ClickonSubmitButtonInAddNewCompareAndSaveModalPage();
		Thread.sleep(1000);
		obj.CreateDUPLICATECompareAndSaveErrorMessage();
	}
	
	
	@Test
	public void VerifyTheFunctionalityOfAddingtheCompareAndSaveWithOutUploadingTheLogoImage() throws Exception
	{
		 extentTest= extent.createTest("VerifyTheFunctionalityOfAddingtheCompareAndSaveWithOutUploadingTheLogoImage");
		obj.ClickonCompareandSaveLink();
		obj.ClickOnAddNewCompareandSave();
		obj.EnterCategoryNameInAddNewCompareAndSaveModalPage("Testing12411");
		obj.EnterExternalLinkInAddNewCompareAndSaveModalPage();	
		obj.ClickonSubmitButtonInAddNewCompareAndSaveModalPage();
		obj.CompareAndSaveCreateSuccessFully();
	}
	
	@Test
	public void VerifyTheFunctionalityOfAddingNewCompareAndSaveWithOutCategoryName() throws Exception
	{
		 extentTest= extent.createTest("VerifyTheFunctionalityOfAddingNewCompareAndSaveWithOutCategoryName");
		obj.ClickonCompareandSaveLink();
		obj.ClickOnAddNewCompareandSave();
		obj.EnterExternalLinkInAddNewCompareAndSaveModalPage();
		obj.UploadLogoImageInAddNewCompareAndSaveModalPage();
		obj.ClickonSubmitButtonInAddNewCompareAndSaveModalPage();
		obj.EmptyNameError();
	}
	
	@Test
	public void VerifyTheFunctionalityOfAddingCompareAndSaveWithOutExternalLink() throws Exception
	{
		 extentTest= extent.createTest("VerifyTheFunctionalityOfAddingCompareAndSaveWithOutExternalLink");
		obj.ClickonCompareandSaveLink();
		obj.ClickOnAddNewCompareandSave();
		obj.EnterCategoryNameInAddNewCompareAndSaveModalPage("Testing1233a");
		obj.UploadLogoImageInAddNewCompareAndSaveModalPage();
		obj.ClickonSubmitButtonInAddNewCompareAndSaveModalPage();
		obj.EmptyExternalLinkError();
	}
	
	@Test
	public void VerifyTheFunctionalityofComapreAndSaveViewDetailsButton() throws Exception
	{
		 extentTest= extent.createTest("VerifyTheFunctionalityofComapreAndSaveViewDetailsButton");
		obj.ClickonCompareandSaveLink();
		obj.ClickonViewDetailsButton();
	}
	@Test
	public void VerifyTheUIofCompareAndSaveDetailsModalPageUI() throws Exception
	{	 extentTest= extent.createTest("VerifyTheUIofCompareAndSaveDetailsModalPageUI");
		obj.ClickonCompareandSaveLink();
		obj.ViewCompareAndSaveDetailsModalPageUI();
	}
	
	@Test
	public void FunctionalityOfCloseIcinInViewCompareAndSaveDetailsModalPage() throws Exception
	{
		 extentTest= extent.createTest("FunctionalityOfCloseIcinInViewCompareAndSaveDetailsModalPage");
		obj.ClickonCompareandSaveLink();
		obj.FunctionalityOfCloseIcinInViewCompareAndSaveDetailsModalPage();
	}
	
	@Test
	public void FunctionalityOfUpdatingTheCompareAndSaveDetailsWithoutChangingTheData() throws Exception
	{
		 extentTest= extent.createTest("FunctionalityOfUpdatingTheCompareAndSaveDetailsWithoutChangingTheData");
		obj.ClickonCompareandSaveLink();
		obj.FunctionalityOfUpdatingTheCompareAndSaveDetailsWithoutChangingTheData();
	}
	@Test
	public void FunctionalityOfUpdatingTheCompareAndSaveCategoryName() throws Exception
	{
		 extentTest= extent.createTest("FunctionalityOfUpdatingTheCompareAndSaveCategoryName");
		obj.ClickonCompareandSaveLink();
		obj.FunctionalityOfUpdatingTheCompareAndSaveCategoryName();
	}
	
	@Test
	public void FunctionalityOfUpdatingTheCompareAndSaveExternalLink() throws Exception
	{
		 extentTest= extent.createTest("FunctionalityOfUpdatingTheCompareAndSaveExternalLink");
		obj.ClickonCompareandSaveLink();
		obj.FunctionalityOfUpdatingTheCompareAndSaveExternalLink();
	}
	
	@Test
	public void FunctionalityOfUpdatingTheCompareAndSaveLogoImage() throws Exception
	{
		 extentTest= extent.createTest("FunctionalityOfUpdatingTheCompareAndSaveLogoImage");
		obj.ClickonCompareandSaveLink();
		obj.FunctionalityOfUpdatingTheCompareAndSaveLogoImage();
	}

	@Test
	public void FunctionalityOfUpdatingTheCompareAndSaveByDeletingtheLogoImage() throws Exception
	{
		 extentTest= extent.createTest("FunctionalityOfUpdatingTheCompareAndSaveByDeletingtheLogoImage");
		obj.ClickonCompareandSaveLink();
		obj.FunctionalityOfUpdatingTheCompareAndSaveByDeletingtheLogoImage();
	}
	
	@Test
	public void FunctionalityOfUpdatingTheCompareAndSaveByDeletingtheCategoryName() throws Exception
	{
		 extentTest= extent.createTest("FunctionalityOfUpdatingTheCompareAndSaveByDeletingtheCategoryName");
		obj.ClickonCompareandSaveLink();
		obj.FunctionalityOfUpdatingTheCompareAndSaveByDeletingtheCategoryName();
	}
	
	@Test
	public void FunctionalityOfUpdatingTheCompareAndSaveByDeletingtheExternalLink() throws Exception
	{
		 extentTest= extent.createTest("FunctionalityOfUpdatingTheCompareAndSaveByDeletingtheExternalLink");
		obj.ClickonCompareandSaveLink();
		obj.FunctionalityOfUpdatingTheCompareAndSaveByDeletingtheExternalLink();
	}
	@Test
	public void FunctionalityOfUpdatingTheExistiingCategoryOfCompareAndSave() throws Exception
	{
		 extentTest= extent.createTest("FunctionalityOfUpdatingTheExistiingCategoryOfCompareAndSave");
		obj.ClickonCompareandSaveLink();
		obj.FunctionalityOfUpdatingTheExistiingCategoryOfCompareAndSave();
	}
}

