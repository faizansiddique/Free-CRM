package com.crm.qa.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class DealsPageTest extends Base {

	String dealName = "AMDOCS";

	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TestUtil testutil;

	public DealsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();

		loginpage = new LoginPage();
		homepage = new HomePage();
		contactspage = new ContactsPage();
		dealspage = new DealsPage();
		testutil = new TestUtil();

		Thread.sleep(1000);
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

		testutil.handleFrame("mainpanel");

		Thread.sleep(1000);
		dealspage = homepage.clickOnDealsLink();

	}

	@Test
	public void validateDeals() throws InterruptedException {
		Thread.sleep(1000);
		dealspage.clickNewDeal();

		Thread.sleep(1000);
		dealspage.createDeal("Mr", "AMDOCS", "2123456789");

		Thread.sleep(1000);
		homepage.clickOnDealsLink();

		Thread.sleep(1000);
		testutil.handleFrame("mainpanel");

		Thread.sleep(1000);
		dealspage.deleteDeal("dealName");

		Thread.sleep(1000);
		String alertMsg = driver.switchTo().alert().getText();
		System.out.println("Alert Message :: " + alertMsg);
		driver.switchTo().alert().accept();

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
