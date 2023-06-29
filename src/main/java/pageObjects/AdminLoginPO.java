package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerce.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextBox(String email) {
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
        senKeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPasswordTextBox(String passWord) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        senKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, passWord);
    }

    public AdminDasboardPO clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminDasboardPageObject(driver);

    }
}
