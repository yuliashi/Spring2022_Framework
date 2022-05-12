package Pages.Facebook;

import Pages.Commands;
import Web.MyDriver;
import org.openqa.selenium.By;

public class LoginErrorPage extends Commands {


    By loginErrorLocator = By.xpath("//div[text()='The email or mobile number you entered isn’t connected to an account. ']");


    public boolean isLoginErrorDisplayed() {
        return isElementDisplayed(loginErrorLocator);
    }



}
