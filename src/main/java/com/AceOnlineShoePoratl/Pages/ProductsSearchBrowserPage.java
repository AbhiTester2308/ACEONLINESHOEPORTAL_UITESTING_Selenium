package com.AceOnlineShoePoratl.Pages;

import com.AceOnlineShoePoratl.ElementsLocator.StoreLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsSearchBrowserPage extends BasePage {

    public void navigateToCatalog(String category) {
        click(StoreLocator.navMenuItem(category));
    }

    public void search(String keyword) {
        type(StoreLocator.SEARCH_BOX, keyword);
        List<WebElement> buttons = driver().findElements(StoreLocator.SEARCH_BUTTON);
        if (!buttons.isEmpty()) {
            buttons.get(0).click();
        }
    }

    public String getResultsHeaderText() {
        return getText(StoreLocator.RESULTS_HEADER);
    }

    public List<String> getProductTitlesAndDescriptions() {
        return driver().findElements(StoreLocator.PRODUCT_CARD).stream()
                .map(WebElement::getText)
                .filter(t -> !t.isBlank())
                .collect(Collectors.toList());
    }

    public void applyFilters(String category, String min, String max, String size, String color) {
        driver().findElement(StoreLocator.filterByText(category)).click();
        driver().findElement(StoreLocator.PRICE_MIN_INPUT).sendKeys(min);
        driver().findElement(StoreLocator.PRICE_MAX_INPUT).sendKeys(max);
        driver().findElement(StoreLocator.filterByText(size)).click();
        driver().findElement(StoreLocator.filterByText(color)).click();
    }

    public List<Double> getAllPrices() {
        return driver().findElements(StoreLocator.PRODUCT_PRICE_TEXT).stream()
                .map(e -> Double.parseDouble(e.getText().replaceAll("[^0-9.]", "")))
                .collect(Collectors.toList());
    }

    public void sortResults(String option) {
        WebElement dropdown = explicitWait().until(ExpectedConditions.presenceOfElementLocated(StoreLocator.SORT_DROPDOWN));
        new Select(dropdown).selectByVisibleText(option);
    }

    public List<String> getProductIdentifiers() {
        return driver().findElements(StoreLocator.PRODUCT_CARD).stream()
                .map(e -> e.getText().isBlank() ? e.getAttribute("id") : e.getText())
                .collect(Collectors.toList());
    }

    public String getCurrentPageText() {
        return driver().getPageSource();
    }

    public void clickNext() {
        click(StoreLocator.byText("Next"));
    }
}
