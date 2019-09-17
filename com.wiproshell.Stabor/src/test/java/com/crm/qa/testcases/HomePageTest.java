package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase 
{

	 public LoginPage loginPage;
	 public HomePage homePage;
	 TestUtil testUtil;
	 ContactPage contactsPage;
	 

	public HomePageTest()
	{
		super();
	}
	
	//test cases should be separated -- independent with each other
	//before each test cases --launch the browser and login
	//after each test cases-- close the browser
	

	@BeforeMethod()
	public void SetUp()
	{
		testUtil= new TestUtil();
		initialization();
		loginPage= new LoginPage();
		ContactPage contactsPage= new ContactPage();
		homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1, enabled= false)	
	public void verifyHomePageTitle()
	{
		String homePageTitle = homePage.VerifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO ", "HomePage title is not matched");// import org.testng
	}
	
	@Test(priority=2,enabled= false)
	public void verifyUserNameTest()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyorrectUserName());
	}
	
	@Test(priority=3,enabled= false)
		public void verifyContactLinkTest()
		{
			testUtil.switchToFrame();
			contactsPage= homePage.clickonContactsLink();
		}
	

	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}

}
