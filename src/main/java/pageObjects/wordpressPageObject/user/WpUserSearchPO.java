package pageObjects.wordpressPageObject.user;

import PageUIsWordpress.userPageUIs.WpSearchPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.wordpressPageObject.PageGenerateManage;

public class WpUserSearchPO extends BasePage {
    WebDriver driver;

    public WpUserSearchPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitlePostText() {
        waitForElementVisible(driver, WpSearchPageUI.USER_TITLE_NAME);
        return getElementText(driver, WpSearchPageUI.USER_TITLE_NAME);

    }

    public WpUserPostPO clickToTitlePost() {
        waitForElementClickable(driver, WpSearchPageUI.USER_TITLE_NAME);
        clickToElement(driver, WpSearchPageUI.USER_TITLE_NAME);
        return PageGenerateManage.getWpPostPageObject(driver);
    }

    public boolean isMessageNotFoundPostDisplay(String message) {
        waitForElementVisible(driver, WpSearchPageUI.USER_MESSAGE_NOT_FOUND, message);
        return isElementDisplayedInDOM(driver, WpSearchPageUI.USER_MESSAGE_NOT_FOUND, message);
    }
}
