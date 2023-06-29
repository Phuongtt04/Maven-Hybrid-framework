package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    //không cần khởi tạo đối tượng mà vẫn truy cập vào hàm này được
    //Truy cập trực tiếp từ phạm vi class
    protected static BasePage getBasePage() {
        return new BasePage();
    }

    /* Windown */

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /* Web Element */
    public By getByXpath(String locator){
        return By.xpath(locator);
    }

    public WebElement getWebElement(WebElement element) {
       return element;
    }

    public List<WebElement> getListWebElement(WebElement element) {
        return (List<WebElement>) element;
    }

    public void clickToElement(WebElement element) {
        element.click();
    }
    public void senKeyToElement(WebElement element, String value) {
       element.clear();
        element.sendKeys(value);
    }


    public void selectItemInDefaultDropdown(WebElement element,  String itemValue){
        new Select(element).selectByVisibleText(itemValue);
    }

    public boolean isDefaultDropdownMultiple(WebElement element) {
       return  new Select(element).isMultiple();
    }


    public String getElementText(WebElement element) {
        return element.getText();
    }

    public String getElementAttribute(WebElement element, String attributeName) {
      return element.getAttribute(attributeName);
    }

    public String getElementCssValue(WebElement element, String cssPropertyName) {
        return element.getCssValue(cssPropertyName);
    }

    public String convertRGBAToHexaColor(WebElement element) {
       return Color.fromString(getElementCssValue(element, "background-color")).asHex();
    }

    public int getListElementSize(List<WebElement> element) {
        return element.size();
    }


    /**
     * Apply for checkbox and radio
     * @param element
     */
    public void checkToElement(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }


    /**
     * Apply only checkbox
     * @param element
     */
    public void unCheckToElement(WebElement element) {
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }

    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }

    public void switchToIframe(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public void switchToDefaultContent(WebDriver driver){
        driver.switchTo().defaultContent();
    }

    /* ACTIONS */
    public void hoverToElement(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    public void doubleClickToElement(WebDriver driver, WebElement element) {
        new Actions(driver).doubleClick(element).perform();
    }

    public void rightClickToElement(WebDriver driver, WebElement element) {
        new Actions(driver).contextClick(element).perform();
    }

    public void dragAndDropToElement(WebDriver driver, WebElement sourceElement,  WebElement targetElement) {
        new Actions(driver).dragAndDrop(sourceElement, targetElement) ;
    }

    public void sendKeyBoardToElement(WebDriver driver, WebElement element, Keys key) {
        new Actions(driver).sendKeys(element, key).perform();
    }

    /* WAIT */
    public void waitForElementVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForListElementVisible(WebDriver driver, List<WebElement> element) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void waitForElementInVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForListElementInVisible(WebDriver driver, List<WebElement> element) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfAllElements(element));
    }

    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
    }
}
