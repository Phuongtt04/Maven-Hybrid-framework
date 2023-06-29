package pageObjects.facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsFacebook.LoginPageUI;

public class LoginPO extends BasePage {
    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCreateNewAccountButton() {
        waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
        clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
    }

    public void enterToEmailTextbox(String valueEmail) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        senKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX,valueEmail);
    }

    public void waitForReEnterEmailTextboxVisible() {
        waitForElementVisible(driver, LoginPageUI.RE_EMAIL_TEXTBOX);
    }

    public boolean isReEnterEmailTextboxDisplay() {
        return isElementDisplayedInDOM(driver, LoginPageUI.RE_EMAIL_TEXTBOX);
    }

    public void waitForReEnterEmailTextboxInVisibleInDOM() {
        waitForElementInVisibleInDOM(driver, LoginPageUI.RE_EMAIL_TEXTBOX);
    }

    public boolean isReEnterEmailTextboxUnDisplay() {
        return isElementUnDisplayed(driver, LoginPageUI.RE_EMAIL_TEXTBOX);

    }

    public void waitForReEnterEmailTextboxInVisibleNotInDOM() {
        waitForElementInVisibleNotInDOM(driver, LoginPageUI.RE_EMAIL_TEXTBOX);
    }

    public void clickToCloseCreateAccountPopup() {
        waitForElementClickable(driver, LoginPageUI.ICON_CLOSE_CREATE_ACCOUNT_POPUP);
        clickToElement(driver, LoginPageUI.ICON_CLOSE_CREATE_ACCOUNT_POPUP);
        sleepInSecond(2);
    }

    public void waitForPopupInvisibleNotInDOM() {
        waitForElementInVisibleNotInDOM(driver, LoginPageUI.ICON_CLOSE_CREATE_ACCOUNT_POPUP);
    }

    public boolean isPopupInvisible() {
        return isElementUnDisplayed(driver, LoginPageUI.ICON_CLOSE_CREATE_ACCOUNT_POPUP);
    }

    public boolean isReEmailInvisible() {
        return isElementUnDisplayed(driver, LoginPageUI.RE_EMAIL_TEXTBOX);
    }
}
