package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Test1 {
static WebDriver driver;

	


public static void main(String[] args) throws Exception {
	Test1.test1();
}

//@Test
	public static void test1() throws Exception
	{
		WebDriverManager.chromedriver().setup();
	//	driver=new ChromeDriver();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

     driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://dev-admin.elderlylife.co.uk/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@el.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin@1234");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]/div[1]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[4]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[4]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[2]/a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath(""));
		
		
		
//		JavascriptExecutor executor=(JavascriptExecutor)driver;
//		WebElement AddNewCompareImageUpload=driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/img[1]"));
//		AddNewCompareImageUpload.sendKeys("E:\\SikuliTest\\download.png");
		//executor.executeScript("arguments[0].value='E:\\SikuliTest\\download.png';", AddNewCompareImageUpload);
		
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
}



//}
