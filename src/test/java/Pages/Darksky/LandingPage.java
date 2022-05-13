package Pages.Darksky;

import Pages.Commands;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LandingPage extends Commands {

    // Locators of Landing Page elements
    By timeMachineLocator = By.xpath("//a[text()='Time Machine' or text()='TIME MACHINE']");
    By todayBarMinLocator = By.xpath("//a[@class = 'day revealed']//span[@class = 'minTemp']");
    By todayBarMaxLocator = By.xpath("//a[@class = 'day revealed']//span[@class = 'maxTemp']");
    By dayDetailsMinTempLocator = By.xpath("(//div[@class = 'dayDetails revealed']//span[@class = 'temp'])[1]");
    By dayDetailsMaxTempLocator = By.xpath("(//div[@class = 'dayDetails revealed']//span[@class = 'temp'])[2]");
    By dailyDetailsExpandLocator1 = By.xpath("(//a[@class = 'day'])[1]");


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
         * 3. scroll to the bottom of the page
         *
         * "window.scrollTo(0, document.body.scrollHeight)"
         */

        JavascriptExecutor js = (JavascriptExecutor) MyDriver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

    }

    // method to click Time Machine button
    public void clickOnTimeMachine () {
        clickIt(timeMachineLocator);
    }

    public void scrollToTimeMachineByPixel () {
        JavascriptExecutor js =  (JavascriptExecutor) MyDriver.getDriver();
        js.executeScript("scrollBy(0,900)");

    }



    //click on Daily details expand button (current day)
    public void expandDailyDetailsForToday () {
        clickIt(dailyDetailsExpandLocator1);
    }

    //find the value of the current day temperature on the bar

    public int findTempValue (By locator) {
        String initial = findWebElement(locator).getText();
        String [] array = initial.split("˚");
        String answer = array[0];
        int answerInt = Integer.parseInt(answer);

        return answerInt;
    }


    // method to check if Time Machine button is displayed







}
