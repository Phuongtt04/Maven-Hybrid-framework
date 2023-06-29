package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;

@Listeners(commons.MethodListener.class)
public class Level_14_Assert_Verify extends BaseTest {
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
        registerPage = homePage.clickToRegisterLink();
        registerPage.clickToRegisterButton();

        verifyEqual(registerPage.getFirstNameErrorMsgText(), "First name is required.");
        verifyEqual(registerPage.getLastNameErrorMsgText(), "Last name is required.");
        verifyEqual(registerPage.getEmailErrorMsgText(), "Email is required.");
        //fail
        verifyEqual(registerPage.getPasswordErrorMsgText(), "Password is required....");
        verifyEqual(registerPage.getConfirmPasswordErrorMsgText(), "Password is required.");
    }

    @Test
    public void Register_02_InvalidEmail() {
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTextBox("Phượng");
        registerPage.enterToLastNameTextBox("Test");
        registerPage.enterToEmailTextBox("PhuongTest123@");
        registerPage.enterToPasswordTextBox("123456");
        registerPage.enterToConfirmPasswordTextBox("123456");
        registerPage.clickToRegisterButton();

        verifyEqual(registerPage.getEmailErrorMsgText(), "Wrong email");
    }

    @Test
    public void Register_03_InvalidPassword() {
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox("Phượng");
        registerPage.enterToLastNameTextBox("Test");
        registerPage.enterToEmailTextBox("PhuongTest123@gmail.com");
        registerPage.enterToPasswordTextBox("1");
        registerPage.enterToConfirmPasswordTextBox("123456");
        registerPage.clickToRegisterButton();

        verifyEqual(registerPage.getPasswordErrorMsgText(), "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void Register_04_Incorrect_Confirm_Password() {
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox("Phượng");
        registerPage.enterToLastNameTextBox("Test");
        registerPage.enterToEmailTextBox("PhuongTest123@gmail.com");
        registerPage.enterToPasswordTextBox("123456");
        registerPage.enterToConfirmPasswordTextBox("abc");
        registerPage.clickToRegisterButton();

        verifyEqual(registerPage.getConfirmPasswordErrorMsgText(), "The password and confirmation password do not match.");

    }

    @Test
    public void Register_05_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage =  homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox("Phượng");
        registerPage.enterToLastNameTextBox("Test");
        registerPage.enterToEmailTextBox(email);
        registerPage.enterToPasswordTextBox("123456");
        registerPage.enterToConfirmPasswordTextBox("123456");
        registerPage.clickToRegisterButton();

        verifyEqual(registerPage.getResultSuccessMsg(), "Your registration completed");
    }

    @Test
    public void Register_06_Login_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextBox(email);
        loginPage.enterToPasswordTextBox("123456");
        homePage = loginPage.clickToLoginButton();

        customerPage = homePage.clickMyAccountLink();
        verifyEqual(customerPage.getFirstNameTextBoxAttributeValue(), "Phượng");
        //fail
        verifyEqual(customerPage.getLastNameTextBoxAttributeValue(), "Test...");
        verifyEqual(customerPage.getEmailTextBoxAttributeValue(), email);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
