package org.example.regression.support;

import org.example.enums.ProductHelpCards;
import org.example.pageObjects.CommonObj;
import org.example.utilities.Base;
import org.example.utilities.Utilities;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.util.List;

public class HelpCardResults extends Base {
    CommonObj commonObj;
    ProductHelpCards productHelpCards;
    Utilities utilities;

    @Before
    public void Init() {
        commonObj = new CommonObj(webDriver);
        productHelpCards = new ProductHelpCards();
        utilities = new Utilities(webDriver, Duration.ofSeconds(45));
    }

    @Test()
    public void clicking_on_SHopping_card_Navigate_to_its_Screen() {
        webDriver.get(baseUrl);

        utilities.scrollToView(
                commonObj.$ProuctHelpCard.apply(
                        productHelpCards.getGMAIL()
                )
        );

        String gmailURL = utilities.$getAttributeValue(
                commonObj.$ProuctHelpCard.apply(productHelpCards.getGMAIL()),
                "href");
        System.out.println(gmailURL);

        Assert.assertTrue(
                commonObj
                        .$ProuctHelpCard
                        .apply(productHelpCards.getGMAIL())
                        .isEnabled()
        );

        commonObj.$ProuctHelpCard.apply(productHelpCards.getGMAIL()).click();
        Assert.assertTrue(webDriver.getCurrentUrl().contains(gmailURL));

        commonObj.$globalSearchField.get().sendKeys("login");
        commonObj.$searchBtn.get().click();

        List<String> comments = commonObj.getSearchResults();

        Assert.assertFalse(comments.isEmpty());
    }

    @After
    public void terminate() {
        commonObj = null;
        productHelpCards = null;
    }
}
