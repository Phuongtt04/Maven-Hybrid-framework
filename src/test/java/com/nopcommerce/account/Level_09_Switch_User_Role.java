package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Level_09_Switch_User_Role extends BaseTest {
    WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerPO customerPage;
    private UserCustomerInfoPO customerInfoPage;
    private AdminDasboardPO adminDasboardPage;
    private AdminLoginPO adminLoginPage;
    private String email = randomEmail();
    String userUserName, userPassword;
    String adminUserName, adminPassword;
    String userUrl, adminUrl;

    @Parameters({"browser", "userUrl", "adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        userUserName = email;
        userPassword = "123456";
        adminUserName = "admin@yourstore.com";
        adminPassword = "admin";
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;

        driver = getBrowserDriver(browserName, userUrl);
    }


    @Test
    public void Register_01_Success() {
        homePage = PageGeneratorManager.getHomePageObject(driver);

        registerPage =  homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox("Phượng");
        registerPage.enterToLastNameTextBox("Test");
        registerPage.enterToEmailTextBox(userUserName);
        registerPage.enterToPasswordTextBox(userPassword);
        registerPage.enterToConfirmPasswordTextBox(userPassword);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getResultSuccessMsg(), "Your registration completed");
    }

    @Test
    public void Register_02_User_To_Admin_Page() {
        homePage = registerPage.clickToNopCommerceLogo();
        loginPage = homePage.clickToLoginLink();
        //login user page
        loginPage.enterToEmailTextBox(userUserName);
        loginPage.enterToPasswordTextBox(userPassword);
        homePage = loginPage.clickToLoginButton();


        customerPage = homePage.clickMyAccountLink();

        //from user page to admin page
        customerPage.openPageUrl(driver, adminUrl);
        adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);
        //login admin page
        adminLoginPage.enterToEmailTextBox(adminUserName);
        adminLoginPage.enterToPasswordTextBox(adminPassword);
        adminDasboardPage = adminLoginPage.clickToLoginButton();

    }

    @Test
    public void Register_03_Admin_To_User_Page() {
        //admin page -> user page
        adminDasboardPage.openPageUrl(driver, userUrl);
        homePage = PageGeneratorManager.getHomePageObject(driver);

        //user action on user page
        customerPage = homePage.clickMyAccountLink();
        customerInfoPage = customerPage.openCustomerInfoPage(driver);

        //user page -> admin page
        customerInfoPage.openPageUrl(driver, adminUrl);
        adminDasboardPage = PageGeneratorManager.getAdminDasboardPageObject(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
