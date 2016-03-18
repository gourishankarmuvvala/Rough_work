package rough_pack;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReporterDemo extends Rough_cls
{
	
	
	public static void takeScreenShot(String filePath) 
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	    try
	    {
			FileUtils.copyFile(scrFile, new File(filePath));
		}
	    catch (IOException e) 
	    {
				e.printStackTrace();
		}	
	}
	
	
	public static void zip(String filepath)
	 {
	 	try
	 	{
	 		File inFolder  			= new File(filepath);
	 		File outFolder 			= new File("Reports.zip");
	 		ZipOutputStream out 	= new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
	 		BufferedInputStream in  = null;
	 		
	 		byte[] data  = new byte[1000];
	 		String files[] = inFolder.list();
	 		
	 		for (int i=0; i<files.length; i++)
	 		{
	 			in = new BufferedInputStream(new FileInputStream
	 			(inFolder.getPath() + "/" + files[i]), 1000);  
	 			out.putNextEntry(new ZipEntry(files[i])); 
	 			
	 			int count;
	 			
	 			while((count = in.read(data,0,1000)) != -1)
	 			{
	 				out.write(data, 0, count);
	 			}
	 			out.closeEntry();
	 		}
	 		
	 		out.flush();
	 		out.close();
	 	}
	 	catch(Exception e)
	 	{
	 		e.printStackTrace();
	 	} 
	 }	

	
	
	
	
	/*@Test
    public void testReport()
	{
        
        WebDriver driver=new FirefoxDriver();
        
        Reporter.log("Browser Opened");
        
        driver.manage().window().maximize();
        
        Reporter.log("Browser Maximized");
        
        driver.get("http://www.google.com");
        
        Reporter.log("Application started");
        
        driver.quit();
        
        Reporter.log("Application closed");
        
    }
*/

/*@Test
public void testreport()
{
	WebDriver driver = new FirefoxDriver();
	Reporter.log("Browser Instanciated and Opened");
    driver.manage().window().maximize();
	Reporter.log("Browser Maximized");
	driver.get("http://www.google.com");
	Reporter.log("Application started");
	driver.quit();
	Reporter.log("Application closed");
	
}
*/}