package pageObjects.wordpressPageObject.admin;

import org.openqa.selenium.WebDriver;

public class AdminDashboardPO extends AdminMenuItemPO{
    WebDriver driver;

    public AdminDashboardPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
