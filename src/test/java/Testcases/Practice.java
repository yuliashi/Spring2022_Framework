package Testcases;

import Helper.Misc;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Practice {

    By todayBarMinLocator = By.xpath("//a[@class = 'day revealed']//span[@class = 'minTemp']");
    By todayBarMaxLocator = By.xpath("//a[@class = 'day revealed']//span[@class = 'maxTemp']");
    By dayDetailsMinTempLocator = By.xpath("(//div[@class = 'dayDetails revealed']//span[@class = 'temp'])[1]");
    By dayDetailsMaxTempLocator = By.xpath("(//div[@class = 'dayDetails revealed']//span[@class = 'temp'])[2]");

        /**
         * darksky.net
         * Verify the current date is highlighted in Time Machine's calendar
         */
        @Test
        public void verifyCurrentDateIsHighlighted() {
            MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");

            Date today = new Date();
            SimpleDateFormat day = new SimpleDateFormat("d");
            String expectedDate = day.format(today);

            Pages.Darksky.LandingPage lpage = new Pages.Darksky.LandingPage();
            lpage.scrollToTimeMachineByPixel();

            Misc.pause(1);

            lpage.clickOnTimeMachine();

            Misc.pause(3);

            // identify the selected element value

            WebElement todaysDateOnTimeMachine = MyDriver.getDriver().findElement(By.xpath("//td[@class = 'is-today']"));

            String actualDate = todaysDateOnTimeMachine.getAttribute("data-day");

            // if selected element equals to todays date
            Assert.assertEquals(actualDate, expectedDate, "Incorrect date is highlighted on the Time Machine calendar.");

        }



        /**
         * darksky.net
         * Verify same values are displayed in the Today's data
         */

        @Test
    public void verifyTempValuesInDailyDetails () {

            MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");

            Pages.Darksky.LandingPage lpage = new Pages.Darksky.LandingPage();
            lpage.scrollToTimeMachineByPixel();

            Misc.pause(2);

            lpage.expandDailyDetailsForToday();

            Misc.pause(2);

            int tempLowBar = lpage.findTempValue(todayBarMinLocator);
            int tempHighBar = lpage.findTempValue(todayBarMaxLocator);
            int todayDetailsMin = lpage.findTempValue(dayDetailsMinTempLocator);
            int todayDetailsMax = lpage.findTempValue(dayDetailsMaxTempLocator);

            Assert.assertEquals(tempLowBar, todayDetailsMin, "Today's minimal temperature is not equal in upper bar and the details section");
            Assert.assertEquals(tempHighBar,todayDetailsMax,"Today's maximum temperature is not equal in upper bar and the details section");
        }

        /**
         * facebook.com/
         * Launch facebook.com
         * Click on Facebook Pay, Oculus, Instagram, Portal and Bulletin
         * Close ALL windows except Instagram
         * Verify number of window-Handles is 1
         * Verify Page Title is Instagram
         * Verify Log in button on Instagram is disabled by default
         */
        @Test
        public void verifyInstagramPage () {

            MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");

            MyDriver.getDriver().findElement(By.linkText("Facebook Pay")).click();
            MyDriver.getDriver().findElement(By.linkText("Oculus")).click();
            MyDriver.getDriver().findElement(By.linkText("Instagram")).click();
            MyDriver.getDriver().findElement(By.linkText("Portal")).click();
            MyDriver.getDriver().findElement(By.linkText("Bulletin")).click();

            Set<String> allHandles = MyDriver.getDriver().getWindowHandles();

            for (String handle : allHandles) {
                    MyDriver.getDriver().switchTo().window(handle);
                    String title = MyDriver.getDriver().getTitle();
                    if (!title.equalsIgnoreCase("Instagram")) {
                        MyDriver.getDriver().close();

                    }

            }


            Misc.pause(2);

            Set<String> allHandlesNew = MyDriver.getDriver().getWindowHandles();

            int numberOfWindows = allHandlesNew.size();

            Assert.assertEquals(numberOfWindows, 1, "Error: not all windows have been closed");

            Misc.pause(3);

           WebElement logInButtonIG = MyDriver.getDriver().findElement(By.xpath("//button/div[text()  = 'Log In']"));

            boolean isLogInEnabledIG = logInButtonIG.isEnabled();

            Assert.assertTrue(isLogInEnabledIG, "Log In button is not disabled by default");


        }
    }


