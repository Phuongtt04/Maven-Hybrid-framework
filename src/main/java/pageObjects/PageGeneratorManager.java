package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static UserHomePO getHomePageObject(WebDriver driver){
        return new UserHomePO(driver);
    }
    public static UserRegisterPO getRegisterPageObject(WebDriver driver){
        return new UserRegisterPO(driver);
    }
    public static UserLoginPO getLoginPageObject(WebDriver driver){
        return new UserLoginPO(driver);
    }
    public static UserCustomerPO getCustomerPageObject(WebDriver driver){
        return new UserCustomerPO(driver);
    }

    public static UserCustomerInfoPO getCustomerInfoPageObject(WebDriver driver){
        return new UserCustomerInfoPO(driver);
    }

    public static UserOrdersPO getOrdersPageObject(WebDriver driver){
        return new UserOrdersPO(driver);
    }

    public static UserMyPO getMyProductReviewPageObject(WebDriver driver){
        return new UserMyPO(driver);
    }

    public static UserRewardPointPO getRewardPointPageObject(WebDriver driver){
        return new UserRewardPointPO(driver);
    }

    public static UserBooksPO getBooksPageObject(WebDriver driver){
        return new UserBooksPO(driver);
    }

    public static UserComputersPO getComputersPageObject(WebDriver driver){
        return new UserComputersPO(driver);
    }

    public static UserNoteBooksPO getNoteBooksPageObject(WebDriver driver){
        return new UserNoteBooksPO(driver);
    }

    public static UserDesktopsPO getDesktopsPageObject(WebDriver driver){
        return new UserDesktopsPO(driver);
    }

    public static UserElectronicsPO getElectronicsPageObject(WebDriver driver){
        return new UserElectronicsPO(driver);
    }

    public static AdminDasboardPO getAdminDasboardPageObject(WebDriver driver){
        return new AdminDasboardPO(driver);
    }

    public static AdminLoginPO getAdminLoginPageObject(WebDriver driver){
        return new AdminLoginPO(driver);
    }
}
