package com.AceOnlineShoePoratl.Pages;

import com.AceOnlineShoePoratl.ElementsLocator.Elementlocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.AceOnlineShoePoratl.Utilities.CommonUtilis.*;

public class HomePage {
Elementlocator ele = new Elementlocator();
    private static final Logger log = LogManager.getLogger(HomePage.class);

      public void application_HomePage_display(){
        if(driver.findElement(By.xpath(ele.shoe_portal)).isDisplayed()){
            log.info("Application HomePage displayed");
            System.out.println(ele);
            //System.out.println("Application is successfully launched");
        }else{
            log.info("Application HomePage not displayed");
            //System.out.println("Application is not successfully launched");
        }
        }

        public void application_home_logo(){
          /*if(driver.findElement(By.id(ele.shoe_portal_logo)).isDisplayed()){
              log.info("Application HomePage logo displayed");
          }else {
              log.info("Application HomePage logo not displayed");
          }*/
        }
    }






