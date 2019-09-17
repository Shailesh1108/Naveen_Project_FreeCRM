package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	
	public LoginPage loginPage;
	 public HomePage homePage;
	 TestUtil testUtil;
	 ContactPage contactsPage;
	 

	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void SetUp()
	{
		testUtil= new TestUtil();
		initialization();
		loginPage= new LoginPage();
		ContactPage contactsPage= new ContactPage();
		homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage= homePage.clickonContactsLink();
		 
	}
	
	@Test(priority=1,enabled= false)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactLabel(), "contact label is missing in the page");
	}
	
	@Test(priority=2,enabled= false)
	
		public void selectSingleContactTest()
		{
		contactsPage.selectContactByName("test2 test2");
		}
	
	
	@Test(priority=3,enabled= false)
	
	public void selectMultipleContactTest()
	{
		contactsPage.selectContactByName("test2 test2");
	   ContactPage.selectContactByName("test3 test3"); //for multiple selection	
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority =4, dataProvider= "getCRMTestData")
	public void ValidateCreateNewContact(String title , String firstname,String lastName, String Company)
	{
		homePage.clicknewContact();
		contactsPage.CreateNewContact(title,firstname,lastName,Company);
		
	}
	
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	

}
