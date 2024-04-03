package org.example.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class CommonObj {
    private WebDriver webDriver;

    public CommonObj(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }


    @FindBy(xpath = "//div[@aria-label=\"Main menu\" and @role=\"button\"]")
    public WebElement $sideMenu;

    @FindBy(xpath = "//div[@id=\"material-bar-custom-product-name\"]/child::a[contains(text(), \"Help\")]")
    public WebElement $NavigateToHomeScreen;

    @FindBy(xpath = "//a[@aria-label=\"Google apps\" and @role=\"button\"]")
    public WebElement $googleAppsBtn;

    @FindBy(xpath = "//div[@class=\"gb_Ud\"]/child::a[@aria-label=\"Sign in\"]/span[text() = \"Sign in\"]")
    public WebElement $signInBtn;

    @FindBy(xpath = "//form[@class=\"promoted-search__form\"]/child::input[@placeholder=\"Describe your issue\"]")
    public Supplier<WebElement> $globalSearchField;

    @FindBy(xpath = "//form[@class=\"promoted-search__form\"]/child::button[@class=\"promoted-search__search-button\"]")
    public Supplier<WebElement> $searchBtn;

    public Function<String, WebElement> $ProuctHelpCard = (productHelpCards) -> webDriver.findElement(By.xpath("//a[@data-stats-id=\"" + productHelpCards + "\"]"));

    public List<String> getSearchResults() {
        List<WebElement> elements = webDriver.findElements(By.xpath("//ul[@class=\"scSearchSearch_results_listSearchresultslistsearch-results-container\"]/child::li[@class=\"scSearchSearch_results_listSearchresultslistitem-wrapper\"]/a/descendant::html-blob[2]"));

        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
