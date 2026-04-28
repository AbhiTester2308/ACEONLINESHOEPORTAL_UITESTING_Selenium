package com.AceOnlineShoePoratl.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public ConfigReader(){
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/Config.properties");
            prop = new Properties();
            prop.load(fis);
        }catch( Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public String getBrowser(){
        return prop.getProperty("browser");
    }

    public String getUrl(){
        return prop.getProperty("url");
    }

}
