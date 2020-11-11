package com.crm.qa.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.Base;

public class WebEventListener extends Base implements WebDriverEventListener{
	
	TestUtil testutil = new TestUtil();

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Alert Pop up occured");
		
	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("Alert is accepted successfully");
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Alert is cancelled successfully");
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Alert pop up occured");
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigate to:  '"+url+"'");
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigate to:  '"+url+"'");
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find element By: "+by.toString());
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Element found By: "+by.toString());
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: "+element.toString());
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: "+element.toString());
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Before Window Switching: "+windowName.toString());
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("After Window switch: "+windowName.toString());
		
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: "+error);
		try {
			testutil.takeScreenshotAtEndOfTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}

}
