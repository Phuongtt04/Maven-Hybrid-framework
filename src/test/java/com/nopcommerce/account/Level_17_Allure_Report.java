package com.nopcommerce.account;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import reportConfig.ExtentManager;

import java.lang.reflect.Method;

public class Level_17_Allure_Report extends BaseTest {
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

    @Description("User register with empty data")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Register_01_EmptyData(Method method) {
        homePage = PageGeneratorManager.getHomePageObject(driver);
        registerPage = homePage.clickToRegisterLink();

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");

        Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");

        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Email is required.");

        //fail
        Assert.assertEquals(registerPage.getPasswordErrorMsgText(), "Password is required....");

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "Password is required.");
    }

    @Description("User register with Invalid Email")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Register_02_InvalidEmail(Method method) {
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox("Phượng");

        registerPage.enterToLastNameTextBox("Test");

        registerPage.enterToEmailTextBox("PhuongTest123@");

        registerPage.enterToPasswordTextBox("123456");

        registerPage.enterToConfirmPasswordTextBox("123456");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Wrong email");
    }

    @Description("User register with Invalid EmailPassword")
    @Test
    public void Register_03_InvalidPassword(Method method) {
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox("Phượng");

        registerPage.enterToLastNameTextBox("Test");

        registerPage.enterToEmailTextBox("PhuongTest123@gmail.com");

        registerPage.enterToPasswordTextBox("1");

        registerPage.enterToConfirmPasswordTextBox("123456");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getPasswordErrorMsgText(), "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Description("User register with Invalid Confirm Password")
    @Test
    public void Register_04_Incorrect_Confirm_Password(Method method) {
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox("Phượng");

        registerPage.enterToLastNameTextBox("Test");

        registerPage.enterToEmailTextBox("PhuongTest123@gmail.com");

        registerPage.enterToPasswordTextBox("123456");

        registerPage.enterToConfirmPasswordTextBox("abc");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "The password and confirmation password do not match.");

    }

    @Description("User register Success")
    @Test
    public void Register_05_Success(Method method) {
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage =  homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox("Phượng");

        registerPage.enterToLastNameTextBox("Test");

        registerPage.enterToEmailTextBox(email);

        registerPage.enterToPasswordTextBox("123456");

        registerPage.enterToConfirmPasswordTextBox("123456");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getResultSuccessMsg(), "Your registration completed");
    }

    @Description("User Login success")
    @Test
    public void Register_06_Login_Success(Method method) {
        homePage = registerPage.clickToNopCommerceLogo();

        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextBox(email);

        loginPage.enterToPasswordTextBox("123456");

        homePage = loginPage.clickToLoginButton();

        customerPage = homePage.clickMyAccountLink();

        verifyEqual(customerPage.getFirstNameTextBoxAttributeValue(), "Phượng");
        //fail
        Assert.assertEquals(customerPage.getLastNameTextBoxAttributeValue(), "Test...");

        Assert.assertEquals(customerPage.getEmailTextBoxAttributeValue(), email);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
