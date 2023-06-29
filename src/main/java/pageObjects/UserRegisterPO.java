package pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerce.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Register Button")
    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    @Step("Get First name error message")
    public String getFirstNameErrorMsgText() {
        waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_ERROR_MSG);
        return getElementText(driver, UserRegisterPageUI.FIRSTNAME_ERROR_MSG);
    }

    @Step("Get Last name error message")
    public String getLastNameErrorMsgText() {
        waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_ERROR_MSG);
        return getElementText(driver, UserRegisterPageUI.LASTNAME_ERROR_MSG);

    }

    @Step("Get Email error message")
    public String getEmailErrorMsgText() {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MSG);
        return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MSG);

    }

    @Step("Get Password error message")
    public String getPasswordErrorMsgText() {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MSG);
        return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MSG);

    }

    @Step("Get Confirm Password error message")
    public String getConfirmPasswordErrorMsgText() {
        waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
        return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);

    }

    @Step("Click to NopCommerce Logo")
    public UserHomePO clickToNopCommerceLogo() {
        waitForElementVisible(driver, UserRegisterPageUI.NOP_COMMERCE_LOGO);
        clickToElement(driver, UserRegisterPageUI.NOP_COMMERCE_LOGO);
        return PageGeneratorManager.getHomePageObject(driver);
    }

    @Step("Enter to FirstName textbox")
    public void enterToFirstNameTextBox(String firstName) {
        waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
        senKeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    @Step("Enter to LastName textbox")
    public void enterToLastNameTextBox(String lastName) {
        waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
        senKeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);

    }

    @Step("Enter to Email textbox")
    public void enterToEmailTextBox(String email) {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        senKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
    }

    @Step("Enter to Password textbox")
    public void enterToPasswordTextBox(String passWord) {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        senKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, passWord);
    }

    @Step("Enter to Confirm Password textbox")
    public void enterToConfirmPasswordTextBox(String confirmPassword) {
        waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        senKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    @Step("Get result success message")
    public String getResultSuccessMsg() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTRATION_COMPLETED_MSG);
        return getElementText(driver, UserRegisterPageUI.REGISTRATION_COMPLETED_MSG);
    }
}
