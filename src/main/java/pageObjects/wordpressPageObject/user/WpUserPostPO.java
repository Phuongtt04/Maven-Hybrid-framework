package pageObjects.wordpressPageObject.user;

import PageUIsWordpress.userPageUIs.WpPostPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class WpUserPostPO extends BasePage {
    WebDriver driver;

    public WpUserPostPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitlePostName() {
        waitForElementVisible(driver, WpPostPageUI.USER_POST_DETAIL_TITLE_NAME);
        return getElementText(driver, WpPostPageUI.USER_POST_DETAIL_TITLE_NAME);
    }

    public String getBodyText() {
        waitForElementVisible(driver, WpPostPageUI.USER_POST_DETAIL_BODY_VALUE);
        return getElementText(driver, WpPostPageUI.USER_POST_DETAIL_BODY_VALUE);
    }

    public Object getTagNameText() {
        waitForElementVisible(driver, WpPostPageUI.USER_POST_DETAIL_TAGS_NAME);
        return getElementText(driver, WpPostPageUI.USER_POST_DETAIL_TAGS_NAME);
    }

    public Object getCategoryNameText() {
        waitForElementVisible(driver, WpPostPageUI.USER_POST_DETAIL_CATEGORIES_NAME);
        return getElementText(driver, WpPostPageUI.USER_POST_DETAIL_CATEGORIES_NAME);
    }
}
