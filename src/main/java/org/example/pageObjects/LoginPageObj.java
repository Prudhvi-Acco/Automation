package org.example.pageObjects;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.File;
import java.util.Date;
import java.util.Objects;
import java.util.function.Supplier;

public class LoginPageObj {
    private WebDriver webDriver;

    public LoginPageObj(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Supplier<@NotNull WebElement> $userNameInputField = () -> webDriver.findElement(By.xpath("//input[@type=\"email\" and @name=\"identifier\"]"));

    public Supplier<@NotNull WebElement> $passwordInputField = () -> webDriver.findElement(By.xpath("//input[@type=\"password\" and @name=\"Passwd\"]"));

    public Supplier<@NotNull WebElement> $forGotEmailBtn = () -> webDriver.findElement(By.xpath("//button[@jsname=\"Cuz2Ue\" and text() = \"Forgot email?\"]"));

    private Supplier<@NotNull WebElement> $showPwdContainer = () -> webDriver.findElement(By.xpath("//div[@class=\"QTJzre NEk0Ve\"]"));

    public Supplier<@NotNull WebElement> $getCheckboxFromContainer = () -> $showPwdContainer.get().findElement(By.xpath("//div[ contains(@class, \"VfPpkd-MPu53c\")]"));

    public Supplier<@NotNull WebElement> $nextBtn = () -> webDriver.findElement(By.xpath("//span[@class=\"VfPpkd-vQzf8d\" and text()=\"Next\"]"));

    public void _enterUserName(@NotNull String userName) {
        try {
            this.$userNameInputField.get().click();
            this.$userNameInputField.get().clear();
            this.$userNameInputField.get().sendKeys(userName);
        } catch (NoSuchElementException noSuchElementException) {

            File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            file.renameTo(new File("C:\\Users\\Prudhvi\\IdeaProjects\\supportGoogle\\screenshots\\" + StackWalker.getInstance().walk(s -> s.skip(1).findFirst()).get().getMethodName() + new Date().getTime() + ".jpeg"));

            throw new NoSuchElementException("Unable to find the element with the given locator. Please check it and update!");
        }
    }

    public void _enterPassword(@NotNull String password) {
        try {
            this.$passwordInputField.get().click();
            this.$passwordInputField.get().clear();
            this.$passwordInputField.get().sendKeys(password);
        } catch (NoSuchElementException noSuchElementException) {

            File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            file.renameTo(new File("C:\\Users\\Prudhvi\\IdeaProjects\\supportGoogle\\screenshots\\" + StackWalker.getInstance().walk(s -> s.skip(1).findFirst()).get().getMethodName() + new Date().getTime() + ".jpeg"));

            throw new NoSuchElementException("Unable to find the element with the given locator. Please check it and update!");
        }
    }

    public void _displayPassword(@NotNull Boolean condition) {
        Assert.assertTrue($showPwdContainer.get().isDisplayed());
        if (!Objects.equals($getCheckboxFromContainer.get().isSelected(), condition))
            $getCheckboxFromContainer.get().click();
    }
}
