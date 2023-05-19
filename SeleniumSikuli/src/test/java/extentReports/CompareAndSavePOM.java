package extentReports;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class CompareAndSavePOM {
	
	WebDriver driver;

	
	 JavascriptExecutor executor;
	
	public CompareAndSavePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 this.executor = (JavascriptExecutor) this.driver; 
	}
	
	
	

	
	
@FindBy (how=How.XPATH, using="//body/div[@id='root']/div[1]/div[2]/div[2]/div[4]/div[1]/div[2]/ul[1]/li[1]/a[1]") WebElement PrimaryDtMang;
@FindBy (how=How.XPATH, using="//body/div[@id='root']/div[1]/div[2]/div[2]/div[4]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[2]/a[1]") WebElement CompareandSave;
@FindBy (how=How.XPATH, using="//body/div[@id='root']/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]") WebElement CompareandSavePage;
@FindBy (how=How.XPATH, using="//span[contains(text(),'Add New')]") WebElement AddNewCompare;
@FindBy (how=How.XPATH, using="//span[contains(text(),'Template')]") WebElement CompareTemplateButton;
@FindBy (how=How.XPATH, using="//body/div[@id='root']/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]") WebElement SearchCompare;
@FindBy (how=How.XPATH, using="//h5[contains(text(),'Compare and Save')]") WebElement CreateCompareModalPage;
@FindBy (how=How.XPATH, using="//span[contains(text(),'×')]") WebElement AddNewCompareCloseIcon;
@FindBy (how=How.XPATH, using="//img[@class=\"upload-icon\"]") WebElement AddNewCompareImageUpload;
@FindBy (how=How.XPATH, using="//label[contains(text(),'Category Name')]") WebElement AddNewCompareCategoryName;
@FindBy (how=How.XPATH, using="//input[@id='name']") WebElement AddNewCompareCategoryNameField;
@FindBy (how=How.XPATH, using="//label[contains(text(),'External Link')]") WebElement AddNewCompareExternalLink;
@FindBy (how=How.XPATH, using="//input[@id='externalLink']") WebElement AddNewCompareExternalLinkField;
@FindBy (how=How.XPATH, using="//button[contains(text(),'Submit')]") WebElement AddNewCompareSubmit;
@FindBy (how=How.XPATH, using="//button[contains(text(),'Cancel')]") WebElement AddNewCompareCancel;
@FindBy (how=How.XPATH, using="//button[contains(text(),'Add')]") WebElement AddNewCompareAddLink;
@FindBy (how=How.XPATH, using="//div[contains(text(),'Enter name here')]") WebElement AddNewCompareEmptyNameError;
@FindBy (how=How.XPATH, using="//div[contains(text(),'Invalid External Url')]") WebElement AddNewCompareEmptyLinkError;
@FindBy (how=How.XPATH, using="//div[contains(text(),'Invalid External Url')]") WebElement AddNewCompareInvalidLinkError;
@FindBy (how=How.XPATH, using="//div[contains(text(),'SaveAndComapres created successfully')]") WebElement CompareCreateMessage;
@FindBy (how=How.XPATH, using="//div[contains(text(),'name is already taken. Please use another name')]") WebElement CreateDuplicateCompareMessage;

//---------------------------Compare & Save Listing UI------------------------------------------------------------------
@FindBy (how=How.XPATH, using="//*[@id=\"root\"]/div/div[2]/div[3]/div[1]/div[2]/div/div/div/div/div/div[1]/div/div/div[1]/div[2]/h5") WebElement CompareSaveListingName;
@FindBy (how=How.XPATH, using="//body/div[@id='root']/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/img[1]") WebElement CompareSaveListingProfileImage;
@FindBy (how=How.XPATH, using="//body/div[@id='root']/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]") WebElement CompareSaveListingExternalLink;
@FindBy (how=How.XPATH, using="//*[@id=\"root\"]/div/div[2]/div[3]/div[1]/div[2]/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div[2]/div/a") WebElement CompareSaveListingExternalLinkField;
@FindBy (how=How.XPATH, using="/html/body/div/div/div[2]/div[3]/div[1]/div[2]/div/div/div/div/div/div[1]/div/div/div[3]/div/button") WebElement CompareSaveListingViewDetails;


