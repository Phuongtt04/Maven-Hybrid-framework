package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserCustomerInfoPO extends BasePage {
    WebDriver driver;

    public UserCustomerInfoPO(WebDriver driver) {
        this.driver = driver;
    }
}
