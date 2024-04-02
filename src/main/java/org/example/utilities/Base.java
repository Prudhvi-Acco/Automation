package org.example.utilities;

import org.jetbrains.annotations.NotNull;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.time.Duration;
import java.util.Date;

public class Base {
    public String baseUrl = "https://support.google.com";
    public static WebDriver webDriver;

    @BeforeClass
    public static void setUp() {
        webDriver = Base.startApplication("Chrome");
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public static void close() {
        webDriver.quit();
    }

    private static @NotNull WebDriver startApplication(@NotNull String Name) {
        @NotNull WebDriver result;
        if (Name.equalsIgnoreCase("Firefox")) {
            result = new FirefoxDriver();
        } else if (Name.equalsIgnoreCase("Chrome")) {
            result = new ChromeDriver();
        } else if (Name.equalsIgnoreCase("IE")) {
            result = new InternetExplorerDriver();
        } else {
            result = new ChromeDriver();
        }
        return result;
    }

    public void getScreenshot(String name) {

    }
}
