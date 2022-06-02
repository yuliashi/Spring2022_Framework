package Pages.Hotels;

import Pages.Commands;
import org.openqa.selenium.By;

public class HotelsLanding extends Commands {

    // Variables (Locators)
    By mainSearchLocator = By.xpath("//button[@data-testid = 'submit-button']");
    By destinationErrorLocator = By.id("location-field-destination-input-error");
    By numberOfTravelersLocator = By.xpath("//button[@data-testid = 'travelers-field-trigger']");
    By increaseChildCountBtnLocator = By.xpath("//label[@for = 'child-input-0']/following-sibling::div//button[2]']");
    By enterAgeMessageLocator = By.xpath("//div[@data-testid = 'lob-error-summary']");
    By enterAgeDDLocator = By.xpath("//select[contains (@id, 'child-age')]");


    public void clickOnSearchBtn () {
        clickOn(mainSearchLocator);
    }

    public boolean isDestinationErrorDisplayed () {
        return isElementDisplayed(destinationErrorLocator);
    }

    public void clickToSelectNumberOfTravelers () {
        clickOn(numberOfTravelersLocator);
    }

    public void increaseNumberOfChildren () {
        clickOn(increaseChildCountBtnLocator);
    }

    public boolean isAgeMessageDisplayed () {
        return isElementDisplayed(enterAgeMessageLocator);
    }

    public void selectChildAge (String age) {
        selectInDropdown(enterAgeDDLocator, age);
    }
}
