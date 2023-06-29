package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class CustomerPageFactory extends BasePage {
    WebDriver driver;

    public CustomerPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "FirstName")
    WebElement firstName;
    @FindBy(id = "LastName")
    WebElement lastName;
    @FindBy(id = "Email")
    WebElement email;

    public String getFirstNameTextBoxAttributeValue() {
        waitForElementVisible(driver, firstName);
        return  getElementAttribute(firstName, "value");
    }

    public String getLastNameTextBoxAttributeValue() {
        waitForElementVisible(driver, lastName);
        return  getElementAttribute(lastName, "value");

    }

    public String getEmailTextBoxAttributeValue() {
        waitForElementVisible(driver, email);
        return  getElementAttribute(email, "value");

    }
}
