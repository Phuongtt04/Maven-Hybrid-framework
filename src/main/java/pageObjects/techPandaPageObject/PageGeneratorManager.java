package pageObjects.techPandaPageObject;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static HomePagePO getHomePage(WebDriver driver){
        return new HomePagePO(driver);
    }

    public static LoginPO getLoginPage(WebDriver driver){
        return new LoginPO(driver);
    }

    public static MyAccountPO getMyAccountPage(WebDriver driver){
        return new MyAccountPO(driver);
    }
}
