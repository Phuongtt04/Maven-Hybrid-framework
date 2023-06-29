package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserMyPO extends BasePage {
    WebDriver driver;

    public UserMyPO(WebDriver driver) {
        this.driver = driver;
    }
}
