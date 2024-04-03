package org.example.regression.support;

import org.example.pageObjects.CommonObj;
import org.example.pageObjects.LoginPageObj;
import org.example.utilities.Base;
import org.example.utilities.Utilities;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ForgotEmail extends Base {
    private LoginPageObj loginPageObj;
    private CommonObj commonObj;
    private Utilities utilities;

    @Before
    public void Init() {
        loginPageObj = new LoginPageObj(webDriver);
        commonObj = new CommonObj(webDriver);
        utilities = new Utilities(webDriver);
    }

    @Test
    public void Validate_forgotemail_funcationality () {
        webDriver.get(baseUrl);
        utilities.waitAndClick(commonObj.$signInBtn);
        Assert.assertEquals("Sign in - Google Accounts", webDriver.getTitle());
        loginPageObj._enterUserName("p0857473@gmail.com");
        loginPageObj.$forGotEmailBtn.get().click();
        Assert.assertTrue(webDriver.getCurrentUrl().contains("https://accounts.google.com/signin/v2/usernamerecovery"));
    }

    @After
    public void terminate() {
        loginPageObj = null;
    }
}
