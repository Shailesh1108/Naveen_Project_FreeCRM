package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase
{
	
	public ContactPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel_element;
	
	
	@FindBy(name= "first_name")
	WebElement fname_element;
	
	
	@FindBy(name= "last_name")
	WebElement lname_element;
	
	@FindBy(xpath="//div[@name=\"company\"]//input[1]")
	WebElement cname_element;
	
	//need to check
	@FindBy(xpath="//*[@id="dashboard-toolbar"]/div[2]/div/button[2]")
	WebElement SaveBtn_Element;
	
	
	public boolean verifyContactLabel()
	{
		return contactsLabel_element.isDisplayed();
	}
	
	
	
	public void selectContactByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"+ "//preceding-sibling::td[@class ='datalistrow]//input[@name='contact_id']")).click();
		
	}
	
	public void CreateNewContact(String title, String FirstName, String LastName, String Cname_element   )
	{
		Select select = new Select(driver.findElement(By.name("title")));//select class is from support UI package 
		select.selectByVisibleText(title);
		fname_element.sendKeys(FirstName);
		lname_element.sendKeys(LastName);
		
	}

}
