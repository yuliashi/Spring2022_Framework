package Pages.Darksky;

import Helper.Misc;
import Pages.Commands;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    // method to click Time Machine button
    public void clickOnTimeMachine () {
        clickOn(timeMachineLocator);
    }

    public void scrollToTimeMachineByPixel () {
        JavascriptExecutor js =  (JavascriptExecutor) MyDriver.getDriver();
        js.executeScript("scrollBy(0,900)");
        Misc.pause(3);

    }

    public WebElement scrollToDailyDetails () {
        return scrollToElement(dailyDetailsExpandLocator1);
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

        return Integer.parseInt(answer);
    }

    public boolean isTempBarEqualToTempExpand (By locatorTempHeader, By locatorTempExpand) {
        int tempHeader = findTempValue(locatorTempHeader);
        int tempExpanding = findTempValue(locatorTempExpand);

        return (tempHeader == tempExpanding);
    }

    public boolean isLowTempBarEqualToLowTempExpand () {
        return isTempBarEqualToTempExpand(todayBarMinLocator, dayDetailsMinTempLocator);
    }

    public boolean isHighTempBarEqualToHighTempExpand () {
        return isTempBarEqualToTempExpand(todayBarMaxLocator, dayDetailsMaxTempLocator);
    }




    public boolean isTodaysDateHighlighted () {
        Date today = new Date();
        SimpleDateFormat day = new SimpleDateFormat("d");
        String expectedDate = day.format(today);

        WebElement todaysDateOnTimeMachine = MyDriver.getDriver().findElement(By.xpath("//td[@class = 'is-today']"));

        String actualDate = todaysDateOnTimeMachine.getAttribute("data-day");

        return actualDate.equals(expectedDate);

    }







}
