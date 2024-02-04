package tests;

import base.HomePage;
import base.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test
    public void searchFlightDate(){
        String expectedFromCity = "Bangkok";
        String expectedToCity = "Singapore";
        String expectedFilter = "REFUNDABLE FARES";
        String expectedDepartureDate = "Wed, Feb 14, 2024";
        String expectedReturnDate = "Thu, Feb 15, 2024";

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        homePage.inputOnFromCity(expectedFromCity);
        String actualFromCity = homePage.setupFromCity();
        assertEquals(actualFromCity, expectedFromCity, "Applied From City");

        homePage.inputOnToCity(expectedToCity);
        String actualToCity = homePage.setupToCity();
        assertEquals(actualToCity, expectedToCity, "Applied To City");

        homePage.setupDepartureDate();
        homePage.setupReturnDate();

        homePage.clickSearch();

        searchResultPage.clickPopUp();

        String actualSearchFromCity = searchResultPage.checkAppliedFromCity();
        assertTrue(actualSearchFromCity, expectedFromCity, "Search Result From City");
        String actualSearchToCity = searchResultPage.checkAppliedToCity();
        assertTrue(actualSearchToCity, expectedToCity, "Search Result To City");
        String actualDepartureDate = searchResultPage.checkAppliedDepartureDate();
        assertEquals(actualDepartureDate, expectedDepartureDate, "Applied Departure Date");
        String actualReturnDate = searchResultPage.checkAppliedReturnDate();
        assertEquals(actualReturnDate, expectedReturnDate, "Applied Return Date");

        searchResultPage.chooseRefundableFares();
        String actualFilter = searchResultPage.checkSearchAndFilterResult();
        assertEquals(actualFilter, expectedFilter, "Applied Filter Result ");
    }

    private void assertEquals(String actual, String expected, String msg) {
        System.out.println("=============");
        System.out.println("Message: " + msg);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        System.out.println("=============");
        Assert.assertEquals(actual, expected, msg);
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
