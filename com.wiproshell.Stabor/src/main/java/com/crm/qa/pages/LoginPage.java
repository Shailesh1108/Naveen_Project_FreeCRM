package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(name="username")//package open.qa selenium
	@CacheLookup //Its helps to improve the performance, it used to keep element in the memory and  uses from memory, not required to go to browser everytime
	   // Disadvantage- once page is refreshed then memory got disturbed/empty so uses only when page is not refreshed or it can cause stae element refresh exception 
	WebElement username_element;//package open qa selenium
	
	@FindBy(name="password")//package open qa.selenium
	WebElement password_element;//package open.qa selenium
	
	@FindBy(xpath="//input[@type='submit]")
	WebElement loginBtn_element;
	
	
	@FindBy(xpath="//button[contains(text(),'SignUp']")
	WebElement SignUP_element;
	
	
	@FindBy(xpath= 	"//img[contains(@class,'img-responsive')]")
	WebElement crmLogo_element;
	
	
	public LoginPage()
	{
		//Initilazing the page 
		PageFactory.initElements(driver,this);//package open qa selenium support
		//we can write LoginPage.class instead of this , it represents current class method
	}
	
	//Actions
	public String  ValidateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean ValidateCRMImage()
	{
		 return crmLogo_element.isDisplayed();
	}
	
	public HomePage login(String un,String pwd)
	{
		username_element.sendKeys(un);
		password_element.sendKeys(pwd);
		loginBtn_element.click();
		
		return new  HomePage();
		
	}
	
	
}
