package pageObjects.techPandaPageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsTechPanda.HomePageUI;

public class HomePagePO extends BasePage {
    WebDriver driver;

    public HomePagePO(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPO clickToMyAccountLink(){
        waitForElementVisible(driver, HomePageUI.ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.ACCOUNT_LINK);
        waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getLoginPage(driver);
    }
}
