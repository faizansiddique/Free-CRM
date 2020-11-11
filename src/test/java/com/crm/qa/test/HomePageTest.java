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

public class HomePageTest extends Base {

	String actualTitle = "CRMPRO";
	String actualUsername = "Faizan Siddique";

	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	TestUtil testutil;

	public HomePageTest() {
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

	}

	@Test
	public void homePageTitle() throws InterruptedException {
		Thread.sleep(1000);
		String expectedTitle = homepage.validateHomepageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test
	public void homePageUsername() throws InterruptedException {

		Thread.sleep(1000);
		String hpUsername = homepage.validateHomepageUsername();
		String[] splitUsername = hpUsername.split(":");
		String expectedUsername = splitUsername[1].trim();
		Assert.assertEquals(actualUsername, expectedUsername);

	}

	@Test
	public void contactsLink() throws InterruptedException {

		testutil.handleFrame("mainpanel");
		Thread.sleep(1000);
		contactspage = homepage.clickOnContactsLink();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
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
