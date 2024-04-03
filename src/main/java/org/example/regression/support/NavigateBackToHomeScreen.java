package org.example.regression.support;

import org.example.enums.ProductHelpCards;
import org.example.pageObjects.CommonObj;
import org.example.utilities.Base;
import org.example.utilities.Utilities;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NavigateBackToHomeScreen extends Base {
    CommonObj commonObj;
    ProductHelpCards productHelpCards;
    Utilities utilities;

    @Before
    public void Init() {
        commonObj = new CommonObj(webDriver);
        productHelpCards = new ProductHelpCards();
        utilities = new Utilities(webDriver);
    }

    @Test()
    public void clicking_on_SHopping_card_Navigate_to_its_Screen() {
        webDriver.get(baseUrl);

        utilities.scrollToView(
                commonObj.$ProuctHelpCard.apply(
                        productHelpCards.getSHOPPING()
                )
        );

        String shoppingURL = utilities.$getAttributeValue(
                commonObj.$ProuctHelpCard.apply(productHelpCards.getSHOPPING()),
                "href");
        System.out.println(shoppingURL);

        Assert.assertTrue(
                commonObj
                        .$ProuctHelpCard.apply(productHelpCards.getSHOPPING())
                        .isEnabled()
        );

        commonObj.$ProuctHelpCard.apply(productHelpCards.getSHOPPING()).click();
        Assert.assertTrue(webDriver.getCurrentUrl().contains(shoppingURL));

        commonObj.$NavigateToHomeScreen.click();
        System.out.println(webDriver.getCurrentUrl());
        Assert.assertTrue(webDriver.getCurrentUrl().contains(shoppingURL.split("hl=en")[0]));
    }

    @After
    public void terminate() {
        commonObj = null;
        productHelpCards = null;
    }
}
