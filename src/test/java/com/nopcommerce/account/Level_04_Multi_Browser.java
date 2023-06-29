package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.UserCustomerPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserRegisterPO;

public class Level_04_Multi_Browser extends BaseTest {
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
        homePage = new UserHomePO(driver);
        homePage.clickToRegisterLink();

        registerPage = new UserRegisterPO(driver);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Email is required.");
        Assert.assertEquals(registerPage.getPasswordErrorMsgText(), "Password is required.");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "Password is required.");
    }

    @Test
    public void Register_02_InvalidEmail() {
        registerPage.clickToNopCommerceLogo();
        homePage = new UserHomePO(driver);

        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPO(driver);

        registerPage.enterToFirstNameTextBox("Phượng");
        registerPage.enterToLastNameTextBox("Test");
        registerPage.enterToEmailTextBox("PhuongTest123@");
        registerPage.enterToPasswordTextBox("123456");
        registerPage.enterToConfirmPasswordTextBox("123456");
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Wrong email");
    }

    @Test
    public void Register_03_InvalidPassword() {
        registerPage.clickToNopCommerceLogo();
        homePage = new UserHomePO(driver);

        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPO(driver);

        registerPage.enterToFirstNameTextBox("Phượng");
        registerPage.enterToLastNameTextBox("Test");
        registerPage.enterToEmailTextBox("PhuongTest123@gmail.com");
        registerPage.enterToPasswordTextBox("1");
        registerPage.enterToConfirmPasswordTextBox("123456");
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getPasswordErrorMsgText(), "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void Register_04_Incorrect_Confirm_Password() {
        registerPage.clickToNopCommerceLogo();
        homePage = new UserHomePO(driver);

        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPO(driver);

        registerPage.enterToFirstNameTextBox("Phượng");
        registerPage.enterToLastNameTextBox("Test");
        registerPage.enterToEmailTextBox("PhuongTest123@gmail.com");
        registerPage.enterToPasswordTextBox("123456");
        registerPage.enterToConfirmPasswordTextBox("abc");
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "The password and confirmation password do not match.");

    }

    @Test
    public void Register_05_Success() {
        registerPage.clickToNopCommerceLogo();
        homePage = new UserHomePO(driver);

        homePage.clickToRegisterLink();
        registerPage = new UserRegisterPO(driver);

        registerPage.enterToFirstNameTextBox("Phượng");
        registerPage.enterToLastNameTextBox("Test");
        registerPage.enterToEmailTextBox(email);
        registerPage.enterToPasswordTextBox("123456");
        registerPage.enterToConfirmPasswordTextBox("123456");
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getResultSuccessMsg(), "Your registration completed");
    }

    @Test
    public void Register_06_Login_Success() {
        registerPage.clickToNopCommerceLogo();
        homePage = new UserHomePO(driver);

        homePage.clickToLoginLink();
        loginPage = new UserLoginPO(driver);

        loginPage.enterToEmailTextBox(email);
        loginPage.enterToPasswordTextBox("123456");
        loginPage.clickToLoginButton();

        homePage = new UserHomePO(driver);

        homePage.clickMyAccountLink();

        customerPage = new UserCustomerPO(driver);

        Assert.assertEquals(customerPage.getFirstNameTextBoxAttributeValue(), "Phượng");
        Assert.assertEquals(customerPage.getLastNameTextBoxAttributeValue(), "Test");
        Assert.assertEquals(customerPage.getEmailTextBoxAttributeValue(), email);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
