package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Base;

public class ContactsPage extends Base {

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContact;

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement verifyContactsLbl;
	
	@FindBy(xpath = "//input[@value='New Contact']")
	WebElement verifyNewContact;
	
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='surname']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath = "//tr[1]/td/input[@value='Save' and @type='submit']")
	WebElement saveBtn;

	public ContactsPage() {

		PageFactory.initElements(driver, this);
	}

	public boolean contactsLabel() {
		return verifyContactsLbl.isDisplayed();
	}

	public void deleteContact(String name) {
		WebElement delContacts = driver
				.findElement(By.xpath("//a[@_name='" + name + "']//following::td[6]/a/i[@title='Delete']"));
		delContacts.click();
	}
	
	public void selectContact(String name){
		WebElement contactCheckBox = driver.findElement(By.xpath("//a[@_name='"+name+"']/parent::td/preceding-sibling::td/input[@name='contact_id']"));
		contactCheckBox.click();
	}
	
	public void newContactLink(){
		verifyNewContact.click();
	}
	public void createNewContact(String title, String first_Name, String last_Name, String company_Name){
		Select sel = new Select(driver.findElement(By.name("title")));
		sel.selectByVisibleText(title);
		
		firstName.sendKeys(first_Name);
		lastName.sendKeys(last_Name);
		company.sendKeys(company_Name);
		saveBtn.click();
		
	}

}
