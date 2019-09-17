package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{
	
	@FindBy(xpath="//td[contains(text(),'User: Shailesh k')]")
	WebElement usernameLabel_element;
	
	@FindBy(xpath="//a[conatins(text(),'Contacts']")
	WebElement contactTab_element;
	
	@FindBy(xpath="//a[contains(text(),'Deals'")
	WebElement dealsTab_element;
	
	@FindBy(xpath="//a[conatins(text(),'Task')]")
	WebElement taskTab_element;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactClick_element;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver,this); //can write HomePage.class instead of this as its represents current class
	}
	
	
	public String VerifyHomePageTitle()
	{
		 return driver.getTitle();
	}
	
	public boolean verifyorrectUserName()
	{
		return usernameLabel_element.isDisplayed();
	}
	
	public ContactPage clickonContactsLink()
	{
		contactTab_element.click();
		return  new ContactPage();
	}
	
	public 	DealsPage clickonDealsLink()
	{
		dealsTab_element.click();
		return new DealsPage();
	}
	
	
	public TaskPage clickonTaskLink()
	{
		taskTab_element.click();
		return new TaskPage();
	}
	
	public void clicknewContact()
	{
		Actions  action = new Actions(driver);
		action.moveToElement(contactTab_element).build().perform();//package selenium interaction 
		// build and perform  will be used where more than one action is performed 
		//perform where only one actipn is done
		newContactClick_element.click();
		
	}
	
}
