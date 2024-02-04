package tests;

import base.HomePage;
import base.OffersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OffersTest extends BaseTest{

    @Test
    public void offersFilterCategory(){
       String expectedFilterCategory = "Trains";

        HomePage homePage = new HomePage(driver);
        OffersPage offersPage = new OffersPage(driver);

        homePage.clickViewAllOffers();

        offersPage.chooseRadioButtonRail();
        String actualOffersFilterCategory = offersPage.setupOffersFilterCategoryTrains();
        assertTrue(actualOffersFilterCategory, expectedFilterCategory, "Result Offers Filter Category");
    }

    private void assertTrue(String actual, String expected, String msg) {
        System.out.println("=============");
        System.out.println("Message: " + msg);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        System.out.println("=============");
        Assert.assertTrue(actual.contains(expected), msg);
    }
}
