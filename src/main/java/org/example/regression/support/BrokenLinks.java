package org.example.regression.support;

import org.example.pageObjects.CommonObj;
import org.example.pageObjects.LoginPageObj;
import org.example.utilities.Base;
import org.example.utilities.Utilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinks extends Base {

    private Utilities utilities;

    @Before
    public void Init() {
        utilities = new Utilities(webDriver);
    }

    @Test
    public void validateLinks() {
        webDriver.get(baseUrl);

        List<WebElement> tags = webDriver.findElements(By.tagName("a"));

        List<String> urls = new ArrayList<>();

        System.out.println(tags.size());

        tags.forEach( element -> {
            urls.add(element.getAttribute("href"));
        });

        urls.stream().forEach(utilities::checkURL);
    }



    @After
    public void terminate() {
        utilities = null;
    }
}
