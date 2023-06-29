package pageObjects;

import org.openqa.selenium.WebDriver;

public class UserElectronicsPO extends UserCategoriesSideBarPO {
    WebDriver driver;

    public UserElectronicsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
