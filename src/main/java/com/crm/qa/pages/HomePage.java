package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;
import com.crm.qa.utilities.TestUtil;

public class HomePage extends Base {

	@FindBy(xpath = "/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement usernameLabel;

	@FindBy(xpath = "(//a[contains(text(),'Calendar')])[1]")
	WebElement calendarLink;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	@FindBy(xpath = "//a[@href='https://classic.freecrm.com/index.cfm?logout=1']")
	WebElement logoutLink;

	TestUtil testUtil;

	public HomePage() {

		testUtil = new TestUtil();
		PageFactory.initElements(driver, this);
	}

	public String validateHomepageTitle() {
		return driver.getTitle();
	}

	public String validateHomepageUsername() {
		testUtil.handleFrame("mainpanel");
		return usernameLabel.getText();
	}

	public CalendarPage clickOnCalendarLink() {
		calendarLink.click();
		return new CalendarPage();
	}

	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}

	public LoginPage clickOnLogoutLink() {
		logoutLink.click();
		return new LoginPage();
	}
	

}