//----------------------------------------View Compare & Save Details----------------------------------------------------

@FindBy (how=How.XPATH, using="//h5[contains(text(),'Compare and Save')]") WebElement ViewCompareSaveModalPage;
@FindBy (how=How.XPATH, using="//span[contains(text(),'×')]") WebElement ViewCompareSaveCloseIcon;
@FindBy (how=How.XPATH, using="//body/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]") WebElement ViewCompareSaveDeleteImage;
@FindBy (how=How.XPATH, using="//body/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/img[1]") WebElement ViewCompareSaveUploadImage;
@FindBy (how=How.XPATH, using="//label[contains(text(),'Category Name')]") WebElement ViewCompareSaveCategoryName;
@FindBy (how=How.XPATH, using="//input[@id='name']") WebElement ViewCompareSaveCategoryNameField;
@FindBy (how=How.XPATH, using="//label[contains(text(),'External Link')]") WebElement ViewCompareSaveExternalLink;
@FindBy (how=How.XPATH, using="//input[@id='externalLink']") WebElement ViewCompareSaveExternalLinkField;
@FindBy (how=How.XPATH, using="//button[contains(text(),'Cancel')]") WebElement ViewCompareSaveCancelButton;
@FindBy (how=How.XPATH, using="//button[contains(text(),'Submit')]") WebElement ViewCompareSaveSubmitButton;
@FindBy (how=How.XPATH, using="//div[contains(text(),'Enter name here')]") WebElement ViewCompareSaveEmptyNameError;
@FindBy (how=How.XPATH, using="//div[contains(text(),'Invalid External Url')]") WebElement ViewCompareSaveEmptLinkError;
@FindBy (how=How.XPATH, using="//div[contains(text(),'SaveCompare was updated successfully.')]") WebElement ViewCompareSaveUpdateSuccessMessage;

@FindBy (how=How.XPATH, using="//*[contains(text(),'Demo Test1399')]") WebElement UpdatedCategoryName;
@FindBy (how=How.XPATH, using="//*[contains(text(),'http://amazon.co.in')]") WebElement UpdatedExternalLink;

@FindBy (how=How.XPATH, using="//div[contains(text(),'Name is already taken. Please use another name')]") WebElement UpdateExistingCompareAndSave;





public void ClickonViewDetailsButton() throws Exception
{
	Thread.sleep(1000);
	CompareSaveListingViewDetails.click();
	Thread.sleep(2000);
	ViewCompareSaveModalPage.isDisplayed();
}


public void ViewCompareAndSaveDetailsModalPageUI() throws Exception
{
	Thread.sleep(1000);
	CompareSaveListingViewDetails.click();
	Thread.sleep(2000);
	ViewCompareSaveModalPage.isDisplayed();
	Thread.sleep(1000);
	ViewCompareSaveCloseIcon.isDisplayed();
	ViewCompareSaveDeleteImage.isDisplayed();
	ViewCompareSaveCategoryName.isDisplayed();
	ViewCompareSaveExternalLinkField.isDisplayed();
	ViewCompareSaveSubmitButton.isDisplayed();
	Thread.sleep(1000);
}

public void FunctionalityOfCloseIcinInViewCompareAndSaveDetailsModalPage() throws Exception
{
	Thread.sleep(1000);
	CompareSaveListingViewDetails.click();
	Thread.sleep(2000);
	ViewCompareSaveCloseIcon.click();
	Thread.sleep(1000);
	CompareandSavePage.isDisplayed();
}


public void FunctionalityOfUpdatingTheCompareAndSaveDetailsWithoutChangingTheData() throws Exception
{
	Thread.sleep(1000);
	CompareSaveListingViewDetails.click();
	Thread.sleep(2000);
	ViewCompareSaveSubmitButton.click();
	Thread.sleep(1000);
	ViewCompareSaveUpdateSuccessMessage.isDisplayed();
	Thread.sleep(1000);
}


public void FunctionalityOfUpdatingTheCompareAndSaveCategoryName() throws Exception
{
	Thread.sleep(1000);
	CompareSaveListingViewDetails.click();
	Thread.sleep(2000);
	ViewCompareSaveCategoryNameField.clear();
	Thread.sleep(1000);
	ViewCompareSaveCategoryNameField.sendKeys("Demo Test1444");	
	Thread.sleep(1000);
	ViewCompareSaveSubmitButton.click();
	
	Thread.sleep(1000);
	ViewCompareSaveUpdateSuccessMessage.isDisplayed();
	Thread.sleep(1000);
	UpdatedCategoryName.isDisplayed();
}


