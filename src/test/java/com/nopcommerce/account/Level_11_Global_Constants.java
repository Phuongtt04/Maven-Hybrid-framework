package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Level_11_Global_Constants extends BaseTest {
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
    public void Register_03_C1_Dynamic_Page() {

        //open page computers
        computersPage = homePage.openComputersPageHeader();

        //open page Books
        booksPage = (UserBooksPO) computersPage.openSideBarPageByName("Books");

        //open page Electronics
        electronicsPage = (UserElectronicsPO) booksPage.openSideBarPageByName("Electronics");

        //open page Reward point
        computersPage = (UserComputersPO) electronicsPage.openSideBarPageByName("Computers");
        //open page desktops
        desktopsPage = (UserDesktopsPO) computersPage.openSideBarPageByName("Desktops");
        //open page Notebooks
        noteBooksPage = (UserNoteBooksPO) desktopsPage.openSideBarPageByName("Notebooks");

    }

    @Test
    public void Register_04_C2_Dynamic_Page() {

        //open page computers
        computersPage = homePage.openComputersPageHeader();

        //open page Books
       computersPage.openSideBarPageByPageName("Books");
       booksPage = PageGeneratorManager.getBooksPageObject(driver);

        //open page Electronics
        booksPage.openSideBarPageByPageName("Electronics");
        electronicsPage = PageGeneratorManager.getElectronicsPageObject(driver);

        //open page Reward point
        electronicsPage.openSideBarPageByPageName("Computers");
        computersPage = PageGeneratorManager.getComputersPageObject(driver);
        //open page desktops
        computersPage.openSideBarPageByPageName("Desktops");
        desktopsPage = PageGeneratorManager.getDesktopsPageObject(driver);
        //open page Notebooks
        desktopsPage.openSideBarPageByPageName("Notebooks");
        noteBooksPage = PageGeneratorManager.getNoteBooksPageObject(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
