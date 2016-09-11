package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;
import utility.ExtentManager;

public class Base {
	public WebDriver driver;
	public Properties prop;
	public ExtentReports rep = ExtentManager.getInstance();
	public ExtentTest test;
	
	
	public void openBrowser(){
		try {
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\projectConfig.properties");
		prop = new Properties();
		prop.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//String brow = prop.getProperty("browserType");
		if(prop.getProperty("browserType").equals("chrome")){
			System.setProperty("web.driver.chrome", System.getProperty("user.dir")+"//chromedriver.exe");
			driver = new ChromeDriver();
			//System.out.println(prop.getProperty("url"));
			driver.get(prop.getProperty("url"));
		}
		else if(prop.getProperty("browserType").equals("mozilla")){
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("url"));
		}
		
	}
	

	public WebElement getElement( String locator){
		WebElement element = null;
		if(locator.endsWith("id")){
			element = driver.findElement(By.id(prop.getProperty(locator)));
		}
		else if(locator.endsWith("xpath")){
			element = driver.findElement(By.xpath(prop.getProperty(locator)));
			}
		else{
			Assert.fail("Locator not found"+locator);
		}
		return element;
		
		
	}
	public void closerowser(){
		
	}
	public void navigate(){
	
	}
	public void click(){
		
	}
	public void type(){
		
	}
	public void reportPass(String msg2){
		test.log(LogStatus.PASS, msg2);
		
		
	}
	public void reportFail(){
		test.log(LogStatus.FAIL, "Failed...");
		takeScreenShot();
		
		
	}
	public void takeScreenShot(){
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO,"Screenshot-> "+ test.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
	}
}
