package StepDefinition.Darksky;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class DarkskySD {

    Pages.Darksky.LandingPage lpage = new Pages.Darksky.LandingPage();

    @When("^I scroll to the Time Machine button$")
    public void scrollToTimeMachine () {
        lpage.scrollToTimeMachineButton();
    }

    @When("^I click on Time Machine button$")
    public void clickOnTimeMachineBTN () {
        lpage.clickOnTimeMachine();
    }

    @Then("^I verify Current date is highlighted$")
    public void isTodayHighlighted () {
        lpage.isTodaysDateHighlighted();
    }

    @When("^I scroll to Daily Details$")
    public void scrollToDD () {
        lpage.scrollToDailyDetails();
    }

    @When("^I click on Expand Daily Details for today$")
    public void expandDDcurrent () {
        lpage.expandDailyDetailsForToday();
    }

    @Then("^I verify Low Temp Header equals to the Low Temp Expandable$")
    public void isTempEqualLow () {
        lpage.isLowTempBarEqualToLowTempExpand();
    }

    @Then("^I verify High Temp Header equals to the High Temp Expandable$")
    public void isTempEqualHigh () {
        lpage.isHighTempBarEqualToHighTempExpand();
    }



}

