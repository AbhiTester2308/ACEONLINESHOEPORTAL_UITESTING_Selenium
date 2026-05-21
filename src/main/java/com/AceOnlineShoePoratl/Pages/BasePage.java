package com.AceOnlineShoePoratl.Pages;

import com.AceOnlineShoePoratl.Utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver() {
        return DriverManager.getDriver();
    }

    protected WebDriverWait explicitWait() {
        return DriverManager.getWait();
    }

    protected void click(By locator) {
        explicitWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String text) {
        WebElement element = explicitWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return explicitWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return explicitWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void scrollIntoView(By locator) {
        WebElement element = explicitWait().until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver()).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }
}
