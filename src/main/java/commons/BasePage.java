package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import pageObjects.wordpressPageObject.PageGenerateManage;
import pageObjects.wordpressPageObject.admin.AdminDashboardPO;
import pageObjects.wordpressPageObject.user.WpUserHomePO;
import pageUIsJquery.UploadFilesPageUI;
import pageUIsNopCommerce.UserBasePageUI;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private long logTimeOut = GlobalConstants.LONG_TIMEOUT;
    private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;

    //không cần khởi tạo đối tượng mà vẫn truy cập vào hàm này được
    //Truy cập trực tiếp từ phạm vi class
    public static BasePage getBasePage() {
        return new BasePage();

    }
    /* Web browser */

    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, logTimeOut).until(ExpectedConditions.alertIsPresent());

    }

    public void acceptToAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    public void cancelToAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    public String getTextInAlert(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    public void senkeyToAlert(WebDriver driver, String keysToSend) {
        waitForAlertPresence(driver).sendKeys(keysToSend);
    }


    /* Windown */

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void switchToWindownById(WebDriver driver, String parentId) {
        Set<String> allID = driver.getWindowHandles();
        for (String runId : allID) {
            if (!runId.equals(parentId)) {
                driver.switchTo().window(runId);
                break;
            }
        }
    }

    public void switchToWindownByTitle(WebDriver driver, String title) {
        Set<String> allIds = driver.getWindowHandles();
        for (String runId : allIds) {
            driver.switchTo().window(runId);
            String titleCurrent = driver.getTitle();
            if (titleCurrent.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindownsWithoutParent(WebDriver driver, String parentId) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String runId : allIDs) {
            if (!runId.equals(parentId)) {
                driver.switchTo().window(runId);
                driver.close();
            }
        }
        driver.switchTo().window(parentId);
    }

    public Set<Cookie> getCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public void setCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        sleepInSecond(3);
        refreshCurrentPage(driver);
    }

    public void deleteCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }


    /* Web Element */
    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public By getByLocator(String locator) {
        By by = null;

        if (locator.startsWith("id=") || locator.startsWith("Id=") || locator.startsWith("ID=")) {
            locator = locator.substring(3);
            by = By.id(locator);
        } else if (locator.startsWith("class=") || locator.startsWith("Class=") || locator.startsWith("CLASS=")) {
            locator = locator.substring(6);
            by = By.className(locator);
        } else if (locator.startsWith("name=") || locator.startsWith("name=") || locator.startsWith("NAME=")) {
            locator = locator.substring(5);
            by = By.name(locator);
        } else if (locator.startsWith("css=") || locator.startsWith("Css=") || locator.startsWith("CSS=")) {
            locator = locator.substring(4);
            by = By.cssSelector(locator);
        } else if (locator.startsWith("xpath=") || locator.startsWith("Xpath=") || locator.startsWith("XPath=") || locator.startsWith("XPATH=")) {
            locator = locator.substring(6);
            by = By.xpath(locator);
        } else {
            throw new RuntimeException("------------- Your locator is invalid! -------------");
        }
        return by;
    }

    public String getRestParameter(String locator, String... params) {
        return String.format(locator, params);
    }

    public WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public WebElement getWebElement(WebDriver driver, String locator, String... params) {
        return driver.findElement(getByLocator(getRestParameter(locator, params)));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }


    public void clickToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... params) {
        getWebElement(driver, getRestParameter(locator, params)).click();
    }

    public void enterKeyToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).sendKeys(Keys.ENTER);
    }

    public void enterKeyToElement(WebDriver driver, String locator, String... params) {
        getWebElement(driver, getRestParameter(locator, params)).sendKeys(Keys.ENTER);
    }

    public void senKeyToElement(WebDriver driver, String locator, String value) {
        getWebElement(driver, locator).clear();
        getWebElement(driver, locator).sendKeys(value);
    }

    public void senKeyToElement(WebDriver driver, String value, String locator, String... params) {
        getWebElement(driver, getRestParameter(locator, params)).clear();
        getWebElement(driver, getRestParameter(locator, params)).sendKeys(value);
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue) {
        new Select(getWebElement(driver, locator)).selectByVisibleText(itemValue);
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String itemValue, String locator, String... params) {
        new Select(getWebElement(driver, getRestParameter(locator, params))).selectByVisibleText(itemValue);
    }

    public boolean isDefaultDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getWebElement(driver, locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String textExpectedItem) {
        getWebElement(driver, parentLocator).click();
        sleepInSecond(1);

        List<WebElement> allItem = new WebDriverWait(driver, logTimeOut).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));

        for (WebElement item : allItem) {
            if (item.getText().trim().equals(textExpectedItem)) {
                sleepInSecond(1);
                item.click();
                break;
            }
        }
    }

    public String getElementText(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText();
    }

    public String getElementText(WebDriver driver, String locator, String... params) {
        return getWebElement(driver, getRestParameter(locator, params)).getText();
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
        return getWebElement(driver, locator).getAttribute(attributeName);
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... params) {
        return getWebElement(driver, getRestParameter(locator, params)).getAttribute(attributeName);
    }

    public String getElementCssValue(WebDriver driver, String locator, String cssPropertyName) {
        return getWebElement(driver, locator).getCssValue(cssPropertyName);
    }

    public String convertRGBAToHexaColor(WebDriver driver, String locator) {
        return Color.fromString(getElementCssValue(driver, locator, "background-color")).asHex();
    }

    public int getListElementSize(WebDriver driver, String locator) {
        return getListWebElement(driver, locator).size();
    }

    public int getListElementSize(WebDriver driver, String locator, String... params) {
        return getListWebElement(driver, getRestParameter(locator, params)).size();
    }


    /**
     * Apply for checkbox and radio
     *
     * @param driver
     * @param locator
     */
    public void checkToElement(WebDriver driver, String locator) {
        if (!getWebElement(driver, locator).isSelected()) {
            getWebElement(driver, locator).click();
        }
    }

    public void checkToElement(WebDriver driver, String locator, String... params) {
        if (!getWebElement(driver, getRestParameter(locator, params)).isSelected()) {
            getWebElement(driver, getRestParameter(locator, params)).click();
        }
    }


    /**
     * Apply only checkbox
     *
     * @param driver
     * @param locator
     */
    public void unCheckToElement(WebDriver driver, String locator) {
        if (getWebElement(driver, locator).isSelected()) {
            getWebElement(driver, locator).click();
        }
    }

    public void unCheckToElement(WebDriver driver, String locator, String... params) {
        if (getWebElement(driver, getRestParameter(locator, params)).isSelected()) {
            getWebElement(driver, getRestParameter(locator, params)).click();
        }
    }

    public boolean isElementDisplayedInDOM(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isDisplayed();
    }

    public boolean isElementDisplayedInDOM(WebDriver driver, String locator, String... params) {
        return getWebElement(driver, getRestParameter(locator, params)).isDisplayed();
    }

    public boolean isElementUnDisplayed(WebDriver driver, String locator) {
        setImplicitTime(driver, shortTimeout);
        List<WebElement> elements = getListWebElement(driver, locator);
        setImplicitTime(driver, logTimeOut);
        if (elements.size() == 0) {
            System.out.println("Element not in DOM");
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            System.out.println("Element in DOM but not visible/ displayed");
            return true;
        } else {
            System.out.println("Element in DOM and visible");
            return false;
        }
    }

    public void setImplicitTime(WebDriver driver, long timeInSecond) {
        driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isSelected();
    }

    public boolean isElementSelected(WebDriver driver, String locator, String... params) {
        return getWebElement(driver, getRestParameter(locator, params)).isSelected();
    }

    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isEnabled();
    }

    public boolean isElementEnabled(WebDriver driver, String locator, String... params) {
        return getWebElement(driver, getRestParameter(locator, params)).isEnabled();
    }

    public void switchToIframe(WebDriver driver, String locator) {
        new WebDriverWait(driver, logTimeOut).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(locator)));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    /* ACTIONS */
    public void hoverToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getWebElement(driver, locator)).perform();
    }

    public void hoverToElement(WebDriver driver, String locator, String... params) {
        new Actions(driver).moveToElement(getWebElement(driver, getRestParameter(locator, params))).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getWebElement(driver, locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getWebElement(driver, locator)).perform();
    }

    public void dragAndDropToElement(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator));
    }

    public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
        new Actions(driver).sendKeys(getWebElement(driver, locator), key).perform();
    }

    public void sendKeyBoardToElement(WebDriver driver, Keys key, String locator, String... params) {
        new Actions(driver).sendKeys(getWebElement(driver, getRestParameter(locator, params)), key).perform();
    }


    /* EXECUTOR */

    public Object executeForBrowser(WebDriver driver, String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    public String getURL(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.URL;");
    }

    public String getDomain(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.domain;");
    }

    public String getTitle(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.title;");
    }

    public String getInnerText(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
        String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(WebDriver driver, String locator) {
        WebElement element = getWebElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
    }

    public void scrollToElementOnDown(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locator));
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getWebElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
    }

    public String getAttributeInDOM(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver, locator));
    }


    public String getWebElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
    }


    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
    }


    /* WAIT */
    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, logTimeOut).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... params) {
        new WebDriverWait(driver, logTimeOut).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getRestParameter(locator, params))));
    }

    public void waitForListElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, logTimeOut).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, locator)));
    }

    public void waitForListElementVisible(WebDriver driver, String locator, String... params) {
        new WebDriverWait(driver, logTimeOut).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, getRestParameter(locator, params))));
    }

    public void waitForElementInVisibleInDOM(WebDriver driver, String locator) {
        new WebDriverWait(driver, logTimeOut).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForListElementInVisibleInDOM(WebDriver driver, String locator) {
        new WebDriverWait(driver, logTimeOut).until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));
    }

    public void waitForElementInVisibleNotInDOM(WebDriver driver, String locator) {
        setImplicitTime(driver, shortTimeout);
        new WebDriverWait(driver, shortTimeout).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
        setImplicitTime(driver, logTimeOut);
    }


    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, logTimeOut).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... params) {
        new WebDriverWait(driver, logTimeOut).until(ExpectedConditions.elementToBeClickable(getByLocator(getRestParameter(locator, params))));
    }

    // UPLOAD FILE
    public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        ///Đường dẫn đến thư mục upload
        String uploadFilePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName = fullFileName + uploadFilePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getWebElement(driver, UploadFilesPageUI.UPLOAD_FILE).sendKeys(fullFileName);
    }

    /**
     * Common function for Web Component
     **/
    public void enterToTextBoxByID(WebDriver driver, String textBoxID, String valueToInput) {
        waitForElementVisible(driver, UserBasePageUI.DYNAMIC_TEXTBOX_BY_ID, textBoxID);
        senKeyToElement(driver, valueToInput, UserBasePageUI.DYNAMIC_TEXTBOX_BY_ID, textBoxID);
    }

    public void clickToButtonByType(WebDriver driver, String buttonType) {
        waitForElementClickable(driver, UserBasePageUI.DYNAMIC_BUTTON_BY_CLASS, buttonType);
        clickToElement(driver, UserBasePageUI.DYNAMIC_BUTTON_BY_CLASS, buttonType);
    }

    public String getErrorMessageField(WebDriver driver, String fieldID) {
        waitForElementClickable(driver, UserBasePageUI.FIELD_ERROR_MESSAGE, fieldID);
        return getElementText(driver, UserBasePageUI.FIELD_ERROR_MESSAGE, fieldID);
    }

    public String getMessagePage(WebDriver driver) {
        waitForElementClickable(driver, UserBasePageUI.PAGE_MSG);
        return getElementText(driver, UserBasePageUI.PAGE_MSG);
    }


    public UserCustomerInfoPO openCustomerInfoPage(WebDriver driver) {
        waitForElementVisible(driver, UserBasePageUI.CUSTOMER_INFO_LINK_SIDEBAR);
        clickToElement(driver, UserBasePageUI.CUSTOMER_INFO_LINK_SIDEBAR);
        return PageGeneratorManager.getCustomerInfoPageObject(driver);
    }

    public UserOrdersPO openOrdersPage(WebDriver driver) {
        waitForElementVisible(driver, UserBasePageUI.ORDERS_LINK_SIDEBAR);
        clickToElement(driver, UserBasePageUI.ORDERS_LINK_SIDEBAR);
        return PageGeneratorManager.getOrdersPageObject(driver);
    }

    public UserMyPO openMyProductReviewPage(WebDriver driver) {
        waitForElementVisible(driver, UserBasePageUI.MY_PRODUCT_REVIEW_LINK_SIDEBAR);
        clickToElement(driver, UserBasePageUI.MY_PRODUCT_REVIEW_LINK_SIDEBAR);
        return PageGeneratorManager.getMyProductReviewPageObject(driver);
    }

    public UserRewardPointPO openRewardPointPage(WebDriver driver) {
        waitForElementVisible(driver, UserBasePageUI.REWARD_POINT_LINK_SIDEBAR);
        clickToElement(driver, UserBasePageUI.REWARD_POINT_LINK_SIDEBAR);
        return PageGeneratorManager.getRewardPointPageObject(driver);
    }


    public AdminDashboardPO openAdminDashboardPageObject(WebDriver driver, String adminUrl) {
        openPageUrl(driver, adminUrl);
        return PageGenerateManage.getAdminDashboardPageObject(driver);
    }

    public WpUserHomePO openWpUserHomePageObject(WebDriver driver, String userUrl) {
        openPageUrl(driver, userUrl);
        return PageGenerateManage.getWpUserHomePageObject(driver);
    }

}
