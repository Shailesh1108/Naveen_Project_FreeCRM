package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class WelcomePage extends TestBase
{
	
	public WelcomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath= "//a[@title='Facebook Free CRM Page']")
	WebElement facebookicon_element;
	
	public String  ValidateWelcomePageTitle()
	{
		 return driver.getTitle();
	}

}
