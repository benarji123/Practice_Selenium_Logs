package com.demo.testcases;

import org.testng.annotations.Test;

import com.demo.BrowserUtils;
import com.demo.pages.Google;
import com.demo.pages.GoogleHomePage;

public class TC_001  extends BaseTest{
	@Test
    public void test() {
   	GoogleHomePage h=new GoogleHomePage(BrowserUtils.driver);
   	h.enterTextInGoogleSearc("selenium");
   	
    Google g=new Google(BrowserUtils.driver);
     g.clickOnSubmitButton();
   
    }
}
