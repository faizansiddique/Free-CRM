package com.crm.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.Base;

public class TestUtil extends Base {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public void handleFrame(String frameName) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frameName);
	}

	public void takeScreenshotAtEndOfTest() throws IOException {

		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH); // 3
		int year = cal.get(Calendar.YEAR); // 2014
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.HOUR_OF_DAY);

		String currentDir = System.getProperty("user.dir");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
