package com.jquery.dataTable;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.JqueryDataTablePageObject.HomePagePO;
import pageObjects.JqueryDataTablePageObject.PageGeneratorManager;

public class Level_12_DataTable_PI extends BaseTest {
    WebDriver driver;
    HomePagePO homePagePO;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        homePagePO = PageGeneratorManager.getHomePageObject(driver);
    }

    //Trường hợp table có gía trị cố định để dựa vào

    @Test
    public void TC_01_Senkey_To_Column(){
        //1. nhập vào ô input trong bảng
        //Dựa vào header, tìm đến ô input ngang hàng với header (//div[text()='Country']/parent::div/following-sibling::input)
        homePagePO.enterToHeaderTextBoxByHeaderName("Country", "Angola");
        //verify dữ liệu hiển thị của 1 nước trên row
        Assert.assertTrue(homePagePO.isRowValuIsDispay("276880", "Angola", "276472", "553353"));
        homePagePO.sleepInSecond(3);

        homePagePO.enterToHeaderTextBoxByHeaderName("Country", "Albania");
        Assert.assertTrue(homePagePO.isRowValuIsDispay("24128", "Albania", "25266", "49397"));
        homePagePO.sleepInSecond(3);
        homePagePO.refreshCurrentPage(driver);
    }

    @Test
    public void TC_02_Click_To_Action(){
        homePagePO.clickToActionByHeaderName("Armenia", "remove");
        homePagePO.clickToActionByHeaderName("Albania", "remove");
        homePagePO.clickToActionByHeaderName("Angola", "edit");
        homePagePO.sleepInSecond(2);
        homePagePO.refreshCurrentPage(driver);
    }

    @Test
    public void TC_03_Open_Page_Number(){
        homePagePO.clickToPageNumber("3");
        Assert.assertTrue(homePagePO.isPageNumberActived("3"));

        homePagePO.clickToPageNumber("6");
        Assert.assertTrue(homePagePO.isPageNumberActived("6"));

    }
}
