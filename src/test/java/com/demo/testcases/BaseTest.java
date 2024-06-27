package com.demo.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.demo.BrowserUtils;
import com.demo.ExtentReportSetup;
import com.demo.LoggingUtils;

public class BaseTest {
	
	 @BeforeMethod
	 public void setUP() {
    	 String testCaseName = this.getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
         ExtentReportSetup.setUp();
    	 LoggingUtils.setExtentReports(ExtentReportSetup.extent,testCaseName);;
         BrowserUtils.openBrowser(testCaseName);
         BrowserUtils.openURL("https://www.google.co.in/");
	 }
     
     @AfterMethod
     public void tearDown(ITestResult r) {
    	 System.out.println(r.getStatus());
    	 ExtentReportSetup.extent.flush();
    	 BrowserUtils.closeBrowser();
    	 
     }
}
