package StepDefinition;

import Web.MyDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CommonSD {

    @Given("^I am on the (facebook|darksky|hotels) landing page$")
    public void openWebPage(String webPage) {
        switch (webPage) {
            case "facebook" -> MyDriver.launchUrlOnNewWindow("https://www.facebook.com/");
            case "darksky" -> MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");
            case "hotels" -> MyDriver.launchUrlOnNewWindow("https://www.hotels.com/");
            default -> System.out.println("Invalid webpage name");
        }
    }



}
