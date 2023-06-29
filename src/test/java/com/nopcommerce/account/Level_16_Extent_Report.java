package com.nopcommerce.account;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import reportConfig.ExtentManager;

import java.lang.reflect.Method;

public class Level_16_Extent_Report extends BaseTest {
    WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerPO customerPage;
    private String browserName;
    private String email = randomEmail();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        this.browserName = browserName.toUpperCase();
    }

    @Test
    public void Register_01_EmptyData(Method method) {
        homePage = PageGeneratorManager.getHomePageObject(driver);
        ExtentManager.startTest(method.getName() + "-" + browserName, "Register_01_EmptyData");
        ExtentManager.getTest().log(Status.INFO, "Register_01 - Step 01: Click Register link");
        registerPage = homePage.clickToRegisterLink();

        ExtentManager.getTest().log(Status.INFO, "Register_01 - Step 02: Click Register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO, "Register_01 - Step 03: Verify error message First name display");
        Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");

        ExtentManager.getTest().log(Status.INFO , "Register_01 - Step 04: Verify error message Last name display");
        Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");

        ExtentManager.getTest().log(Status.INFO , "Register_01 - Step 05: Verify error message Email display");
        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Email is required.");

        //fail
        ExtentManager.getTest().log(Status.INFO , "Register_01 - Step 05: Verify error message Password display");
        Assert.assertEquals(registerPage.getPasswordErrorMsgText(), "Password is required....");

        ExtentManager.getTest().log(Status.INFO , "Register_01 - Step 05: Verify error message Confirm display");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "Password is required.");
    }

    @Test
    public void Register_02_InvalidEmail(Method method) {
        homePage = registerPage.clickToNopCommerceLogo();
        ExtentManager.startTest(method.getName() + "-" + browserName, "Register_02_InvalidEmail");

        ExtentManager.getTest().log(Status.INFO , "Register_02 - Step 01: Click Register link");
        registerPage = homePage.clickToRegisterLink();

        ExtentManager.getTest().log(Status.INFO , "Register_02 - Step 02: Enter to firstName textbox");
        registerPage.enterToFirstNameTextBox("Phượng");

        ExtentManager.getTest().log(Status.INFO , "Register_02 - Step 03: Enter to LastName textbox");
        registerPage.enterToLastNameTextBox("Test");

        ExtentManager.getTest().log(Status.INFO , "Register_02 - Step 04: Enter to Email textbox");
        registerPage.enterToEmailTextBox("PhuongTest123@");

        ExtentManager.getTest().log(Status.INFO , "Register_02 - Step 05: Enter to Password textbox");
        registerPage.enterToPasswordTextBox("123456");

        ExtentManager.getTest().log(Status.INFO , "Register_02 - Step 06: Enter to Confirm Password textbox");
        registerPage.enterToConfirmPasswordTextBox("123456");

        ExtentManager.getTest().log(Status.INFO , "Register_02 - Step 07: Click Register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO , "Register_02 - Step 08: Verify error message display");
        Assert.assertEquals(registerPage.getEmailErrorMsgText(), "Wrong email");
    }

    @Test
    public void Register_03_InvalidPassword(Method method) {
        homePage = registerPage.clickToNopCommerceLogo();
        ExtentManager.startTest(method.getName() + "-" + browserName, "Register_03_InvalidPassword");

        ExtentManager.getTest().log(Status.INFO , "Register_03 - Step 01: Click Register link");
        registerPage = homePage.clickToRegisterLink();

        ExtentManager.getTest().log(Status.INFO , "Register_03 - Step 02: Enter to firstName textbox");
        registerPage.enterToFirstNameTextBox("Phượng");

        ExtentManager.getTest().log(Status.INFO , "Register_03 - Step 03: Enter to LastName textbox");
        registerPage.enterToLastNameTextBox("Test");

        ExtentManager.getTest().log(Status.INFO , "Register_03 - Step 04: Enter to Email textbox");
        registerPage.enterToEmailTextBox("PhuongTest123@gmail.com");

        ExtentManager.getTest().log(Status.INFO , "Register_03 - Step 05: Enter to Password textbox");
        registerPage.enterToPasswordTextBox("1");

        ExtentManager.getTest().log(Status.INFO , "Register_03 - Step 06: Enter to Confirm Password textbox");
        registerPage.enterToConfirmPasswordTextBox("123456");

        ExtentManager.getTest().log(Status.INFO , "Register_03 - Step 07: Enter to Register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO , "Register_03 - Step 08: Verify error message display");
        Assert.assertEquals(registerPage.getPasswordErrorMsgText(), "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void Register_04_Incorrect_Confirm_Password(Method method) {
        homePage = registerPage.clickToNopCommerceLogo();
        ExtentManager.startTest(method.getName() + "-" + browserName, "Register_04_Incorrect Confirm Password");

        ExtentManager.getTest().log(Status.INFO , "Register_04 - Step 01: Click Register link");
        registerPage = homePage.clickToRegisterLink();

        ExtentManager.getTest().log(Status.INFO , "Register_04 - Step 02: Enter to firstName textbox");
        registerPage.enterToFirstNameTextBox("Phượng");

        ExtentManager.getTest().log(Status.INFO , "Register_04 - Step 03: Enter to LastName textbox");
        registerPage.enterToLastNameTextBox("Test");

        ExtentManager.getTest().log(Status.INFO , "Register_04 - Step 04: Enter to Email textbox");
        registerPage.enterToEmailTextBox("PhuongTest123@gmail.com");

        ExtentManager.getTest().log(Status.INFO , "Register_04 - Step 05: Enter to Password textbox");
        registerPage.enterToPasswordTextBox("123456");

        ExtentManager.getTest().log(Status.INFO , "Register_04 - Step 06: Enter to Confirm Password textbox");
        registerPage.enterToConfirmPasswordTextBox("abc");

        ExtentManager.getTest().log(Status.INFO , "Register_04 - Step 07: Enter to Register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO , "Register_04 - Step 08: Verify error message display");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMsgText(), "The password and confirmation password do not match.");

    }

    @Test
    public void Register_05_Success(Method method) {
        homePage = registerPage.clickToNopCommerceLogo();
        ExtentManager.startTest(method.getName() + "-" + browserName, "Register_05_Success");

        ExtentManager.getTest().log(Status.INFO , "Register_05 - Step 01: Click Register link");
        registerPage =  homePage.clickToRegisterLink();

        ExtentManager.getTest().log(Status.INFO , "Register_05 - Step 02: Enter to firstName textbox");
        registerPage.enterToFirstNameTextBox("Phượng");

        ExtentManager.getTest().log(Status.INFO , "Register_05 - Step 03: Enter to LastName textbox");
        registerPage.enterToLastNameTextBox("Test");

        ExtentManager.getTest().log(Status.INFO , "Register_05 - Step 04: Enter to Email textbox");
        registerPage.enterToEmailTextBox(email);

        ExtentManager.getTest().log(Status.INFO , "Register_05 - Step 05: Enter to Password textbox");
        registerPage.enterToPasswordTextBox("123456");

        ExtentManager.getTest().log(Status.INFO , "Register_05 - Step 06: Enter to Confirm Password textbox");
        registerPage.enterToConfirmPasswordTextBox("123456");

        ExtentManager.getTest().log(Status.INFO , "Register_05 - Step 07: Enter to Register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO , "Register_05 - Step 08: Verify message display");
        Assert.assertEquals(registerPage.getResultSuccessMsg(), "Your registration completed");
    }

    @Test
    public void Register_06_Login_Success(Method method) {
        homePage = registerPage.clickToNopCommerceLogo();
        ExtentManager.startTest(method.getName() + "-" + browserName, "Register_06_Login_Success");

        ExtentManager.getTest().log(Status.INFO , "Register_06 - Step 01: Click Login link");
        loginPage = homePage.clickToLoginLink();

        ExtentManager.getTest().log(Status.INFO , "Register_06 - Step 02: Enter to Email textbox");
        loginPage.enterToEmailTextBox(email);

        ExtentManager.getTest().log(Status.INFO , "Register_06 - Step 03: Enter to Password textbox");
        loginPage.enterToPasswordTextBox("123456");

        ExtentManager.getTest().log(Status.INFO , "Register_06 - Step 04: Enter to Login button");
        homePage = loginPage.clickToLoginButton();

        ExtentManager.getTest().log(Status.INFO , "Register_06 - Step 05: Enter to Login button");
        customerPage = homePage.clickMyAccountLink();

        ExtentManager.getTest().log(Status.INFO , "Register_06 - Step 06:Verify FirstName display: Phượng");
        verifyEqual(customerPage.getFirstNameTextBoxAttributeValue(), "Phượng");
        //fail
        ExtentManager.getTest().log(Status.INFO , "Register_06 - Step 07: Verify error message display");
        Assert.assertEquals(customerPage.getLastNameTextBoxAttributeValue(), "Test...");

        ExtentManager.getTest().log(Status.INFO , "Register_06 - Step 08: Verify email display:" + email);
        Assert.assertEquals(customerPage.getEmailTextBoxAttributeValue(), email);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
