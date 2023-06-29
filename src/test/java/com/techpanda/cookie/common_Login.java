package com.techpanda.cookie;

import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.AdminDasboardPO;
import pageObjects.AdminLoginPO;
import pageObjects.techPandaPageObject.HomePagePO;
import pageObjects.techPandaPageObject.LoginPO;
import pageObjects.techPandaPageObject.MyAccountPO;
import pageObjects.techPandaPageObject.PageGeneratorManager;

import java.util.Set;

public class common_Login extends BaseTest {
    WebDriver driver;
    private LoginPO loginPage;
    private HomePagePO homePage;
    private MyAccountPO myAccountPage;
    private String userName, password;
    static Set<Cookie> loginCookies;

    @Parameters({"browser", "userUrl"})
    @BeforeTest(alwaysRun = true)
    public void beforeTest(String browserName, String url) {
        userName = "automationfc.com@gmail.com";
        password = "123123";
        driver = getBrowserDriver(browserName, url);

        homePage = PageGeneratorManager.getHomePage(driver);
        loginPage = homePage.clickToMyAccountLink();
        loginPage.enterToEmailTextbox(userName);
        loginPage.enterToPasswordTextbox(password);
        myAccountPage = loginPage.clickToLoginButton();

        Assert.assertTrue(myAccountPage.isDisplayedHeaderText());
        myAccountPage.sleepInSecond(3);
        //get cookies
        loginCookies = myAccountPage.getCookies(driver);
        driver.quit();

    }
}
