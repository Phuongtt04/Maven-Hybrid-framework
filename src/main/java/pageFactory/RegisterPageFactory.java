package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory extends BasePage {
    WebDriver driver;

    public RegisterPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy (id = "FirstName")
    WebElement firstName;

    @FindBy (id = "LastName")
    WebElement lastName;
    @FindBy (how = How.ID, using = "Email")
    WebElement email;
    @FindBy (css = "input[id='Password']")
    WebElement password;
    @FindBy (css = "input[id='ConfirmPassword']")
    WebElement confirmPassword;
    @FindBy (xpath = "//button[@id='register-button']")
    WebElement registerButton;
    @FindBy (how = How.XPATH, using = "//span[@id='FirstName-error']")
    WebElement firstNameErrorMsg;
    @FindBy (how = How.CSS, using = "span[id='LastName-error']")
    WebElement lastNameErrorMsg;
    @FindBy (how = How.ID, using = "Email-error")
    WebElement emailErrorMsg;
    @FindBy (xpath = "//span[@id='Password-error']")
    WebElement passwordErrorMsg;
    @FindBy (xpath = "//span[@id='ConfirmPassword-error']")
    WebElement confirmPasswordErrorMsg;
    @FindBy (xpath = "//div[@class='result']")
    WebElement registrationCompletedMsg;
    @FindBy (xpath = "//img[@alt='nopCommerce demo store']")
    WebElement nopCommerceLogo;



    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(registerButton);
    }

    public String getFirstNameErrorMsgText() {
        waitForElementVisible(driver, firstNameErrorMsg);
        return getElementText(firstNameErrorMsg);
    }

    public String getLastNameErrorMsgText() {
        waitForElementVisible(driver,lastNameErrorMsg);
        return getElementText(lastNameErrorMsg);

    }

    public String getEmailErrorMsgText() {
        waitForElementVisible(driver,emailErrorMsg);
        return getElementText(emailErrorMsg);

    }

    public String getPasswordErrorMsgText() {
        waitForElementVisible(driver, passwordErrorMsg);
        return getElementText(passwordErrorMsg);

    }

    public String getConfirmPasswordErrorMsgText() {
        waitForElementVisible(driver, confirmPasswordErrorMsg);
        return getElementText(confirmPasswordErrorMsg);

    }

    public void clickToNopCommerceLogo() {
        waitForElementVisible(driver, nopCommerceLogo);
        clickToElement(nopCommerceLogo);
    }

    public void enterToFirstNameTextBox(String firstNameValue) {
        waitForElementVisible(driver, firstName);
        senKeyToElement(firstName, firstNameValue);
    }

    public void enterToLastNameTextBox(String lastNameValue) {
        waitForElementVisible(driver, lastName);
        senKeyToElement(lastName, lastNameValue);

    }

    public void enterToEmailTextBox(String emailValue) {
        waitForElementVisible(driver, email);
        senKeyToElement(email, emailValue);
    }

    public void enterToPasswordTextBox(String passwordValue) {
        waitForElementVisible(driver, password);
        senKeyToElement(password, passwordValue);
    }

    public void enterToConfirmPasswordTextBox(String confirmPasswordValue) {
        waitForElementVisible(driver, confirmPassword);
        senKeyToElement(confirmPassword, confirmPasswordValue);
    }

    public String getResultSuccessMsg() {
        waitForElementVisible(driver, registrationCompletedMsg);
        return getElementText(registrationCompletedMsg);
    }
}
