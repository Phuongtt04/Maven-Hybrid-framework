package pageObjects;

import org.openqa.selenium.WebDriver;

public class UserBooksPO extends UserCategoriesSideBarPO {
    WebDriver driver;
    public UserBooksPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
