package Pages.Facebook;


import Pages.Commands;
import Web.MyDriver;
import org.openqa.selenium.By;

import java.util.Set;

public class LandingPage extends Commands {

    // Variables (Locators)
    By loginEmailLocator = By.id("email");
    By loginPassLocator = By.id("pass");
    By loginButtonLocator = By.tagName("button");
    By createNewAccountBtnLocator = By.xpath("//a[@data-testid='open-registration-form-button']");
    By FBPayLocator = By.linkText("Facebook Pay");
    By oculusLinkLocator = By.linkText("Oculus");
    By instagramLinkLocator = By.linkText("Instagram");
    By portalLinkLocator = By.linkText("Portal");
    By bulletinLinkLocator = By.linkText("Bulletin");


    // Methods (to interact with webElements present on this webpage)
    public void enterLoginEmail(String loginEmail) {
        // MyDriver.getDriver().findElement(loginEmailLocator).sendKeys(loginEmail);
        type(loginEmailLocator, loginEmail);
    }

    public void enterLoginPassword(String loginPwd) {
        // MyDriver.getDriver().findElement(loginPassLocator).sendKeys(loginPwd);
        type(loginPassLocator, loginPwd);
    }

    public void clickLoginButton() {
        // MyDriver.getDriver().findElement(loginButtonLocator).click();
        clickIt(loginButtonLocator);
    }

    public void clickFBPaylink () {
        clickIt(FBPayLocator);
    }

    public void clickOculusLink () {
        clickIt(oculusLinkLocator);
    }

    public void clickInstagramLink () {
        clickIt(instagramLinkLocator);
    }

    public void clickPortalLink () {
        clickIt(portalLinkLocator);
    }

    public void clickBulletinLink () {
        clickIt(bulletinLinkLocator);
    }

    public void clickCreateNewAccountBtn() {
        // MyDriver.getDriver().findElement(createNewAccountBtnLocator).click();
        clickIt(createNewAccountBtnLocator);
    }

    public boolean isLoginBtnEnabled() {
        return MyDriver.getDriver().findElement(loginButtonLocator).isEnabled();
    }

    public boolean isCreateNewAccountBtnEnabled() {
        return isElementEnabled(createNewAccountBtnLocator);
    }

    public int getTheNumberOfHandles () {
        Set<String> allHandles = MyDriver.getDriver().getWindowHandles();

        int numberOfWindows = allHandles.size();
        return numberOfWindows;
    }


}
