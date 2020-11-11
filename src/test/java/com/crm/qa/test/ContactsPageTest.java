package com.crm.qa.test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class ContactsPageTest extends Base {

	String contactToDelete = "shah faisal";
	String contactToSelect = "khan faisal";

	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	TestUtil testutil;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();

		loginpage = new LoginPage();
		homepage = new HomePage();
		contactspage = new ContactsPage();
		testutil = new TestUtil();

		Thread.sleep(1000);
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

		testutil.handleFrame("mainpanel");

		Thread.sleep(1000);
		contactspage = homepage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactLabel() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(contactspage.contactsLabel(), "Contact label is not visible");

	}

	@Test(priority = 2)
	public void createContact() throws InterruptedException {
		Thread.sleep(1000);
		contactspage.newContactLink();

		Thread.sleep(1000);
		contactspage.createNewContact("Mr.", "shah", "faisal", "AMDOCS");

	}

	@Test(priority = 3)
	public void deleteContact() throws InterruptedException {
		Thread.sleep(1000);
		contactspage.deleteContact(contactToDelete);

		Thread.sleep(1000);
		String alertMsg = driver.switchTo().alert().getText();
		System.out.println("Alert Message :: " + alertMsg);
		driver.switchTo().alert().accept();

	}

	@Test(priority = 4)
	public void selectContact() throws InterruptedException {
		Thread.sleep(1000);
		contactspage.selectContact(contactToSelect);

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		testutil.handleFrame("mainpanel");
		homepage.clickOnLogoutLink();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.quit();

	}

}
