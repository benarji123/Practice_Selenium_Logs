package com.demo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportSetup {
  
	
	public static ExtentSparkReporter Reporter;
	public static ExtentReports   extent;
	public static void setUp() 
	{
	        Reporter = new ExtentSparkReporter("extent-report.html");
	     // Configuring report settings
	        Reporter.config().setDocumentTitle("AutomationReport");
	        Reporter.config().setReportName("Demo");
	        Reporter.config().setTheme(Theme.STANDARD);
	        extent = new ExtentReports();
	        extent.attachReporter(Reporter);
	       
	        
	       
	}
	

}
