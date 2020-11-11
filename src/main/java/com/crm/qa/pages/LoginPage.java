package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class LoginPage extends Base {

	// Page Factory :
	@FindBy(name = "username")
	WebElement userId;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement SignIn;

	@FindBy(xpath = "(//a[@href='https://register.freecrm.com/register/'])")
	WebElement SignUp;

	@FindBy(xpath = "(//img[@class='img-responsive'])[1]")
	WebElement freeCRMLogo;

	@FindBy(xpath = "//a[contains(text(),'Features')]")
	WebElement featuresLink;

	@FindBy(xpath = "//a[contains(text(),'Pricing')]")
	WebElement pricingLink;

	@FindBy(xpath = "//a[contains(text(),'Customers')]")
	WebElement customersLink;

	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	WebElement contactLink;

	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateSignUpLink(){
		return SignUp.isDisplayed();
	}
	
	public boolean validateCRMLogo(){
		return freeCRMLogo.isDisplayed();
	}
	
	public boolean validateFeaturesLink(){
		return featuresLink.isDisplayed();
	}
	
	public boolean validatePricingLink(){
		return pricingLink.isDisplayed();
	}
	
	public boolean validateCustomersLink(){
		return customersLink.isDisplayed();
	}
	
	public boolean validateContactLink(){
		return contactLink.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		
		userId.clear();
		userId.sendKeys(un);
		
		password.clear();
		password.sendKeys(pwd);
		
		SignIn.click();
		
		return new HomePage();
	}
}
