package Pages.Facebook;

import Pages.Commands;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends Commands {

    // Variables (Locators)
    By monthDdLocator = By.id("month");
    By yearDdLocator = By.id("year");
    By dayDdLocator = By.id("day");


    // Methods (to interact with webElements present on this webpage)
    public void selectBirthMonth(String monthName) {
        selectInDropdown(monthDdLocator, monthName);
    }

    public void selectBirthDay(String day) {
        selectInDropdown(dayDdLocator,day);
    }

    public void selectBirthYear(String year) {
        selectInDropdown(yearDdLocator, year);
    }

    public void selectBirthDate(String birthDate) {
        String[] birthDateData = birthDate.split(" ");
        selectBirthMonth(birthDateData[0]);
        selectBirthDay(birthDateData[1]);
        selectBirthYear(birthDateData[2]);
    }

}