package com.test.amazonautomation.testactions;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.automation.AmazonAutomation.testBase.TestBase;
import com.test.automation.AmazonAutomation.uiActions.HomePage;

public class HomePageTest extends TestBase
{
	public static final Logger log = Logger.getLogger(HomePageTest.class.getName());
	HomePage homepage;
	
	String email = "pratikshaa02@gmail.com";
	String pwd = "Amoljagdale19";
	String cname = "test";
	String mobileNo = "9168378739";
	String pwd1 = "Test@123";
	@BeforeTest
	public void setUp()
	{
		init();
	}

	@Test
	public void verifyLoginFunctionality() throws Exception 
	{
		log.info("=====================Statrting verifyNavigationToLoginPage Test====================");
		homepage = new HomePage(driver);
		homepage.navigateToLoginPage();
		Assert.assertEquals("Login", homepage.getLoginPageText());
		homepage.enterLoginDetails(email, pwd);
		Assert.assertEquals("Hello, Pratiksha", homepage.getSuccessfulLoginText());
		log.info("=====================Finished verifyNavigationToLoginPage Test====================");
	}
	
	public void verfiyRegistration() throws Exception
	{
		log.info("===========================Starting verifyRegistration Test===========================");
		homepage = new HomePage(driver);
		homepage.navigateToNewCustomerLink();
		homepage.registerUser(cname, mobileNo, pwd1);
	}
	
	@AfterClass
	public void endTest()
	{
		driver.quit();
	}
}
