package com.facebook;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.LoginPO;
import pageObjects.facebook.PageGeneratorManager;

public class Level_18_Element_Undisplay extends BaseTest {
    WebDriver driver;
    private LoginPO loginPage;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGeneratorManager.getLoginPageObject(driver);
    }

    @Test
    public void TC_01_Visible(){
        // CÓ trên UI
        // Có trong DOM/HTML

        loginPage.clickToCreateNewAccountButton();
        loginPage.enterToEmailTextbox("abc@gmail.com");
        //Chờ cho reEmail textbox display
        loginPage.waitForReEnterEmailTextboxVisible();
        //Verify reEmail textbox display
        Assert.assertTrue(loginPage.isReEnterEmailTextboxDisplay());

    }

    @Test
    public void TC_02_InVisible_In_DOM(){
        //Không có trên UI
        //Có trong DOM/HTML

        loginPage.enterToEmailTextbox("");
        //Chờ cho reEmail textbox display
        loginPage.waitForReEnterEmailTextboxInVisibleInDOM();
        //Verify reEmail textbox display
        Assert.assertTrue(loginPage.isReEnterEmailTextboxUnDisplay());
    }

    @Test
    public void TC_03_InVisible_Not_In_DOM(){
        //Không có trên UI
        //Không có trong DOM/HTML

        loginPage.clickToCloseCreateAccountPopup();
        //Chờ cho reEmail textbox display
        loginPage.waitForReEnterEmailTextboxInVisibleNotInDOM();
        Assert.assertTrue(loginPage.isReEmailInvisible());
        //Chờ cho popup undisplay
        loginPage.waitForPopupInvisibleNotInDOM();
        //Verify reEmail textbox popup undisplay
        Assert.assertTrue(loginPage.isPopupInvisible());
    }

}
