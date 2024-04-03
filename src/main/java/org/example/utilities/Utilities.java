package org.example.utilities;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Utilities {
    private static WebDriver webDriver;
    private static WebDriverWait webDriverWait;
    private static Actions action;

    public Utilities (@NotNull WebDriver webDriver, @NotNull Duration duration) {
        Utilities.webDriver = webDriver;
        Utilities.webDriverWait = new WebDriverWait(webDriver, duration);
        Utilities.action = new Actions(Utilities.webDriver);
    }

    public Utilities (@NotNull WebDriver webDriver) {
        Utilities.webDriver = webDriver;
        Utilities.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
        Utilities.action = new Actions(Utilities.webDriver);
    }

    public Utilities() {}

    public void scrollToView(WebElement webElement) {
        action.moveToElement(webElement).build().perform();
    }

    public void waitAndClick(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public @NotNull String $getAttributeValue (By elementLocator, String attributeName) {
        return webDriver.findElement(elementLocator).getAttribute(attributeName);
    }

    public @NotNull String $getAttributeValue (WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public void checkURL(String Url) {

        try {
            URL url = new URL(Url);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.connect();

            System.out.println(Url + " --> " + httpURLConnection.getResponseCode() + " " + httpURLConnection.getResponseMessage());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void uploadFile(@NotNull By locator, @NotNull String filePath) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(filePath);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        List<File> dirContents = Arrays.stream(Objects.requireNonNull(dir.listFiles())).toList();

        for (File dirContent : dirContents) {
            if (dirContent.getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContent.delete();
                return true;
            }
        }
        return false;
    }

    public static void refreshScreen() {
        try {
            webDriver.navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void refreshScreen(long delay) {
        try {
            Thread.sleep(delay);
            webDriver.navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void moveForward() {
        try {
            webDriver.navigate().forward();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void moveForward(long delay) {
        try {
            Thread.sleep(delay);
            webDriver.navigate().forward();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void moveBackward() {
        try {
            webDriver.navigate().back();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void moveBackward(long delay) {
        try {
            webDriverWait.wait(delay);
            webDriver.navigate().back();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dragANDropElement(WebElement OriginLoc, WebElement DestinationLoc) {
        webDriverWait.until(ExpectedConditions.visibilityOf(OriginLoc));
        webDriverWait.until(ExpectedConditions.visibilityOf(DestinationLoc));
        action.dragAndDrop(OriginLoc, DestinationLoc).build().perform();
    }
}
