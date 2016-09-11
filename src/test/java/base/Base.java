package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;
	
	
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
	
	public void closerowser(){
		
	}
	public void navigate(){
	
	}
	public void click(){
		
	}
	public void type(){
		
	}
	public void reportPass(){
		
	}
	public void reportFail(){
		
	}
	public void takeScreenShot(){
		
	}
}
