package StepDefinition.Facebook;

import Pages.Facebook.LandingPage;
import Web.MyDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class FBlinksSD {

    LandingPage lpage = new LandingPage();

    @When("^I click on Facebook Pay$")
    public void clickFacebookPay () {
        lpage.clickFBPaylink();
    }

    @When("^I click on Oculus$")
    public void clickOculus () {
        lpage.clickOculusLink();
    }

    @When("^I click on Instagram$")
    public void clickInstagram () {
        lpage.clickInstagramLink();
    }

    @When("^I click on Portal$")
    public void clickPortal () {
        lpage.clickPortalLink();
    }

    @When("^I click on Bulletin$")
    public void clickBulletin () {
        lpage.clickBulletinLink();
    }

    @When("^I close ALL windows except (.*)$")
    public void closeAllWindowsExcept (String pageToRemainOpen) {
        lpage.closeAllPagesExcept(pageToRemainOpen);
    }

    @Then("^I verify the number of windows equals to (.*)$")
    public void numberOfWindowsEqualsTo (int expectedNumberOfWindows) {
        int actualNumberOfWindows = lpage.getTheNumberOfHandles();
        Assert.assertEquals(actualNumberOfWindows, expectedNumberOfWindows, "Number of windows is not equal to " + expectedNumberOfWindows);
    }






}
