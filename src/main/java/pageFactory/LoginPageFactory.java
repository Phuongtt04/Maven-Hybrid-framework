package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage {
    WebDriver driver;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='Email']")
    WebElement email;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    WebElement loginButton;


    public void enterToEmailTextBox(String emailValue) {
        waitForElementVisible(driver, email);
        senKeyToElement(email, emailValue);

    }

    public void enterToPasswordTextBox(String passwordValue) {
        waitForElementVisible(driver, password);
        senKeyToElement(password, passwordValue);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, loginButton);
        clickToElement(loginButton);

    }
}
