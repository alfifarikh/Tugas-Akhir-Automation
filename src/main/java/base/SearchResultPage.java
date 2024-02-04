package base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BasePage{
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='OKAY, GOT IT!']")
    private WebElement buttonPopUpOkay;

    @FindBy(xpath = "//p[contains(text(),'Refundable Fares')]/parent::div/preceding-sibling::span/input")
    private WebElement checkboxRefundableFares;

    @FindBy(xpath = "//ul[@class='appliedFilter']/li")
    private WebElement appliedFilterRefundableFares;

    @FindBy(id = "fromCity")
    private WebElement appliedFromCity;

    @FindBy(id = "toCity")
    private WebElement appliedToCity;

    @FindBy(id = "departure")
    private WebElement appliedDepartureDate;

    @FindBy(id = "return")
    private WebElement appliedReturnDate;

    public void clickPopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='OKAY, GOT IT!']")));
        buttonPopUpOkay.click();
    }

    public void chooseRefundableFares(){
        try {
            checkboxRefundableFares.isDisplayed();
        } catch (NoSuchElementException ignored){
            System.out.println("Element Refundable Fares Not Found");
        }
        checkboxRefundableFares.click();
    }

    public String checkSearchAndFilterResult(){
        return appliedFilterRefundableFares.getText();
    }

    public String checkAppliedFromCity(){
        return appliedFromCity.getAttribute("value");
    }

    public String checkAppliedToCity(){
        return appliedToCity.getAttribute("value");
    }

    public String checkAppliedDepartureDate(){
        return appliedDepartureDate.getAttribute("value");
    }

    public String checkAppliedReturnDate(){
        return appliedReturnDate.getAttribute("value");
    }

}
