package com.AceOnlineShoePoratl.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class BrowserSetUp extends CommonUtilis {

    private static final Logger log = LogManager.getLogger(BrowserSetUp.class);

    public static void application_Launch() {
        ConfigReader config = new ConfigReader();
        String browser = config.getBrowser();
        switch(browser.toLowerCase()){
             case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                driver = new EdgeDriver(new EdgeOptions());
                break;

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(new ChromeOptions());
                break;
        }
        //Detect Jenkins
        driver.manage().window().maximize();
        driver.get(config.getUrl());
        log.info("Browser setup started");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));



    }
    public static  void application_Quit(){

        //driver.quit();
    }
}
