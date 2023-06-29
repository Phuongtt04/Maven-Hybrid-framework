package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsNopCommerce.UserCategoriesSideBarPageUI;

public class UserCategoriesSideBarPO extends BasePage {
    WebDriver driver;

    public UserCategoriesSideBarPO(WebDriver driver) {
        this.driver = driver;
    }
    public UserBooksPO openBooksPage() {
        waitForElementClickable(driver, UserCategoriesSideBarPageUI.BOOKS_LINK_SIDEBAR);
        clickToElement(driver, UserCategoriesSideBarPageUI.BOOKS_LINK_SIDEBAR);
        return PageGeneratorManager.getBooksPageObject(driver);
    }


    public UserComputersPO openComputersPage() {
        waitForElementClickable(driver, UserCategoriesSideBarPageUI.COMPUTERS_LINK_SIDEBAR);
        clickToElement(driver, UserCategoriesSideBarPageUI.COMPUTERS_LINK_SIDEBAR);
        return PageGeneratorManager.getComputersPageObject(driver);
    }

    public UserNoteBooksPO openNoteBooksPage() {
        waitForElementClickable(driver, UserCategoriesSideBarPageUI.NOTE_BOOKS_SUB_LINK_SIDEBAR);
        clickToElement(driver, UserCategoriesSideBarPageUI.NOTE_BOOKS_SUB_LINK_SIDEBAR);
        return PageGeneratorManager.getNoteBooksPageObject(driver);
    }

    public UserDesktopsPO openDesktopsPage() {
        waitForElementClickable(driver, UserCategoriesSideBarPageUI.DESKTOPS_SUB_LINK_SIDEBAR);
        clickToElement(driver, UserCategoriesSideBarPageUI.DESKTOPS_SUB_LINK_SIDEBAR);
        return PageGeneratorManager.getDesktopsPageObject(driver);
    }

    public UserElectronicsPO openElectronicsPage() {
        waitForElementClickable(driver, UserCategoriesSideBarPageUI.ELECTRONICS_LINK_SIDEBAR);
        clickToElement(driver, UserCategoriesSideBarPageUI.ELECTRONICS_LINK_SIDEBAR);
        return PageGeneratorManager.getElectronicsPageObject(driver);
    }

    //Cách chỉ cần viết 1 hàm - áp dụng dynamic
    //Open page (nằm trong cùng vùng ví dụ header, footer, sidebar)
    //cách 1: số lương page ít thì dùng if-else (ít)
    public UserCategoriesSideBarPO  openSideBarPageByName(String pageName) {
        waitForElementVisible(driver, UserCategoriesSideBarPageUI.DYNAMIC_PAGE_NAVIGATION_SIDEBAR_BY_PAGE_NAME, pageName);
        clickToElement(driver, UserCategoriesSideBarPageUI.DYNAMIC_PAGE_NAVIGATION_SIDEBAR_BY_PAGE_NAME, pageName);
        if (pageName.equals("Computers")){
            return PageGeneratorManager.getComputersPageObject(driver);
        } else if (pageName.equals("Electronics")){
            return PageGeneratorManager.getElectronicsPageObject(driver);
        } else if (pageName.equals("Books")) {
            return PageGeneratorManager.getBooksPageObject(driver);
        } else if (pageName.equals("Desktops")) {
            return PageGeneratorManager.getDesktopsPageObject(driver);
        } else if (pageName.equals("Notebooks")) {
            return PageGeneratorManager.getNoteBooksPageObject(driver);
        } else {
            return null;
        }
    }

    //cách 2: Không trả về return (nên dùng cách này)
    public void openSideBarPageByPageName(String pageName) {
        waitForElementVisible(driver, UserCategoriesSideBarPageUI.DYNAMIC_PAGE_NAVIGATION_SIDEBAR_BY_PAGE_NAME, pageName);
        clickToElement(driver, UserCategoriesSideBarPageUI.DYNAMIC_PAGE_NAVIGATION_SIDEBAR_BY_PAGE_NAME, pageName);
    }

}
