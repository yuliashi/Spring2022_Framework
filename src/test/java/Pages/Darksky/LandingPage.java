package Pages.Darksky;

import Pages.Commands;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LandingPage extends Commands {

    // Locators of Landing Page elements
    By timeMachineLocator = By.xpath("//a[text()='Time Machine' or text()='TIME MACHINE']");


    // Method to interact with Landing Page elements
    // method to scroll and find if Time Machine button is enabled



    // method to scroll to Time Machine button
    public WebElement scrollToTimeMachineButton() {
        return scrollToElement(timeMachineLocator);
    }

    // method to check if Time Machine button is enabled
    public boolean isTimeMachineButtonEnabled() {
        return scrollToTimeMachineButton().isEnabled();
    }

    public void scrollToBottom() {
        /**
         * 3. scroll upto bottom of the page
         *
         * "window.scrollTo(0, document.body.scrollHeight)"
         */

        JavascriptExecutor js = (JavascriptExecutor) MyDriver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

    }


    // method to check if Time Machine button is displayed


    // method to click Time Machine button




}
