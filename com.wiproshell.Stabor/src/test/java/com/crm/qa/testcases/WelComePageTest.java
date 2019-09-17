package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.WelcomePage;

public class WelComePageTest extends TestBase
{
	public WelcomePage welComePage;

	public WelComePageTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void SetUp()
	{
		initialization();
		welComePage= new WelcomePage();
	}
	
	@Test(priority=1)
	public static  String ValidatefacebookIcon()
	{
	 return driver.getTitle();
	
	}
	
	
	
	
	
	
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
}
