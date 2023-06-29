package pageObjects.JqueryDataTablePageObject;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIsJquery.HomePageUI;
import pageUIsJquery.UploadFilesPageUI;

import java.util.List;

public class HomePagePO extends BasePage {
    WebDriver driver;

    public HomePagePO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToHeaderTextBoxByHeaderName(String headerName, String values) {
        waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_HEADER_NAME, headerName);
        senKeyToElement(driver, values, HomePageUI.HEADER_TEXTBOX_BY_HEADER_NAME, headerName);
        sendKeyBoardToElement(driver, Keys.ENTER, HomePageUI.HEADER_TEXTBOX_BY_HEADER_NAME, headerName);
    }

    public boolean isRowValuIsDispay(String... params){
        waitForElementVisible(driver, HomePageUI.ROW_VALUE_BY_HEADER_NAME, params);
        return isElementDisplayedInDOM(driver, HomePageUI.ROW_VALUE_BY_HEADER_NAME, params);

    }

    public void clickToActionByHeaderName(String headerNameValue, String actionIcon) {
        waitForElementClickable(driver, HomePageUI.ACTION_ICON, headerNameValue, actionIcon);
        clickToElement(driver, HomePageUI.ACTION_ICON, headerNameValue, actionIcon);
    }

    public void clickToPageNumber(String pageNumberValue) {
        waitForElementClickable(driver, HomePageUI.PAGE_NUMBER, pageNumberValue);
        clickToElement(driver, HomePageUI.PAGE_NUMBER, pageNumberValue);
    }

    public boolean isPageNumberActived(String pageNumberValue) {
        waitForElementVisible(driver, HomePageUI.PAGE_ACTIVE_NUMBER, pageNumberValue);
        return isElementDisplayedInDOM(driver, HomePageUI.PAGE_ACTIVE_NUMBER, pageNumberValue);

    }

    public void enterToTextBoxByHeaderNameAndRowNumber(String headerNameValue, String rowNumber, String values) {
        waitForElementVisible(driver, HomePageUI.HEADER_INDEX_BY_NAME, headerNameValue);
        int headerIndex = getListElementSize(driver, HomePageUI.HEADER_INDEX_BY_NAME, headerNameValue) + 1;

        waitForElementVisible(driver, HomePageUI.CELL_TEXTBOX_BY_HEADER_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(headerIndex));
        senKeyToElement(driver, values, HomePageUI.CELL_TEXTBOX_BY_HEADER_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(headerIndex));
    }

    public void selectToDropDownByHeaderNameAndRowNumber(String headerNameValue, String rowNumber, String values) {
        waitForElementVisible(driver, HomePageUI.HEADER_INDEX_BY_NAME, headerNameValue);
        int headerIndex = getListElementSize(driver, HomePageUI.HEADER_INDEX_BY_NAME, headerNameValue) + 1;

        waitForElementClickable(driver, HomePageUI.CELL_DROPDOWN_BY_HEADER_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(headerIndex));
        clickToElement(driver, HomePageUI.CELL_DROPDOWN_BY_HEADER_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(headerIndex));
        selectItemInDefaultDropdown(driver, values, HomePageUI.CELL_DROPDOWN_BY_HEADER_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(headerIndex));
    }

    public void clickToLoadButton() {
        waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_BUTTON);
    }


    public void clickToButtonUploadFile() {
        waitForElementClickable(driver, UploadFilesPageUI.UPLOAD_FILE);
        clickToElement(driver, UploadFilesPageUI.UPLOAD_FILE);
    }

    public void clickButtonStartUploadFile(String valueButton){
        waitForElementClickable(driver, getRestParameter(UploadFilesPageUI.BUTTON_START_UPLOAD_FILE, valueButton));
        clickToElement(driver, getRestParameter(UploadFilesPageUI.BUTTON_START_UPLOAD_FILE, valueButton));
    }

    public void clickListButtonStartUploadFile(String valueButton){
        waitForElementClickable(driver, getRestParameter(UploadFilesPageUI.BUTTON_START_UPLOAD_FILE, valueButton));
        List<WebElement> startListButton = getListWebElement(driver, getRestParameter(UploadFilesPageUI.BUTTON_START_UPLOAD_FILE, valueButton));
        for (WebElement buttonStartItem : startListButton) {
            buttonStartItem.click();
            sleepInSecond(2);
        }
    }

    public boolean isFileNameLoaded(String fileNameValue) {
        waitForElementVisible(driver, getRestParameter(UploadFilesPageUI.IMAGE_FILE_NAME_LOADED, fileNameValue));
        return isElementDisplayedInDOM(driver, getRestParameter(UploadFilesPageUI.IMAGE_FILE_NAME_LOADED, fileNameValue));
    }

    public boolean isDisplayFileUpload(String fileNameValue) {
        waitForElementVisible(driver, getRestParameter(UploadFilesPageUI.IS_DISPLAY_UPLOAD_FILE, fileNameValue));
        return isElementDisplayedInDOM(driver, getRestParameter(UploadFilesPageUI.IS_DISPLAY_UPLOAD_FILE, fileNameValue));
    }


}
