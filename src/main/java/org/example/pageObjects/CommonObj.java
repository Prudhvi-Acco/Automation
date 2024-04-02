package org.example.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class CommonObj {
    private WebDriver webDriver;

    public CommonObj(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Supplier<WebElement> $sideMenu = () -> webDriver.findElement(By.xpath("//div[@aria-label=\"Main menu\" and @role=\"button\"]"));

    public Supplier<WebElement> $NavigateToHomeScreen = () -> webDriver.findElement(By.xpath("//div[@id=\"material-bar-custom-product-name\"]/child::a[contains(text(), \"Help\")]"));

    public Supplier<WebElement> $googleAppsBtn = () -> webDriver.findElement(By.xpath("//a[@aria-label=\"Google apps\" and @role=\"button\"]"));

    public Supplier<WebElement> $signInBtn = () -> webDriver.findElement(By.xpath("//div[@class=\"gb_Ud\"]/child::a[@aria-label=\"Sign in\"]/span[text() = \"Sign in\"]"));

    public Supplier<WebElement> $globalSearchField = () -> webDriver.findElement(By.xpath("//form[@class=\"promoted-search__form\"]/child::input[@placeholder=\"Describe your issue\"]"));

    public Supplier<WebElement> $searchBtn = () -> webDriver.findElement(By.xpath("//form[@class=\"promoted-search__form\"]/child::button[@class=\"promoted-search__search-button\"]"));

    public Function<String, WebElement> $ProuctHelpCard = (productHelpCards) -> webDriver.findElement(By.xpath("//a[@data-stats-id=\"" + productHelpCards + "\"]"));

    public String $getAttributeValue (By elementLocator, String attributeName) {
        return webDriver.findElement(elementLocator).getAttribute(attributeName);
    }

    public String $getAttributeValue (WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public List<String> getSearchResults() {
        List<WebElement> elements = webDriver.findElements(By.xpath("//ul[@class=\"scSearchSearch_results_listSearchresultslistsearch-results-container\"]/child::li[@class=\"scSearchSearch_results_listSearchresultslistitem-wrapper\"]/a/descendant::html-blob[2]"));

        return elements.stream().map(element -> element.getText()).collect(Collectors.toList());
    }
}
