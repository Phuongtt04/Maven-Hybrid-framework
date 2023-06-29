package pageObjects.wordpressPageObject.user;

import PageUIsWordpress.userPageUIs.WpUserHomePageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class WpUserHomePO extends BasePage {
    WebDriver driver;

    public WpUserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToSearchTextbox(String searchValue) {
        waitForElementVisible(driver, WpUserHomePageUI.USER_SEARCH_TEXTBOX);
        senKeyToElement(driver, WpUserHomePageUI.USER_SEARCH_TEXTBOX, searchValue);
    }

    public WpUserSearchPO clickToSearchButton() {
        waitForElementClickable(driver, WpUserHomePageUI.USER_SEARCH_BUTTON);
        clickToElement(driver, WpUserHomePageUI.USER_SEARCH_BUTTON);
        return new WpUserSearchPO(driver);
    }
}
