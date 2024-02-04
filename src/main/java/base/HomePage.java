package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[@for='fromCity']")
    private WebElement setFromCity;

    @FindBy(id = "fromCity")
    private WebElement setForFromCity;


    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement inputFromCity;

    @FindBy(xpath = "//label[@for='toCity']")
    private WebElement setToCity;

    @FindBy(xpath = "(//ul[@role='listbox']/li)[1]")
    private WebElement chooseFromCity;

    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement inputToCity;

    @FindBy(id = "toCity")
    private WebElement setForToCity;

    @FindBy(xpath = "(//ul[@role='listbox']/li)[1]")
    private WebElement chooseToCity;

    @FindBy(xpath = "//label[@for='departure']")
    private WebElement setDepartureDate;

    @FindBy(xpath = "//div[@aria-label='Wed Feb 14 2024']")
    private WebElement setDateForDeparture;

    @FindBy(xpath = "//div[@data-cy='returnArea']")
    private WebElement setReturnDate;

    @FindBy(xpath = "//div[@aria-label='Thu Feb 15 2024']")
    private WebElement setDateForReturn;

    @FindBy(xpath = "//a[text()='Search']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//html/body")
    private WebElement clickBlank;

    @FindBy(xpath = "//span[@data-cy='viewAllCta']")
    private WebElement textButtonViewAllOffers;

    public void inputOnFromCity(String input){
        setFromCity.click();
        inputFromCity.sendKeys(input);
        delay(3000);
        chooseFromCity.click();
    }

    public String setupFromCity(){
        return setForFromCity.getAttribute("value");
    }

    public void inputOnToCity(String input){
        setToCity.click();
        inputToCity.sendKeys(input);
        delay(3000);
        chooseToCity.click();
    }

    public String setupToCity(){
        return setForToCity.getAttribute("value");
    }

    public void setupDepartureDate(){
        setDateForDeparture.click();
        delay(1500);
        clickBlank.click();
    }

    public void setupReturnDate(){
        setReturnDate.click();
        delay(1500);
        setDateForReturn.click();
    }

    public void clickSearch(){
        buttonSearch.click();
    }

    public void clickViewAllOffers(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", textButtonViewAllOffers);
        textButtonViewAllOffers.click();
        delay(3000);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

}
