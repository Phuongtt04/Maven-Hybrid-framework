package pageObjects.wordpressPageObject.admin;

import PageUIsWordpress.adminPageUIs.AdminDashboardPageUI;
import PageUIsWordpress.adminPageUIs.AdminPostPageUI;
import org.openqa.selenium.WebDriver;

public class AdminPostPO extends AdminMenuItemPO{
    WebDriver driver;

    public AdminPostPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToAddNewButton() {
        waitForElementClickable(driver, AdminDashboardPageUI.ADMIN_ADD_NEW_BUTTON);
        clickToElement(driver, AdminDashboardPageUI.ADMIN_ADD_NEW_BUTTON);
    }

    public void enterToTitleTextbox(String titleValue) {
        waitForElementVisible(driver, AdminPostPageUI.ADMIN_TITLE_TEXTBOX);
        senKeyToElement(driver, AdminPostPageUI.ADMIN_TITLE_TEXTBOX, titleValue);
    }
    

    public void enterToBodyTextbox(String bodyValue) {
        waitForElementClickable(driver, AdminPostPageUI.ADMIN_BODY_DEFAULT_TEXTBOX);
        clickToElement(driver, AdminPostPageUI.ADMIN_BODY_DEFAULT_TEXTBOX);
        waitForElementVisible(driver, AdminPostPageUI.ADMIN_BODY_TEXTBOX);
        senKeyToElement(driver, AdminPostPageUI.ADMIN_BODY_TEXTBOX, bodyValue);
    }

    public void clickToPostTab() {
        waitForElementClickable(driver, AdminPostPageUI.ADMIN_POST_BUTTON_SIDEBAR);
        clickToElement(driver,AdminPostPageUI.ADMIN_POST_BUTTON_SIDEBAR);
        sleepInSecond(2);
    }

    public void clickToCategoriesLabel() {
        try{
            if (getWebElement(driver, AdminPostPageUI.ADMIN_COMPONENTS_PANEL).isDisplayed()) {
                waitForElementClickable(driver, AdminPostPageUI.ADMIN_COMPONENTS_PANEL, "Categories");
                clickToElement(driver, AdminPostPageUI.ADMIN_COMPONENTS_PANEL, "Categories");
            }

        } catch (Throwable e){
            System.out.println("Đã click");
        }
        sleepInSecond(1);
    }

    public void checkToCategoryItemCheckbox(String categoryValue) {

        waitForElementClickable(driver, AdminPostPageUI.ADMIN_CATEGORIES_CHECKBOX, categoryValue);
        checkToElement(driver, AdminPostPageUI.ADMIN_CATEGORIES_CHECKBOX, categoryValue);
    }

    public void unCheckToCategoryCheckbox(String categoryValue) {
        waitForElementClickable(driver, AdminPostPageUI.ADMIN_CATEGORIES_CHECKBOX, categoryValue);
        unCheckToElement(driver, AdminPostPageUI.ADMIN_CATEGORIES_CHECKBOX, categoryValue);
    }

    public void clickToTagsLabel() {
        try{
            if (getWebElement(driver, AdminPostPageUI.ADMIN_COMPONENTS_PANEL).isDisplayed()) {
                waitForElementClickable(driver, AdminPostPageUI.ADMIN_COMPONENTS_PANEL, "Tags");
                clickToElement(driver, AdminPostPageUI.ADMIN_COMPONENTS_PANEL, "Tags");
            }

        } catch (Throwable e){
            System.out.println("Đã click");
        }
        sleepInSecond(1);
    }

    public void enterToNewTagTextbox(String tagsNameVaule) {
        waitForElementVisible(driver, AdminPostPageUI.ADMIN_INPUT_TAGS_TEXTBOX);
        senKeyToElement(driver, AdminPostPageUI.ADMIN_INPUT_TAGS_TEXTBOX, tagsNameVaule);
        sleepInSecond(2);
        enterKeyToElement(driver, AdminPostPageUI.ADMIN_INPUT_TAGS_TEXTBOX);
        sleepInSecond(2);
    }

    public void clickToPublishButton(String actionName) {
        waitForElementClickable(driver, AdminPostPageUI.ADMIN_PUBLISH_VIEW_BUTTON, actionName);
        clickToElement(driver, AdminPostPageUI.ADMIN_PUBLISH_VIEW_BUTTON, actionName);
        sleepInSecond(2);
    }

    public void clickToPublishActiveButton() {

        waitForElementClickable(driver, AdminPostPageUI.ADMIN_PUBLISH_ACTIVE_BUTTON, "Publish");
        clickToElement(driver, AdminPostPageUI.ADMIN_PUBLISH_ACTIVE_BUTTON, "Publish");
    }

    public boolean isPublishMessageDisplay(String messageValue) {
        waitForElementVisible(driver, AdminPostPageUI.ADMIN_ALERT_NOTI_MESSAGE, messageValue);
        return isElementDisplayedInDOM(driver, AdminPostPageUI.ADMIN_ALERT_NOTI_MESSAGE, messageValue);
    }

    public String getMessagePublished() {
        waitForElementVisible(driver, AdminPostPageUI.ADMIN_PUBLISH_NOTI_MESSAGE);
        return getElementText(driver, AdminPostPageUI.ADMIN_PUBLISH_NOTI_MESSAGE);
    }

    public void clicktoPostIcon() {
        waitForElementClickable(driver, AdminPostPageUI.ADMIN_VIEW_POST_ICON);
        clickToElement(driver, AdminPostPageUI.ADMIN_VIEW_POST_ICON);
    }

    public void enterToSearchTextbox(String searchValue) {
        waitForElementVisible(driver, AdminPostPageUI.ADMIN_SEARCH_TEXTBOX);
        senKeyToElement(driver, AdminPostPageUI.ADMIN_SEARCH_TEXTBOX, searchValue);
        sleepInSecond(1);
    }

    public void clicktoSearchButton() {
        waitForElementClickable(driver, AdminPostPageUI.ADMIN_SEARCH_BUTTON);
        clickToElement(driver, AdminPostPageUI.ADMIN_SEARCH_BUTTON);
        sleepInSecond(1);
    }

    public String getTextInTableDisplay(String rowNumber, String columnName) {
        waitForElementVisible(driver, AdminPostPageUI.ADMIN_CELL_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_NAME, rowNumber, columnName);
        return getElementText(driver, AdminPostPageUI.ADMIN_CELL_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_NAME, rowNumber, columnName);
    }

    public void clickToActionButtonOnRowTable(String rowNumber, String columnName, String actionName) {
        waitForElementVisible(driver, AdminPostPageUI.ADMIN_CELL_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_NAME, rowNumber, columnName);
        hoverToElement(driver, AdminPostPageUI.ADMIN_CELL_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_NAME, rowNumber, columnName);
        waitForElementClickable(driver, AdminPostPageUI.ADMIN_ROW_ACTIONS, actionName);
        clickToElement(driver, AdminPostPageUI.ADMIN_ROW_ACTIONS, actionName);
    }

    public void revomeTagNameValue(String categoryValue) {
        waitForElementClickable(driver, AdminPostPageUI.ADMIN_REMOVE_TAGS, categoryValue);
        clickToElement(driver, AdminPostPageUI.ADMIN_REMOVE_TAGS, categoryValue);
    }

    public Boolean isPostNotFoundMessageDisplay(String message) {
        waitForElementVisible(driver, AdminPostPageUI.ADMIN_MESSAGE_SEARCH_NOT_FOUND, message);
        return isElementDisplayedInDOM(driver, AdminPostPageUI.ADMIN_MESSAGE_SEARCH_NOT_FOUND, message);

    }
}
