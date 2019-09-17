package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEvenetListener;

public class TestBase
{
	
	 public static WebDriver driver;   //org.openqa.selenium package
	 public static Properties prop;  
	 public static EventFiringWebDriver e_driver;
	 public static WebEvenetListener eventListener;//java.util package
	
	public TestBase() // created constructor  but why constructor is created 
	{
		try
		{
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\S.Keshri\\Desktop\\Selenium\\Script\\Code\\Selenium\\com.wiproshell.Stabor\\src\\main\\java\\com\\crm\\qa\\config");//io package
		prop.load(ip);
		}
		
		catch(FileNotFoundException e)//java.io.package--Is it allowed to put two exception in one line like FileNotFound, IOException
		{
			e.printStackTrace();
		}
		catch( IOException e)//io.IOException package
		{
			e.printStackTrace();
		}
		
				
	}
	
	public static void initialization()
	{
		 String browserName= prop.getProperty("browser");
		 if(browserName.equals("Chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\S.Keshri\\Desktop\\Selenium\\Script\\Code\\Selenium\\com.wiproshell.Stabor\\Driver\\chromedriver.exe");
			 driver = new ChromeDriver();// org.openqa selenium package
		 }
		 
		 //else if(browserName.equals("Firefoex"))
		 //{
			// System.setProperty("webdriver.chrome.driver", "C:\\Users\\S.Keshri\\Desktop\\Selenium\\Script\\Code\\Selenium\\com.wiproshell.Stabor\\Driver\\chromedriver.exe");
			// driver = new FirefoxDriver();// org.openqa selenium package  
		// }
		 
		    e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEvenetListener();
			e_driver.register(eventListener);
			driver = e_driver;
		 
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		 driver.get(prop.getProperty("url"));
	}
	
	
	
	
	


	
	
	
	
	
	
	
	
}
