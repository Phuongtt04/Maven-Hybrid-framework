package pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerce.UserCustomerPageUI;

public class UserCustomerPO extends BasePage {
    WebDriver driver;

    public UserCustomerPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get FirstName textbox attribute value")
    public String getFirstNameTextBoxAttributeValue() {
        waitForElementVisible(driver, UserCustomerPageUI.FIRTNAME_TEXTBOX);
        return  getElementAttribute(driver, UserCustomerPageUI.FIRTNAME_TEXTBOX, "value");
    }

    @Step("Get LastName textbox attribute value")
    public String getLastNameTextBoxAttributeValue() {
        waitForElementVisible(driver, UserCustomerPageUI.LASTNAME_TEXTBOX);
        return  getElementAttribute(driver, UserCustomerPageUI.LASTNAME_TEXTBOX, "value");

    }

    @Step("Get Email textbox attribute value")
    public String getEmailTextBoxAttributeValue() {
        waitForElementVisible(driver, UserCustomerPageUI.EMAIL_TEXTBOX);
        return  getElementAttribute(driver, UserCustomerPageUI.EMAIL_TEXTBOX, "value");

    }
}
