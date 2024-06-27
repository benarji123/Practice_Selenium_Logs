package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.LoggingUtils;
import com.demo.WebDriverMethods;
import com.demo.WebDriverWaits;

public class Google {
	public static WebDriver driver;
	 public static WebDriverWaits w;
	@FindBy(xpath="//input[@type='submi']")
	private WebElement searchbutton;
	public Google(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		w=new WebDriverWaits(driver);
	}
  public void clickOnSubmitButton() {
	  w.waitForElementVisible(searchbutton);
	  WebDriverMethods.clickOnElement(searchbutton);
  }
}
