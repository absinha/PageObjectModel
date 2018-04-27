package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase  {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver; // Create the object of event firing webdriver class to use webeventlistners
	public static WebEventListener eventListener;
	
	public TestBase(){
		
		try {
			File file= new File ("E:\\MySelFolder\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			FileInputStream ip= new FileInputStream(file);
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome"))
			System.setProperty("webdriver.chrome.driver","E:\\MySelFolder\\chromedriver_win32\\2.38\\chromedriver.exe");
			driver= new ChromeDriver();
		
		/*else if (browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver","E:\\MySelFolder\\chromedriver_win32\\2.33\\geckodriver.exe");
			//driver= new Firef();
		}*/
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
	

}
