package com.wd.core;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.OhrmBase;



public class SeleniumWrapper extends OhrmBase {
//	https://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html
	private static final Logger logger = Logger.getLogger(SeleniumWrapper.class);
	public static void click(By locator) {
		try {
			getElement(locator).click();
			System.out.println("clicked on "+locator);
			logger.info("clicked on "+locator);
		} catch (RuntimeException e) {
			System.out.println("Failed to click");
			logger.error("Failed to click on"+locator);
			throw e;
		}
	}
	
	public static void enterText(By locator, String val) {
		try {
			getElement(locator).clear();
			getElement(locator).sendKeys(val);
			System.out.println(val+" entered on "+locator);
			logger.info(val+" entered on "+locator);
		} catch (RuntimeException e) {
			System.out.println("Failed to enter text");
			logger.info("Failed to enter text on "+locator);
			throw e;
		}
	}
	
	public static void selectItem(By locator, String val) {
		try {
			new Select(getElement(locator)).selectByVisibleText(val);
			System.out.println(val+" selected on "+locator);
			logger.info(val+" selected on "+locator);
		} catch (RuntimeException e) {
			System.out.println("Failed to select item");
			logger.info("Failed to enter select "+val +" from "+locator);
			throw e;
		}
	}
	public static boolean isElementExist(By locator) {
		
		try {
			getDriver().findElement(locator);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
