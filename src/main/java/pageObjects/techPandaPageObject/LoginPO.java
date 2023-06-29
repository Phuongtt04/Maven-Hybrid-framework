package pageObjects.techPandaPageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsTechPanda.LoginPageUI;

public class LoginPO extends BasePage {
    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextbox(String emailValue){
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        senKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailValue);
    }

    public void enterToPasswordTextbox(String passwordValue){
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        senKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordValue);
    }

    public MyAccountPO clickToLoginButton(){
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getMyAccountPage(driver);
    }
}
