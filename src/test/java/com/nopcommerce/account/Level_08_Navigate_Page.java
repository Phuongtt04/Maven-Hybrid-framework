package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Level_08_Navigate_Page extends BaseTest {
    WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerPO customerPage;
    private UserComputersPO computersPage;
    private UserElectronicsPO electronicsPage;
    private UserBooksPO booksPage;
    private UserDesktopsPO desktopsPage;
    private UserNoteBooksPO noteBooksPage;

    private String email = randomEmail();


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
    }


    @Test
    public void Register_01_Success() {
        homePage = PageGeneratorManager.getHomePageObject(driver);

        registerPage =  homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox("Phượng");
        registerPage.enterToLastNameTextBox("Test");
        registerPage.enterToEmailTextBox(email);
        registerPage.enterToPasswordTextBox("123456");
        registerPage.enterToConfirmPasswordTextBox("123456");
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getResultSuccessMsg(), "Your registration completed");
    }

    @Test
    public void Register_02_Login_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextBox(email);
        loginPage.enterToPasswordTextBox("123456");
        homePage = loginPage.clickToLoginButton();

//        customerPage = homePage.clickMyAccountLink();
//        Assert.assertEquals(customerPage.getFirstNameTextBoxAttributeValue(), "Phượng");
//        Assert.assertEquals(customerPage.getLastNameTextBoxAttributeValue(), "Test");
//        Assert.assertEquals(customerPage.getEmailTextBoxAttributeValue(), email);

    }

    @Test
    public void Register_03_Navigation_Page() {

        //open page computers
        computersPage = homePage.openComputersPageHeader();

        //open page Books
        booksPage = computersPage.openBooksPage();

        //open page Electronics
        electronicsPage = booksPage.openElectronicsPage();

        //open page Reward point
        computersPage = electronicsPage.openComputersPage();
        //open page desktops
        desktopsPage = computersPage.openDesktopsPage();
        //open page Notebooks
        noteBooksPage = desktopsPage.openNoteBooksPage();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
