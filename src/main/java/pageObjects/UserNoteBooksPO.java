package pageObjects;

import org.openqa.selenium.WebDriver;

public class UserNoteBooksPO extends UserCategoriesSideBarPO {
    WebDriver driver;

    public UserNoteBooksPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
