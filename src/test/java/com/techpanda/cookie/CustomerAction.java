package com.techpanda.cookie;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.techPandaPageObject.HomePagePO;
import pageObjects.techPandaPageObject.LoginPO;
import pageObjects.techPandaPageObject.MyAccountPO;

public class CustomerAction extends BaseTest {
    WebDriver driver;
    private HomePagePO homePagePage;
    private LoginPO loginPage;
    private MyAccountPO myAccountPage;
    private String userName, password;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePagePage = pageObjects.techPandaPageObject.PageGeneratorManager.getHomePage(driver);
        loginPage = homePagePage.clickToMyAccountLink();
        loginPage.setCookies(driver, common_Login.loginCookies);

        myAccountPage = pageObjects.techPandaPageObject.PageGeneratorManager.getMyAccountPage(driver);
        myAccountPage.sleepInSecond(3);
    }

    @Test
    public void TC_01() {

    }

    @Test
    public void TC_02() {

    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}
