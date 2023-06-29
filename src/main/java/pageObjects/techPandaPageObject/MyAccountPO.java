package pageObjects.techPandaPageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsTechPanda.MyAccountPageUI;

public class MyAccountPO extends BasePage {
    WebDriver driver;

    public MyAccountPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayedHeaderText(){
        waitForElementVisible(driver, MyAccountPageUI.HEADER_TITLE);
        return isElementDisplayedInDOM(driver, MyAccountPageUI.HEADER_TITLE);
    }
}
