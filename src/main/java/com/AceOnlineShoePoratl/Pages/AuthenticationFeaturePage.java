package com.AceOnlineShoePoratl.Pages;

import com.AceOnlineShoePoratl.ElementsLocator.Elementlocator;
import com.AceOnlineShoePoratl.Utilities.CommonUtilis;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class AuthenticationFeaturePage extends CommonUtilis {
    private static final Logger log = LogManager.getLogger(AuthenticationFeaturePage.class);
    Elementlocator ele = new Elementlocator();

      void navigateToRegisterationPage(){
          driver.findElement(By.xpath(ele.humbergermenu)).click();
          driver.findElement(By.xpath(ele.signin)).click();
          driver.findElement(By.xpath(ele.new_register)).click();
          if(driver.findElement(By.xpath(ele.registertaion_heading)).isDisplayed()){
              log.info("Registration Page is opened");
          }else{
              log.error("Registration Page is not opened");
          }
      }

      void fillRegistrationDetails(){

      }
}
