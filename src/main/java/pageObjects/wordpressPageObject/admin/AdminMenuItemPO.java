package pageObjects.wordpressPageObject.admin;

import PageUIsWordpress.adminPageUIs.AdminDashboardPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.wordpressPageObject.PageGenerateManage;

public class AdminMenuItemPO extends BasePage {
    WebDriver driver;

    public AdminMenuItemPO(WebDriver driver) {
        this.driver = driver;
    }

    public AdminPostPO clickToPostMenuItem(String menuName) {
        waitForElementClickable(driver, AdminDashboardPageUI.ADMIN_POST_MENU_LINK, menuName);
        clickToElement(driver, AdminDashboardPageUI.ADMIN_POST_MENU_LINK, menuName);
        return PageGenerateManage.getAdminPostPageObject(driver);
    }
}
