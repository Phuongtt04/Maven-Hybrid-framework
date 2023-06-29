package pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerce.UserHomePageUI;

public class UserHomePO extends BasePage {
    WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Register link")
    public UserRegisterPO clickToRegisterLink() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPageObject(driver);
    }

    @Step("Click to Login link")
    public UserLoginPO clickToLoginLink() {
        waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
        clickToElement(driver, UserHomePageUI.LOGIN_LINK);
        return PageGeneratorManager.getLoginPageObject(driver);
    }

    @Step("Click to My Account link")
    public UserCustomerPO clickMyAccountLink() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getCustomerPageObject(driver);
    }

    @Step("Click Open Computer Page link on Header link")
    public UserComputersPO openComputersPageHeader() {
        waitForElementClickable(driver, UserHomePageUI.COMPUTERS_LINK_HEADER);
        clickToElement(driver, UserHomePageUI.COMPUTERS_LINK_HEADER);
        return PageGeneratorManager.getComputersPageObject(driver);
    }
}
