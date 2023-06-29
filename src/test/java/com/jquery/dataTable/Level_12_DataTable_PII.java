package com.jquery.dataTable;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.JqueryDataTablePageObject.HomePagePO;
import pageObjects.JqueryDataTablePageObject.PageGeneratorManager;

public class Level_12_DataTable_PII extends BaseTest {
    WebDriver driver;
    HomePagePO homePagePO;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        homePagePO = PageGeneratorManager.getHomePageObject(driver);
    }

    //Trường hợp table KHÔNG có gía trị cố định để dựa vào

    @Test
    public void TC_01_Senkey_To_Column(){
        //https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/

        homePagePO.enterToTextBoxByHeaderNameAndRowNumber("Contact Person", "1", "PhuongTest1");
        homePagePO.sleepInSecond(2);

        homePagePO.enterToTextBoxByHeaderNameAndRowNumber("Company", "3", "PhuongTest2");
        homePagePO.sleepInSecond(2);

        homePagePO.selectToDropDownByHeaderNameAndRowNumber("Country", "1", "Hong Kong");

        homePagePO.sleepInSecond(2);
        homePagePO.clickToLoadButton();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
