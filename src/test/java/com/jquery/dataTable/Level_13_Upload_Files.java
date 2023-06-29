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
import pageUIsJquery.HomePageUI;

public class Level_13_Upload_Files extends BaseTest {
    WebDriver driver;
    HomePagePO homePagePO;
    String anh1Photo = "anh1.jpeg";
    String anh2Photo = "anh2.jpg";
    String anh3Photo = "anh3.jpg";


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName, "https://blueimp.github.io/jQuery-File-Upload/");
        homePagePO = PageGeneratorManager.getHomePageObject(driver);
    }


    @Test
    public void TC_01_Upload_One_File(){
        homePagePO.uploadMultipleFiles(driver, anh1Photo);
        homePagePO.isFileNameLoaded(anh1Photo);

        homePagePO.clickButtonStartUploadFile("start");

        Assert.assertTrue(homePagePO.isDisplayFileUpload(anh1Photo));

    }

    @Test
    public void TC_02_Upload_Multiple_File(){
        homePagePO.uploadMultipleFiles(driver, anh1Photo, anh2Photo, anh3Photo);
       Assert.assertTrue(homePagePO.isFileNameLoaded(anh1Photo));
       Assert.assertTrue(homePagePO.isFileNameLoaded(anh2Photo));
       Assert.assertTrue(homePagePO.isFileNameLoaded(anh3Photo));

        homePagePO.clickListButtonStartUploadFile("start");

        Assert.assertTrue(homePagePO.isDisplayFileUpload(anh1Photo));
        Assert.assertTrue(homePagePO.isDisplayFileUpload(anh2Photo));
        Assert.assertTrue(homePagePO.isDisplayFileUpload(anh3Photo));

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
