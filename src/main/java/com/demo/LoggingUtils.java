package com.demo;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
public class LoggingUtils {


	// TODO Auto-generated constructor stub
	public static  Logger logger = LogManager.getLogger(LoggingUtils.class);
	public static ExtentTest extentTest;

	public static void setExtentReports(ExtentReports extentReports,String testName) {
		extentTest = extentReports.createTest(testName, "Description of the default test");
	}

	public static void logInfo(String message) {
		logger.info(message);
		extentTest.log(Status.INFO, message);
	}

	public static void logPass(String message) {
		logger.info(message);
		extentTest.log(Status.PASS, message);
	}

	public static void logFail(String message) {
		try {
			// Capture screenshot
			String screenshotPath = captureScreenshot();

			// Log error message to Log4j
			//logger.error(message);

			// Log to ExtentReports with screenshot attachment
			extentTest.log(Status.FAIL, message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			
			//extentTest.log(Status.FAIL, message);
		} catch (Exception e) {
			// Handle exceptions related to capturing and attaching screenshots
			logger.error("Failed to capture and attach screenshot: " + e.getMessage());
		}
	}

	private static String captureScreenshot() {
		try {
			// Take screenshot
			TakesScreenshot ts = (TakesScreenshot) BrowserUtils.driver;
			byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);

			// Save screenshot with timestamp
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String screenshotPath = "screenshots/failure_" + timestamp + ".png";
			Files.write(Paths.get(screenshotPath), screenshotBytes);

			return screenshotPath;
		} catch (IOException e) {
			// Handle exceptions related to saving screenshots
			logger.error("Failed to save screenshot: " + e.getMessage());
			return "";
		}


	}
}


