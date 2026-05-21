package com.AceOnlineShoePoratl.Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private final Properties prop = new Properties();

    public ConfigReader() {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Config.properties")) {
            if (stream == null) {
                throw new IllegalStateException("Config.properties not found on classpath");
            }
            prop.load(stream);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load Config.properties", e);
        }
    }

    public String getBrowser() {
        return getOverride("browser", "BROWSER");
    }

    public String getUrl() {
        return getOverride("url", "APP_URL");
    }

    public String getSeleniumRemoteUrl() {
        String sys = System.getProperty("selenium.remote.url");
        if (sys != null && !sys.isBlank()) {
            return sys;
        }
        String env = System.getenv("SELENIUM_REMOTE_URL");
        if (env != null && !env.isBlank()) {
            return env;
        }
        return prop.getProperty("selenium.remote.url", "");
    }

    public int getExplicitWaitSeconds() {
        String value = getOverride("explicit.wait.seconds", "EXPLICIT_WAIT_SECONDS");
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 15;
        }
    }

    public String getScreenshotDir() {
        return prop.getProperty("screenshot.dir", "target/screenshots");
    }

    public boolean resetUrlAfterScenario() {
        return Boolean.parseBoolean(getOverride("reset.url.after.scenario", "RESET_URL_AFTER_SCENARIO"));
    }

    private String getOverride(String propertyKey, String envKey) {
        String sys = System.getProperty(propertyKey);
        if (sys != null && !sys.isBlank()) {
            return sys;
        }
        String env = System.getenv(envKey);
        if (env != null && !env.isBlank()) {
            return env;
        }
        return prop.getProperty(propertyKey);
    }
}
