package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OffersPage extends BasePage{
    public OffersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='RAIL']")
    private WebElement radioButtonRail;

    @FindBy(xpath = "//span[contains(text(),'Trains')]")
    private WebElement appliedRadioButtonTrains;

    @FindBy(xpath = "(//div[@data-cy='eachOfferItem'])[1]/p[1]")
    private WebElement offersCardTag;

    public void chooseRadioButtonRail(){
        ((JavascriptExecutor) driver).executeScript("document.getElementById(\"RAIL\").click();");
    }

    public String setupOffersFilterCategoryTrains(){
        return appliedRadioButtonTrains.getText();
    }
}
