package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class DealsPage extends Base {

	@FindBy(xpath = "//input[@value='New Deal']")
	WebElement newDealLink;

	@FindBy(xpath = "//input[@name='title']")
	WebElement title;

	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement companyName;

	@FindBy(xpath = "//input[@name='contact_lookup']")
	WebElement primaryContact;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement save;

	public DealsPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickNewDeal() {
		newDealLink.click();
	}

	public void createDeal(String titleName, String company_Name, String primary_Contact) {

		title.sendKeys(titleName);
		companyName.sendKeys(company_Name);
		primaryContact.sendKeys(primary_Contact);
		save.click();
	}

	public void deleteDeal(String name) {

		WebElement delDeal = driver
				.findElement(By.xpath("// a[@_name='" + name + "']//following::td[4]/a/i[@title='Delete']"));
		delDeal.click();
	}

}