public void FunctionalityOfUpdatingTheCompareAndSaveExternalLink() throws Exception
{
	Thread.sleep(1000);
	CompareSaveListingViewDetails.click();
	Thread.sleep(2000);
	ViewCompareSaveExternalLinkField.clear();
	Thread.sleep(1000);
	ViewCompareSaveExternalLinkField.sendKeys("http://amazon.co.in");
	Thread.sleep(1000);
	ViewCompareSaveSubmitButton.click();
	Thread.sleep(1000);
	ViewCompareSaveUpdateSuccessMessage.isDisplayed();
	Thread.sleep(1000);
	UpdatedExternalLink.isDisplayed();
	
}
public void FunctionalityOfUpdatingTheCompareAndSaveLogoImage() throws Exception
{
	Thread.sleep(1000);
	CompareSaveListingViewDetails.click();
	Thread.sleep(2000);
	ViewCompareSaveDeleteImage.click();
	Thread.sleep(1000);

	
	Screen s1=new Screen();	
	//clicking on the Choose file button
	
		s1.click("E:\\SikuliTest\\tt5.PNG");
		Thread.sleep(2000);
		//Inside the Filename Input bix we are typying the the location of the file with name
		s1.type("E:\\SikuliTest\\sendFilePath.PNG", "E:\\SikuliTest\\download.png");
		Thread.sleep(2000);
		//Clicking on the open button
		s1.click("E:\\SikuliTest\\clickOnOpen.PNG");
		Thread.sleep(2000);
	

	Thread.sleep(1000);
	ViewCompareSaveSubmitButton.click();
	Thread.sleep(1000);
	ViewCompareSaveUpdateSuccessMessage.isDisplayed();
	Thread.sleep(1000);
	
}

public void FunctionalityOfUpdatingTheCompareAndSaveByDeletingtheLogoImage() throws Exception
{
	Thread.sleep(1000);
	CompareSaveListingViewDetails.click();
	Thread.sleep(2000);
	ViewCompareSaveDeleteImage.click();
	Thread.sleep(1000);
	ViewCompareSaveSubmitButton.click();
	Thread.sleep(1000);
	ViewCompareSaveUpdateSuccessMessage.isDisplayed();
	Thread.sleep(1000);
	
}

public void FunctionalityOfUpdatingTheCompareAndSaveByDeletingtheCategoryName() throws Exception
{
	Thread.sleep(1000);
	CompareSaveListingViewDetails.click();
	Thread.sleep(2000);
	
	ViewCompareSaveCategoryNameField.sendKeys(Keys.CONTROL + "a");
	ViewCompareSaveCategoryNameField.sendKeys(Keys.DELETE);
	
	Thread.sleep(1000);
	ViewCompareSaveSubmitButton.click();
	Thread.sleep(1000);
	ViewCompareSaveEmptyNameError.isDisplayed();
	
}


public void FunctionalityOfUpdatingTheCompareAndSaveByDeletingtheExternalLink() throws Exception
{
	Thread.sleep(1000);
	CompareSaveListingViewDetails.click();
	Thread.sleep(2000);
	
	ViewCompareSaveExternalLinkField.sendKeys(Keys.CONTROL + "a");
	ViewCompareSaveExternalLinkField.sendKeys(Keys.DELETE);
	Thread.sleep(1000);
	ViewCompareSaveSubmitButton.click();
	Thread.sleep(1000);
	ViewCompareSaveEmptLinkError.isDisplayed();
	
}

public void FunctionalityOfUpdatingTheExistiingCategoryOfCompareAndSave() throws Exception
{
	Thread.sleep(1000);
	CompareSaveListingViewDetails.click();
	Thread.sleep(2000);
	ViewCompareSaveCategoryNameField.clear();
	Thread.sleep(1000);
	ViewCompareSaveCategoryNameField.sendKeys("qqq");	
	Thread.sleep(1000);
	ViewCompareSaveSubmitButton.click();
	Thread.sleep(1000);
	UpdateExistingCompareAndSave.isDisplayed();
	
}




