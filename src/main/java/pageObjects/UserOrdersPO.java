package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserOrdersPO extends BasePage {
    WebDriver driver;

    public UserOrdersPO(WebDriver driver) {
        this.driver = driver;
    }
}
