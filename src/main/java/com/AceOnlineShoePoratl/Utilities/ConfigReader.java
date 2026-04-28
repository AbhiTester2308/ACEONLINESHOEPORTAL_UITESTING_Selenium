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
        return getOverride("browser", "BROWSER");
    }

    public String getUrl(){
        return getOverride("url", "APP_URL");
    }

    public String getSeleniumRemoteUrl() {
        String sys = System.getProperty("selenium.remote.url");
        if (sys != null && !sys.isBlank()) return sys;

        String env = System.getenv("SELENIUM_REMOTE_URL");
        if (env != null && !env.isBlank()) return env;

        return prop.getProperty("selenium.remote.url");
    }

    private String getOverride(String propertyKey, String envKey) {
        String sys = System.getProperty(propertyKey);
        if (sys != null && !sys.isBlank()) return sys;

        String env = System.getenv(envKey);
        if (env != null && !env.isBlank()) return env;

        return prop.getProperty(propertyKey);
    }
}
