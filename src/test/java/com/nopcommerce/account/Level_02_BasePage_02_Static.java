package com.nopcommerce.account;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_02_BasePage_02_Static {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    private BasePage basePage=  BasePage.getBasePage();

    @BeforeClass
    public void beforeClass() {
        System.out.println("projectPath= " + projectPath);
        System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }

    @Test
    public void Register_01_EmptyData() {
        basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");

        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//button[@id='register-button']");


        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='FirstName-error']" ), "First name is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='LastName-error']" ), "Last name is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']" ), "Email is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Password-error']" ), "Password is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']" ), "Password is required.");
    }
    @Test
    public void Register_02_InvalidEmail() {
        basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");

        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.senKeyToElement(driver, "//input[@id='FirstName']", "Phượng");
        basePage.senKeyToElement(driver, "//input[@id='LastName']", "Test");
        basePage.senKeyToElement(driver, "//input[@id='Email']", "PhuongTest123@");
        basePage.senKeyToElement(driver, "//input[@id='Company']", "Công ty Test");
        basePage.senKeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.senKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

//        basePage.scrollToElementOnTop(driver, "//input[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']"), "Wrong email");
    }
    @Test
    public void Register_03_InvalidPassword() {
        basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.senKeyToElement(driver, "//input[@id='FirstName']", "Phượng");
        basePage.senKeyToElement(driver, "//input[@id='LastName']", "Test");
        basePage.senKeyToElement(driver, "//input[@id='Email']", "PhuongTest123@gmail.com");
        basePage.senKeyToElement(driver, "//input[@id='Company']", "Công ty Test");
        basePage.senKeyToElement(driver, "//input[@id='Password']", "1");
        basePage.senKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");

    }
    @Test
    public void Register_04_Incorrect_Confirm_Password() {
        basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.senKeyToElement(driver, "//input[@id='FirstName']", "Phượng");
        basePage.senKeyToElement(driver, "//input[@id='LastName']", "Test");
        basePage.senKeyToElement(driver, "//input[@id='Email']", "PhuongTest123@gmail.com");
        basePage.senKeyToElement(driver, "//input[@id='Company']", "Công ty Test");
        basePage.senKeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.senKeyToElement(driver, "//input[@id='ConfirmPassword']", "abc");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");

    }
    @Test
    public void Register_05_Success() {
        basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.senKeyToElement(driver, "//input[@id='FirstName']", "Phượng");
        basePage.senKeyToElement(driver, "//input[@id='LastName']", "Test");
        basePage.senKeyToElement(driver, "//input[@id='Email']", randomEmail());
        basePage.senKeyToElement(driver, "//input[@id='Company']", "Công ty Test");
        basePage.senKeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.senKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='result']"), "Your registration completed");
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    
    public String randomEmail() {
        Random rand = new Random();
        int rd = rand.nextInt(999);
        return "PhuongTest" + rd + "@gmail.com";
    }

}
