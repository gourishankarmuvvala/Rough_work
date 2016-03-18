package rough_pack;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Rough_cls 
{
	
		public static String 				Browser,screenshots_path,filename;
		public static WebDriver 			wbdv = null;
		public static EventFiringWebDriver  driver = null;
			
		@Parameters("browser")
		@Test
		public void testApp(String b) throws MalformedURLException
		{
			Browser = b.toString();
			System.out.println(b); 
								
			if(b.equals("firefox"))
			{
				wbdv 	= new FirefoxDriver();
				driver 	= new EventFiringWebDriver(wbdv);				
			}
			else if (b.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","F:\\TestRail_Code_Workspace\\Rough_Work\\Drivers\\chromedriver.exe");
				wbdv 	= new ChromeDriver();
				driver 	= new EventFiringWebDriver(wbdv);
			}
			else if (b.equals("iexplore"))
			{
				System.setProperty("webdriver.ie.driver","F:\\TestRail_Code_Workspace\\Rough_Work\\Drivers\\IEDriverServer.exe");
				wbdv 	= new InternetExplorerDriver();
				driver 	= new EventFiringWebDriver(wbdv);
			}
			
		}	

		@Test
		public void navigate()
		{
			driver.navigate().to("https://qa-display.ignitionone.com/campaigns?clientId=30233&companyBusinessUnitId=105002");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			screenshots_path = System.getProperty("user.dir")+"\\Rough_Work\\Reports_Folder";
			filename = Browser+"_";
			ReporterDemo.takeScreenShot(screenshots_path+filename);
		}
		
		@Test
		public void input_username()
		{
			driver.findElement(By.xpath("//*[@id='Username']")).sendKeys("TestUser1");
			ReporterDemo.takeScreenShot(screenshots_path+filename);
		}
		
		@Test
		public void input_password()
		{
			driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Testuser2");
			ReporterDemo.takeScreenShot(screenshots_path+filename);
		}
		
		@Test
		public void click()
		{
			driver.findElement(By.xpath("//*[@id='RememberMe']")).click();
			ReporterDemo.takeScreenShot(screenshots_path+filename);
		}
		
		@AfterSuite
		public static void endScript()
		{
			driver.quit();
		}
}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*System.setProperty("webdriver.chrome.driver","F:\\TestRail_Code_Workspace\\Rough_Work\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://qa-dms.ignitionone.com/");*/
		
		// IE
		
		/*System.setProperty("webdriver.ie.driver","F:\\TestRail_Code_Workspace\\Rough_Work\\Drivers\\IEDriverServer.exe");
		
		WebDriver driver1 = new InternetExplorerDriver();
		
		driver1.get("https://qa-dms.ignitionone.com/");
		Thread.sleep(7000L);;
		driver1.findElement(By.xpath("//*[@id='Username']")).sendKeys("gourisankar");
		Thread.sleep(2000L);;
		driver1.findElement(By.xpath("//*[@id='Password']")).sendKeys("gourisankar");
		*/
		
		
		
		/*String File = "F:\\keyword_driven_rep\\Test1.pdf";
			
		try 
		{		      
			Document document = new Document();
			//PdfWriter.getInstance(document,new FileOutputStream(File));
	        document.open();
	        document.add(new Paragraph("Test Para : 1"));
	        
	        // null, failTable = null;
	        
	        PdfPTable successTable = new PdfPTable(new float[]{.3f, .3f, .1f, .3f});
			Paragraph p = new Paragraph("PASSED TESTS", new Font(FontFamily.HELVETICA, Font.DEFAULTSIZE, Font.BOLD));
			p.setAlignment(Element.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell(p);
			cell.setColspan(4);
			cell.setBackgroundColor(BaseColor.ORANGE);
			successTable.addCell(cell);
			
			
			
	        
	        
	        
	        
	        
	        
	        
	        document.close();
		    //Paragraph paragraph = new Paragraph();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
*/		
	
	
	
	
	
	
	/*
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public static WebDriver getdriver()
	{
		driver = new FirefoxDriver();
		return driver;
	}
	
	//@Test(priority=1)
	public static void openbrowser()
	{
		driver.get("https://gouri.testrail.net/index.php?/auth/login/");
		wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/form/div[4]/button")));
        //lstr.onTestSuccess(ITestResult result);
	}
	//@Test(priority=2)
	public static void login()
	{
		//driver = getdriver();
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys("gourishankar.test@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("7829448675");
		driver.findElement(By.xpath("//*[@id='rememberme']")).click();
	}

	public static void main(String[] args) 
	{
		driver = new FirefoxDriver();
		openbrowser();
		login();
		
		
		//driver.get("https://gouri.testrail.net/index.php?/auth/login/");

	}
	*/


