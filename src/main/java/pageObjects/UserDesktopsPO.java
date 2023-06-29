package pageObjects;

import org.openqa.selenium.WebDriver;

public class UserDesktopsPO extends UserCategoriesSideBarPO
{
    WebDriver driver;

    public UserDesktopsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
