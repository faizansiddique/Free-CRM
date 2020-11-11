package com.crm.qa.test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends Base {

	String actualTitle = "CRMPRO - CRM software for customer relationship management, sales, and support.";

	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		loginpage = new LoginPage();
	}

	@Test
	public void loginPageTitle() throws InterruptedException {

		Thread.sleep(1000);
		String expectedTitle = loginpage.validateLoginPageTitle();
		System.out.println(expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void validateLogo_Links() throws InterruptedException {

		boolean flag = false;
		if (flag) {
			Thread.sleep(1000);
			loginpage.validateCRMLogo();
			Assert.assertTrue(flag, "Logo is visible");

			Thread.sleep(1000);
			loginpage.validateCustomersLink();
			Assert.assertTrue(flag, "Customers Link is visible");

			Thread.sleep(1000);
			loginpage.validateContactLink();
			Assert.assertTrue(flag, "Contact Link is visible");

			Thread.sleep(1000);
			loginpage.validateFeaturesLink();
			Assert.assertTrue(flag, "Features Link is visible");

			Thread.sleep(1000);
			loginpage.validatePricingLink();
			Assert.assertTrue(flag, "Pricing Link is visible");

			Thread.sleep(1000);
			loginpage.validateSignUpLink();
			Assert.assertTrue(flag, "Pricing Link is visible");
		}

	}

	@Test
	public void loginTest() throws InterruptedException{

			Thread.sleep(1000);
			homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
