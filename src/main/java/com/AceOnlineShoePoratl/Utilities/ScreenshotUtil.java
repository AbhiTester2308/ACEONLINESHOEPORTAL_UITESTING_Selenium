package com.AceOnlineShoePoratl.Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotUtil {

    private ScreenshotUtil() {
    }

    public static String capture(String scenarioName) {
        try {
            ConfigReader config = new ConfigReader();
            Path dir = Path.of(config.getScreenshotDir());
            Files.createDirectories(dir);
            String safeName = scenarioName.replaceAll("[^a-zA-Z0-9-_]", "_");
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Path file = dir.resolve(safeName + "_" + timestamp + ".png");
            byte[] bytes = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            Files.write(file, bytes);
            return file.toAbsolutePath().toString();
        } catch (IOException e) {
            return null;
        }
    }
}
