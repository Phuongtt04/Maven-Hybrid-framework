package pageObjects;

import org.openqa.selenium.WebDriver;

public class UserComputersPO extends UserCategoriesSideBarPO {
    WebDriver driver;

    public UserComputersPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