//------------------------------------

public void ClickonPrimaryDataManageMent() throws Exception
{
	Thread.sleep(1000);
	PrimaryDtMang.click();
}


public void ClickonCompareandSaveLink() throws Exception
{
	Thread.sleep(1000);
	CompareandSave.click();
}


public void NavigateToCompareandSavePage() throws Exception
{
	Thread.sleep(1000);
	CompareandSavePage.isDisplayed();
}


public void CompareandSavePageUI() throws Exception
{
	Thread.sleep(1000);
	CompareTemplateButton.isDisplayed();
	SearchCompare.isDisplayed();
	AddNewCompare.isDisplayed();
}

public void ClickOnAddNewCompareandSave() throws Exception
{
	Thread.sleep(1000);
	AddNewCompare.click();
}

public void DisplayAddNewCompareandSaveModalPage() throws Exception
{
	Thread.sleep(1000);
	CreateCompareModalPage.isDisplayed();
}


public void AddNewCompareandSaveModalPageUI() throws Exception
{
	Thread.sleep(1000);
	CreateCompareModalPage.isDisplayed();
	AddNewCompareCloseIcon.isDisplayed();
	AddNewCompareImageUpload.isDisplayed();
	AddNewCompareCategoryName.isDisplayed();
	AddNewCompareCategoryNameField.isDisplayed();
	AddNewCompareExternalLink.isDisplayed();
	AddNewCompareExternalLinkField.isDisplayed();
	AddNewCompareExternalLink.isDisplayed();
	AddNewCompareExternalLinkField.isDisplayed();
	AddNewCompareSubmit.isDisplayed();
	AddNewCompareCancel.isDisplayed();
}



public void ClickonCloseIconInAddNewCompareandSaveModalPage() throws Exception
{
	Thread.sleep(1000);
	AddNewCompareCloseIcon.click();
}



public void EnterCategoryNameInAddNewCompareAndSaveModalPage(String CategoryNAME) throws Exception
{
	Thread.sleep(2000);
	AddNewCompareCategoryNameField.sendKeys(CategoryNAME);
}


public void EnterExternalLinkInAddNewCompareAndSaveModalPage() throws Exception
{
	Thread.sleep(1000);
	AddNewCompareExternalLinkField.sendKeys("http://google.com");
}



public void UploadLogoImageInAddNewCompareAndSaveModalPage() throws Exception
{
	Thread.sleep(1000);
	
	
	Screen s1=new Screen();	
	//clicking on the Choose file button
	
		s1.click("E:\\SikuliTest\\tt5.PNG");
		Thread.sleep(2000);
		//Inside the Filename Input bix we are typying the the location of the file with name
		s1.type("E:\\SikuliTest\\sendFilePath.PNG", "E:\\SikuliTest\\download.png");
		Thread.sleep(2000);
		//Clicking on the open button
		s1.click("E:\\SikuliTest\\clickOnOpen.PNG");
		Thread.sleep(2000);

}

public void ClickonSubmitButtonInAddNewCompareAndSaveModalPage() throws Exception
{
	Thread.sleep(1000);
	AddNewCompareSubmit.click();
}


public void CompareAndSaveCreateSuccessFully() throws Exception
{
	Thread.sleep(1000);
	CompareCreateMessage.isDisplayed();
}

public void CreateDUPLICATECompareAndSaveErrorMessage() throws Exception
{
	Thread.sleep(1000);
	CreateDuplicateCompareMessage.isDisplayed();
}


public void EmptyNameError() throws Exception
{
	Thread.sleep(1000);
	AddNewCompareEmptyNameError.isDisplayed();
}


public void EmptyExternalLinkError() throws Exception
{
	Thread.sleep(1000);
	AddNewCompareEmptyLinkError.isDisplayed();
}

public void VerifyTheUIofCompareAndSaveListing()
{
	CompareSaveListingName.isDisplayed();
	CompareSaveListingProfileImage.isDisplayed();
	CompareSaveListingExternalLink.isDisplayed();
	CompareSaveListingExternalLinkField.isDisplayed();
	CompareSaveListingViewDetails.isDisplayed();
}


}
