package pageObjects.sauceDemoSortData;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsSauceDemoSortData.LoginPageUI;

public class LoginPO extends BasePage{
    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String userName) {
        waitForElementVisible(driver, LoginPageUI.USER_NAME);
        senKeyToElement(driver, LoginPageUI.USER_NAME, userName);
    }

    public void enterPassword(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD);
        senKeyToElement(driver, LoginPageUI.PASSWORD, password);
    }

    public InventoryPO clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getInventoryPage(driver);
    }
}
