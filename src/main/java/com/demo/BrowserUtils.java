package com.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtils {
	//private static final Logger logger = LogManager.getLogger(LoggingUtils.class);
	
	public static WebDriver driver;

	 public static void openBrowser(String testCaseName) {
		
		 String BrowserType="chrome";
			//Launch the browser
	      	if(BrowserType.equalsIgnoreCase("chrome")) {
	      		
	      		WebDriverManager.chromedriver().setup();
	      		driver=new ChromeDriver();
	      	}else if(BrowserType.equalsIgnoreCase("") ){
	      		WebDriverManager.firefoxdriver().setup();
	      		driver=new FirefoxDriver();
	      	}else if(BrowserType.equalsIgnoreCase("edge")) {
	      		WebDriverManager.edgedriver().setup();
	      		driver=new EdgeDriver();
	      	}
	      	   // LoggingUtils.logInfo("Test Case: " + testCaseName);
		        LoggingUtils.logInfo("Opening the browser...");
	        
	    }
	 
	 public static void openURL(String url) {
		    LoggingUtils.logInfo("Opening URL: " + url);
		     driver.get(url);

		   }
	   

	    public static void closeBrowser() {
	        LoggingUtils.logInfo("Closing the browser...");
            driver.close();
	        // Add code to close the browser
	        // ...
	    }

}
