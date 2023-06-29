package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;

public class Level_15_Log_ReportNG extends BaseTest {
    WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerPO customerPage;
    private String email = randomEmail();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
    }

    @Test
    public void Register_01_EmptyData() {
        homePage = PageGeneratorManager.getHomePageObject(driver);
        log.info("Register_01 - Step 01: Click Register link");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register_01 - Step 02: Click Register button");
        registerPage.clickToRegisterButton();

        log.info("Register_01 - Step 03: Verify error message First name display");
        Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");

        log.info("Register_01 - Step 04: Verify error message Last name display");
        Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");

        log.info("Register_01 - Step 05: Verify error message Email display");
        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Email is required.");

        //fail
        log.info("Register_01 - Step 05: Verify error message Password display");
        Assert.assertEquals(registerPage.getPasswordErrorMsgText(), "Password is required....");

        log.info("Register_01 - Step 05: Verify error message Confirm display");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "Password is required.");
    }

    @Test
    public void Register_02_InvalidEmail() {
        homePage = registerPage.clickToNopCommerceLogo();

        log.info("Register_02 - Step 01: Click Register link");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register_02 - Step 02: Enter to firstName textbox");
        registerPage.enterToFirstNameTextBox("Phượng");

        log.info("Register_02 - Step 03: Enter to LastName textbox");
        registerPage.enterToLastNameTextBox("Test");

        log.info("Register_02 - Step 04: Enter to Email textbox");
        registerPage.enterToEmailTextBox("PhuongTest123@");

        log.info("Register_02 - Step 05: Enter to Password textbox");
        registerPage.enterToPasswordTextBox("123456");

        log.info("Register_02 - Step 06: Enter to Confirm Password textbox");
        registerPage.enterToConfirmPasswordTextBox("123456");

        log.info("Register_02 - Step 07: Click Register button");
        registerPage.clickToRegisterButton();

        log.info("Register_02 - Step 08: Verify error message display");
        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Wrong email");
    }

    @Test
    public void Register_03_InvalidPassword() {
        homePage = registerPage.clickToNopCommerceLogo();

        log.info("Register_03 - Step 01: Click Register link");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register_03 - Step 02: Enter to firstName textbox");
        registerPage.enterToFirstNameTextBox("Phượng");

        log.info("Register_03 - Step 03: Enter to LastName textbox");
        registerPage.enterToLastNameTextBox("Test");

        log.info("Register_03 - Step 04: Enter to Email textbox");
        registerPage.enterToEmailTextBox("PhuongTest123@gmail.com");

        log.info("Register_03 - Step 05: Enter to Password textbox");
        registerPage.enterToPasswordTextBox("1");

        log.info("Register_03 - Step 06: Enter to Confirm Password textbox");
        registerPage.enterToConfirmPasswordTextBox("123456");

        log.info("Register_03 - Step 07: Enter to Register button");
        registerPage.clickToRegisterButton();

        log.info("Register_03 - Step 08: Verify error message display");
        Assert.assertEquals(registerPage.getPasswordErrorMsgText(), "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void Register_04_Incorrect_Confirm_Password() {
        homePage = registerPage.clickToNopCommerceLogo();

        log.info("Register_04 - Step 01: Click Register link");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register_04 - Step 02: Enter to firstName textbox");
        registerPage.enterToFirstNameTextBox("Phượng");

        log.info("Register_04 - Step 03: Enter to LastName textbox");
        registerPage.enterToLastNameTextBox("Test");

        log.info("Register_04 - Step 04: Enter to Email textbox");
        registerPage.enterToEmailTextBox("PhuongTest123@gmail.com");

        log.info("Register_04 - Step 05: Enter to Password textbox");
        registerPage.enterToPasswordTextBox("123456");

        log.info("Register_04 - Step 06: Enter to Confirm Password textbox");
        registerPage.enterToConfirmPasswordTextBox("abc");

        log.info("Register_04 - Step 07: Enter to Register button");
        registerPage.clickToRegisterButton();

        log.info("Register_04 - Step 08: Verify error message display");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "The password and confirmation password do not match.");

    }

    @Test
    public void Register_05_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

        log.info("Register_05 - Step 01: Click Register link");
        registerPage =  homePage.clickToRegisterLink();

        log.info("Register_05 - Step 02: Enter to firstName textbox");
        registerPage.enterToFirstNameTextBox("Phượng");

        log.info("Register_05 - Step 03: Enter to LastName textbox");
        registerPage.enterToLastNameTextBox("Test");

        log.info("Register_05 - Step 04: Enter to Email textbox");
        registerPage.enterToEmailTextBox(email);

        log.info("Register_05 - Step 05: Enter to Password textbox");
        registerPage.enterToPasswordTextBox("123456");

        log.info("Register_05 - Step 06: Enter to Confirm Password textbox");
        registerPage.enterToConfirmPasswordTextBox("123456");

        log.info("Register_05 - Step 07: Enter to Register button");
        registerPage.clickToRegisterButton();

        log.info("Register_05 - Step 08: Verify message display");
        Assert.assertEquals(registerPage.getResultSuccessMsg(), "Your registration completed");
    }

    @Test
    public void Register_06_Login_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

        log.info("Register_06 - Step 01: Click Login link");
        loginPage = homePage.clickToLoginLink();

        log.info("Register_06 - Step 02: Enter to Email textbox");
        loginPage.enterToEmailTextBox(email);

        log.info("Register_06 - Step 03: Enter to Password textbox");
        loginPage.enterToPasswordTextBox("123456");

        log.info("Register_06 - Step 04: Enter to Login button");
        homePage = loginPage.clickToLoginButton();

        log.info("Register_06 - Step 05: Enter to Login button");
        customerPage = homePage.clickMyAccountLink();

        log.info("Register_06 - Step 06:Verify FirstName display: Phượng");
        verifyEqual(customerPage.getFirstNameTextBoxAttributeValue(), "Phượng");
        //fail
        log.info("Register_06 - Step 07: Verify error message display");
        Assert.assertEquals(customerPage.getLastNameTextBoxAttributeValue(), "Test...");

        log.info("Register_06 - Step 08: Verify email display:" + email);
        Assert.assertEquals(customerPage.getEmailTextBoxAttributeValue(), email);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
