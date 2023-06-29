package pageObjects.wordpressPageObject.admin;

import PageUIsWordpress.adminPageUIs.AdminLoginPageUI;
import org.openqa.selenium.WebDriver;
import pageObjects.wordpressPageObject.PageGenerateManage;

public class AdminLoginPO extends AdminMenuItemPO {
    WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToUsernameTextbox(String username) {
        waitForElementVisible(driver, AdminLoginPageUI.USER_NAME_TEXTBOX);
        senKeyToElement(driver, AdminLoginPageUI.USER_NAME_TEXTBOX, username);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        senKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public AdminDashboardPO clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGenerateManage.getAdminDashboardPageObject(driver);
    }
}
