package org.example.utilities;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utilities {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    Actions action;

    public Utilities (@NotNull WebDriver webDriver, @NotNull Duration duration) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, duration);
        this.action = new Actions(this.webDriver);
    }

    public Utilities (@NotNull WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
        this.action = new Actions(this.webDriver);
    }

    public Utilities() {}

    public void scrollToView(WebElement webElement) {
        action.moveToElement(webElement).build().perform();
    }

    public void waitAndClick(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
}
