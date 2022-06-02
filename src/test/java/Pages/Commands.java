package Pages;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Set;
import java.util.function.Function;

public class Commands {

    // Create a local method to find WebElement
    public WebElement findWebElement(By locator) {
        return MyDriver.getDriver().findElement(locator);
    }


    // Create a local method to type in the webElement
    public void type(By locator, String data) {
        webAction(locator).sendKeys(data);
    }


    // Create a local method to click on the webElement
    public void clickIt(By locator) {
        findWebElement(locator).click();
    }

    // Create a local method to click on the webElement after scroll
    public void clickItAfterScroll(By locator) {
        scrollToElement(locator).click();
    }

    // Create a local method to find if element is enabled
    public boolean isElementEnabled(By locator) {
        return webAction(locator).isEnabled();
    }

    public String getTextFromElement(By locator) { return webAction(locator).getText(); }

    // Create a local method to select a value from a dropdown
    public void selectInDropdown(By locator, String dataToSelect) {
        WebElement ddElement = webAction(locator);
        Select dropdown = new Select(ddElement);
        dropdown.selectByVisibleText(dataToSelect);
    }

    // Create a local method to find if element is displayed
    public boolean isElementDisplayed(By locator) {
        return webAction(locator).isDisplayed();
    }

    // Create custom method to scroll
    public WebElement scrollToElement(By locator) {
        WebElement element = null;
        for (int i=0 ; i <= 15 ; i++) {
            try {
                element = findWebElement(locator);
                break;
            } catch (ElementClickInterceptedException | NoSuchElementException e) {
                //scroll by 100
                JavascriptExecutor js =  (JavascriptExecutor) MyDriver.getDriver();
                js.executeScript("scrollBy(0,100)");
            }
        }
        Misc.pause(3);
        return element;
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

    public void closeAllPagesExcept (String titleToRemainOpen) {

        String originalWindow = MyDriver.getDriver().getWindowHandle();
        Set<String> allHandles = MyDriver.getDriver().getWindowHandles();

        for (String handle : allHandles) {
            MyDriver.getDriver().switchTo().window(handle);
            String title = MyDriver.getDriver().getTitle();
            if (!title.equalsIgnoreCase(titleToRemainOpen)) {
                MyDriver.getDriver().close();

            }

        }

        MyDriver.getDriver().switchTo().window(originalWindow);
    }

    public static WebElement webAction(By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(MyDriver.getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {          public WebElement apply(WebDriver driver) {
            return driver.findElement(locator);
        }
        });
        return element;
    }

    public void clickOn (By locator) {
        try {
            MyDriver.getDriver().findElement(locator).click();
            webAction(locator).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }




}
