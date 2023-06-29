package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerce.AdminDashboardPageUI;
import pageUIsNopCommerce.AdminLoginPageUI;

public class AdminDasboardPO extends BasePage {
    WebDriver driver;

    public AdminDasboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayedDashboard() {
        return isElementDisplayedInDOM(driver, AdminLoginPageUI.DASH_BOARD_HEADER);
    }

    public AdminLoginPO clickToLogoutButton(){
        waitForElementClickable(driver, AdminDashboardPageUI.LOG_OUT_BUTTON);
        clickToElement(driver, AdminDashboardPageUI.LOG_OUT_BUTTON);
        return PageGeneratorManager.getAdminLoginPageObject(driver);
    }
}
