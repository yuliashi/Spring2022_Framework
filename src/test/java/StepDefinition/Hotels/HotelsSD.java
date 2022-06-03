package StepDefinition.Hotels;

import Web.MyDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class HotelsSD {

    Pages.Hotels.HotelsLanding lpage = new Pages.Hotels.HotelsLanding ();

    @Given("^I am on hotels landing page$")
    public void launchHotelsUrl () {
        MyDriver.launchUrlOnNewWindow("https://www.hotels.com/");
    }

    @When("^I click on Search button$")
    public void clickOnSearch() {
        lpage.clickOnSearchBtn();
    }

    @When("^I add a child to search field$")
    public void increaseChildCount () {
        lpage.increaseNumberOfChildren();
    }

    @When("^I enter (.+) in child's age$")
    public void enterChildAge (String age) {
        lpage.selectChildAge(age);
    }

    @Then("^Destination Error message is displayed$")
    public void destinationErrorIsDisplayed () {
        Assert.assertTrue(lpage.isDestinationErrorDisplayed());
    }

    @Then("^Enter-Age message is displayed$")
    public void enterAgeErrorIsDisplayed () {
        Assert.assertTrue(lpage.isAgeMessageDisplayed());
    }

    @Then("^Enter-Age message is not displayed$")
    public void enterAgeErrorIsNotDisplayed () {
        Assert.assertFalse(lpage.isAgeMessageDisplayed());
    }
}
