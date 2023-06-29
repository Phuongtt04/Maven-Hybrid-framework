package pageObjects.wordpressPageObject;

import org.openqa.selenium.WebDriver;
import pageObjects.wordpressPageObject.admin.AdminDashboardPO;
import pageObjects.wordpressPageObject.admin.AdminLoginPO;
import pageObjects.wordpressPageObject.admin.AdminPostPO;
import pageObjects.wordpressPageObject.user.WpUserHomePO;
import pageObjects.wordpressPageObject.user.WpUserPostPO;
import pageObjects.wordpressPageObject.user.WpUserSearchPO;

public class PageGenerateManage {

    public static AdminLoginPO getAdminLoginPageObject(WebDriver driver) {
       return new AdminLoginPO(driver);
    }

    public static AdminPostPO getAdminPostPageObject(WebDriver driver) {
        return new AdminPostPO(driver);
    }

    public static AdminDashboardPO getAdminDashboardPageObject(WebDriver driver) {
        return new AdminDashboardPO(driver);
    }

    public static WpUserSearchPO getWpSearchPageObject(WebDriver driver) {
        return new WpUserSearchPO(driver);
    }

    public static WpUserPostPO getWpPostPageObject(WebDriver driver) {
        return new WpUserPostPO(driver);
    }

    public static WpUserHomePO getWpUserHomePageObject(WebDriver driver) {
        return new WpUserHomePO(driver);
    }
}
