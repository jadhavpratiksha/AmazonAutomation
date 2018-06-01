package com.test.automation.AmazonAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase 
{
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	String browser = "chrome";
	String url = "https://www.amazon.in/";
	
	public void init() 
	{
		selctBrowser(browser);
		getUrl(url);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
	}
	
	public void selctBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			log.info("Creating object of :"+browser);
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Chrome"))
		{
			log.info("Creating object of :"+browser);
			System.setProperty("webdriver.chrome.driver", "D:\\Learning\\AmazonAutomation\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	}
	
	public void getUrl(String url)
	{
		log.info("Navigating to :"+url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
