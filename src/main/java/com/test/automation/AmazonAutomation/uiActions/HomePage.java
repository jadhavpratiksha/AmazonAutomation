package com.test.automation.AmazonAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	WebDriver driver;

	@FindBy(xpath = "//a[@id='nav-link-yourAccount']/span[2]") WebElement lnkYourOrders;
	@FindBy(xpath = "//div[@id='nav-flyout-ya-signin']/a/span") WebElement lnkSignIn;
	@FindBy(xpath = "//div[@class = 'a-box-inner a-padding-extra-large']/h1") WebElement txtLogin;
	@FindBy(xpath = "//div[@id='nav-flyout-ya-newCust']/a") WebElement lnkNewCustomer;
	@FindBy(xpath = "//input[@id='ap_customer_name']") WebElement txtbxCustomerName;
	@FindBy(xpath = "//input[@id='ap_phone_number']") WebElement txtbxMobileNo;
	@FindBy(xpath = "//input[@id='ap_email']") WebElement txtbxEmailId;
	@FindBy(xpath = "//input[@id='ap_password']") WebElement txtbxPassword;
	@FindBy(xpath = "//input[@id='continue']") WebElement btnContinue;
	@FindBy(xpath = "//input[@id='ap_email']") WebElement txtbxEmail;
	@FindBy(xpath = "//input[@id='signInSubmit']") WebElement btnLogin;
	@FindBy(xpath = "//a[@id='nav-link-yourAccount']/span[1]") WebElement txtSuccessfulLogin;
	
	
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Navigation to Login Link
	public void navigateToLoginPage() throws Exception
	{
		Actions action = new Actions(driver);
		log.info("Clicked on Your Orders");
		action.moveToElement(lnkYourOrders).build().perform();
		Thread.sleep(5000);
		log.info("Clicked on Sign In");
		lnkSignIn.click();
		Thread.sleep(5000);
		
	}
	
	public void enterLoginDetails(String email, String pwd)
	{
		log.info("Enter Email Id");
		txtbxEmail.sendKeys(email);
		log.info("Enter Password");
		txtbxPassword.sendKeys(pwd);
		log.info("Click on Login Button");
		btnLogin.click();
		
	}
	
	public String getLoginPageText() 
	{
		log.info("Login Page text is:- "+txtLogin.getText());
		return txtLogin.getText();
	}
	
	public String getSuccessfulLoginText()
	{
		log.info("Successful Login Page text is:- "+txtSuccessfulLogin.getText());
		return txtSuccessfulLogin.getText();
	}
	
	public void navigateToNewCustomerLink() throws Exception
	{
		Actions action = new Actions(driver);
		log.info("Clicked on Your Orders");
		action.moveToElement(lnkYourOrders).build().perform();
		Thread.sleep(5000);
		log.info("Clicked on New Customer Link");
		lnkNewCustomer.click();
		Thread.sleep(2000);
		
	}
	
	public void registerUser(String cname, String mobileNo, String pwd)
	{
		log.info("Enter Customer info");
		txtbxCustomerName.clear();
		txtbxCustomerName.sendKeys(cname);
		txtbxMobileNo.clear();
		txtbxMobileNo.sendKeys(mobileNo);
		txtbxPassword.clear();
		txtbxPassword.sendKeys(pwd);
		log.info("Click on Continue button");
		btnContinue.click();
	}
}
