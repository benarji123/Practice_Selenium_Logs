package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.LoggingUtils;
import com.demo.WebDriverMethods;
import com.demo.WebDriverWaits;

public class GoogleHomePage {
   public static WebDriver driver;
  public static WebDriverWaits w;
	@FindBy(xpath="//textarea[@type='search']")
	private WebElement search;
	
	
	
	public GoogleHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		w=new WebDriverWaits(driver);
	}
   
  public void enterTextInGoogleSearc(String text) {
	  w.waitForElementVisible(search);
	  WebDriverMethods.enterTextInElement(search,text);
  }
}
