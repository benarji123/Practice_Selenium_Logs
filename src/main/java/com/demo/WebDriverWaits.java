package com.demo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class WebDriverWaits {
	public static final int TIMEOUT_SECONDS = 10;
	public WebDriver driver;
	public WebDriverWaits(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
    public void waitForElementClickable(WebElement el) {
    	try {
            // Log to Log4j
    		LoggingUtils.logger.info("Waiting for element to be clickable: " + WebDriverMethods.getElementDescription(el));

            // Log to ExtentReports
            LoggingUtils.extentTest.log(Status.INFO, "Waiting for element to be clickable: " + WebDriverMethods.getElementDescription(el));

            new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS))
                    .until(ExpectedConditions.elementToBeClickable(el));
        } catch (Exception e) {
           // handleException("Failed to wait for element to be clickable: " + e.getMessage(), e);
        	LoggingUtils.logFail(e.getMessage());
        }
    }

    public void  waitForElementVisible(WebElement el) {
    	try {
            // Log to Log4j
    		LoggingUtils.logger.info("Waiting for element to be visible: " + WebDriverMethods.getElementDescription(el));

            // Log to ExtentReports
            LoggingUtils.extentTest.log(Status.INFO, "Waiting for element to be visible: " + WebDriverMethods.getElementDescription(el));

            new WebDriverWait(driver,  Duration.ofSeconds(TIMEOUT_SECONDS))
                    .until(ExpectedConditions.visibilityOf(el));
        } catch (Exception e) {
        	LoggingUtils.logFail(e.getMessage());
        }
    }

}
