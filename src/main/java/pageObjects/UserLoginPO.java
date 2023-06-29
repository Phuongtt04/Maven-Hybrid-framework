package pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerce.UserLoginPageUI;

public class UserLoginPO extends BasePage {
    WebDriver driver;

    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter to email textbox")
    public void enterToEmailTextBox(String email) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        senKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
    }

    @Step("Enter to Password textbox")
    public void enterToPasswordTextBox(String passWord) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        senKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, passWord);
    }

    @Step("Click Login Button")
    public UserHomePO clickToLoginButton() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getHomePageObject(driver);

    }
}
