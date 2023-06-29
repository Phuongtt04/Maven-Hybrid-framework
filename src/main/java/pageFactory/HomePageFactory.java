package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory extends BasePage {
    WebDriver driver;

    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "ico-register")
    WebElement  registerLink;

    @FindBy(xpath = "//a[@class='ico-login']")
    WebElement loginLink;

    @FindBy(css = "a[class='ico-account']")
    WebElement myAccountLink;

    public void clickToRegisterLink() {
        waitForElementClickable(driver, registerLink);
        clickToElement(registerLink);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, loginLink);
        clickToElement(loginLink);
    }

    public void clickMyAccountLink() {
        waitForElementClickable(driver, myAccountLink);
        clickToElement(myAccountLink);
    }
}
