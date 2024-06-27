package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

public class WebDriverMethods {

	public WebDriverMethods() {
		// TODO Auto-generated constructor stub
	}

	public static void clickOnElement(WebElement element) {
		try {
			String elementDescription = getElementDescription(element);
			
			// Use JavaScriptExecutor to get the inner HTML of the WebElement
           // JavascriptExecutor jsExecutor = (JavascriptExecutor) BrowserUtils.driver;
           // String elementHtml = (String) jsExecutor.executeScript("return arguments[0].innerHTML;", element);
			 String elementHtml = element.getAttribute("outerHTML");
			// Log to Log4j
			LoggingUtils.logger.info("Clicking on \n" + getHtml(element));
			// Log to extent
			LoggingUtils.extentTest.log(Status.INFO,"Clicking on " + elementDescription);
			// Click on the element
			element.click();
		} catch (Exception e) {
			LoggingUtils.logFail(e.getMessage());
		}

	}

	public static void enterTextInElement(WebElement element, String text) {

		try {
			String elementDescription = getElementDescription(element);

			// Log to Log4j
			LoggingUtils. logger.info("Entering text: " + text + " into \n" + getHtml(element));

			// Enter text into the element
			LoggingUtils.extentTest.log(Status.INFO, "Entering text: " + text + " into " + elementDescription);

			// Clear text in the element
			    element.clear();
			
			// Enter text in the element
			   element.sendKeys(text);
			   
		} catch (Exception e) {
			LoggingUtils.logFail(e.getMessage());
		}
	}

	public static String getElementDescription(WebElement element) {
		//Get information about the element for logging
		StringBuilder description = new StringBuilder("element with ");
		description.append("tag name: ").append(element.getTagName()).append(", ");
		description.append("ID: ").append(element.getAttribute("id")).append(", ");
		description.append("class: ").append(element.getAttribute("class")).append(", ");
		description.append("text: ").append(element.getText());
		
		return description.toString();
	}
	public static String getHtml(WebElement element) {
		
		String elementHtml = element.getAttribute("outerHTML");
		return elementHtml;
	}
	public static void logFlus() {

	}
}
