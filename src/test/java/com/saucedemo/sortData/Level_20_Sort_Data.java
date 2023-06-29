package com.saucedemo.sortData;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.sauceDemoSortData.InventoryPO;
import pageObjects.sauceDemoSortData.LoginPO;
import pageObjects.sauceDemoSortData.PageGeneratorManager;

public class Level_20_Sort_Data extends BaseTest {
    WebDriver driver;
    String browserName;
    LoginPO loginPage;
    InventoryPO inventoryPage;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl){
        driver = getBrowserDriver(browserName, userUrl);
        this.browserName = browserName.toUpperCase();

        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        inventoryPage = loginPage.clickToLoginButton();
    }

    @Test
    public void TC_01_Sort_Name(){
        inventoryPage.selectToSortDropDown("Name (Z to A)");
        inventoryPage.sleepInSecond(3);
        Assert.assertTrue(inventoryPage.isProductNameSortDescending());

        inventoryPage.selectToSortDropDown("Name (A to Z)");
        inventoryPage.sleepInSecond(3);
        Assert.assertTrue(inventoryPage.isProductNameSortAscending());
    }

    @Test
    public void TC_02_Sort_Number(){
        inventoryPage.selectToSortDropDown("Price (high to low)");
        inventoryPage.sleepInSecond(3);
        Assert.assertTrue(inventoryPage.isProductPriceSortDescending());

        inventoryPage.selectToSortDropDown("Price (low to high)");
        inventoryPage.sleepInSecond(3);
        Assert.assertTrue(inventoryPage.isProductPriceSortAscending());
    }
}
