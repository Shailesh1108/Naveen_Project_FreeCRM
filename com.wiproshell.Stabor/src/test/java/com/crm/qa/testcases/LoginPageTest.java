package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{

	 public LoginPage loginPage;
	 public HomePage homePage;
	 

	public LoginPageTest()
	{
		super();
	}
	
	


	@BeforeMethod()
	public void SetUp()
	{
		initialization();
		loginPage= new LoginPage();
	}


	@Test(priority= 1)
	public void  loginPageTitleTest()
	{
		String title = driver.getTitle();
		Assert.assertEquals(title,"#1 Free CRM forAny Business: Online Customer Relationship Software");
	}

	@Test(priority=2)
	public void  CRMLogoTest()
	{
		boolean flag = loginPage.ValidateCRMImage();
		Assert.assertTrue(flag);
	}


	@Test(priority=3)
	public void loginPageTest()
	{
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));//Encapsulation 
	}






	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
}


