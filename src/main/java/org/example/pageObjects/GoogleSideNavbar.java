package org.example.pageObjects;

import org.example.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

public class GoogleSideNavbar {
    private WebDriver webDriver;
    private Utilities utilities;

    public GoogleSideNavbar (WebDriver webDriver, Utilities utilities) {
        this.webDriver = webDriver;
        this.utilities = utilities;
    }

    public Supplier<WebElement> $helpCenter = () -> webDriver.findElement(By.xpath("//a[@id=\"onebar-helpcenter\" and @role=\"link\"]"));

    public Supplier<WebElement> $GoogleSearch = () -> webDriver.findElement(By.xpath("//a[@id=\"onebar-product\" and @role=\"link\"]"));

    public Supplier<WebElement> $PrivacyPolicy = () -> webDriver.findElement(By.xpath("//a[@id=\"onebar-privacy-policy\" and @role=\"link\"]"));

    public Supplier<WebElement> $TermsOfService = () -> webDriver.findElement(By.xpath("//a[@id=\"onebar-tos\" and @role=\"link\"]"));

    public Supplier<WebElement> $Feedback = () -> webDriver.findElement(By.xpath("//a[@id=\"onebar-feedback\" and @role=\"link\"]"));

    public void goToHelpCenter() {
        utilities.waitAndClick(this.$helpCenter.get());
    }

    public void goToGoogleSearch() {
        utilities.waitAndClick(this.$GoogleSearch.get());
    }

    public void goToPrivacyPolicy() {
        utilities.waitAndClick(this.$PrivacyPolicy.get());
    }

    public void goToTermsOfService() {
        utilities.waitAndClick(this.$TermsOfService.get());
    }

    public void goToFeedback() {
        utilities.waitAndClick(this.$Feedback.get());
    }
}
