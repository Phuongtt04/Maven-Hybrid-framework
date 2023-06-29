package com.wordpress.admin;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.wordpressPageObject.PageGenerateManage;
import pageObjects.wordpressPageObject.admin.AdminDashboardPO;
import pageObjects.wordpressPageObject.admin.AdminLoginPO;
import pageObjects.wordpressPageObject.admin.AdminMenuItemPO;
import pageObjects.wordpressPageObject.admin.AdminPostPO;
import pageObjects.wordpressPageObject.user.WpUserHomePO;
import pageObjects.wordpressPageObject.user.WpUserPostPO;
import pageObjects.wordpressPageObject.user.WpUserSearchPO;
import reportConfig.ExtentManager;

import java.lang.reflect.Method;

public class Admin_01_Post extends BaseTest {
    WebDriver driver;
    private String adminUrl, userUrl;
    private String browserName;

    private String adminUserName, adminPassword;
    private String menuItemName;
    private String titleValue, bodyValue;
    private String editTitleValue, editBodyValue;
    private String editCategoryValue, editTagValue;
    private String categoryValue, tagNameValue;
    private int random = random();

    AdminLoginPO adminLoginPage;
    AdminDashboardPO adminDashboardPage;
    AdminPostPO adminPostPage;
    AdminMenuItemPO adminMenuItemPage;
    WpUserHomePO wpUserHomePage;
    WpUserPostPO wpPostPage;
    WpUserSearchPO wpSearchPage;

    @Parameters({"browser", "adminUrl", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String adminUrl, String userUrl){
        this.adminUrl = adminUrl;
        this.userUrl = userUrl;
        this.browserName = browserName;
        adminUserName = "phuongautomation";
        adminPassword = "Phuongauto123@@";
        menuItemName = "Posts";

        titleValue = random+ " - Phuong automation test" ;
        bodyValue =  "Test input body data...";
        categoryValue = "Selenium";
        tagNameValue = random+"-auto";

        editTitleValue = random+ " - Phuong testing" ;
        editBodyValue =  "Test input body data edit";
        editCategoryValue = "automation";
        editTagValue = random+"-test";


        driver = getBrowserDriver(browserName, this.adminUrl);

        adminLoginPage = PageGenerateManage.getAdminLoginPageObject(driver);


        adminLoginPage.enterToUsernameTextbox(adminUserName);
        adminLoginPage.enterToPasswordTextBox(adminPassword);
        adminDashboardPage = adminLoginPage.clickToLoginButton();
    }
    @Test
    public void Post_01_Create_New_Post(Method method){
        ExtentManager.startTest(method.getName() + " - " + browserName, "TC_01_Create_New_Post");

        ExtentManager.getTest().log(Status.INFO, "Post_01 - Step 01 - Click Post menu item");
        adminPostPage = adminDashboardPage.clickToPostMenuItem(menuItemName);

        ExtentManager.getTest().log(Status.INFO, "Post_01 - Step 02 - Click Add New post button");
        adminPostPage.clickToAddNewButton();
        adminPostPage = PageGenerateManage.getAdminPostPageObject(driver);

        ExtentManager.getTest().log(Status.INFO, "Post_01 - Step 03 - Enter to title textbox");
        adminPostPage.enterToTitleTextbox(titleValue);

        ExtentManager.getTest().log(Status.INFO, "Post_01 - Step 04 - Enter to body textbox");
        adminPostPage.enterToBodyTextbox(bodyValue);

        ExtentManager.getTest().log(Status.INFO, "Post_01 - Step 05 - Click to 'Post' tab right menu");
        adminPostPage.clickToPostTab();

        ExtentManager.getTest().log(Status.INFO, "Post_01 - Step 06 - Click to 'Categories' label");
        adminPostPage.clickToCategoriesLabel();

        ExtentManager.getTest().log(Status.INFO, "Post_01 - Step 07 - Select 'Selenium' category checkbox");
        adminPostPage.checkToCategoryItemCheckbox(categoryValue);

        ExtentManager.getTest().log(Status.INFO, "Post_01 - Step 08 - Click to 'Tags' label");
        adminPostPage.clickToTagsLabel();

        ExtentManager.getTest().log(Status.INFO, "Post_01 - Step 09 - Enter new tag");
        adminPostPage.enterToNewTagTextbox(tagNameValue);

        ExtentManager.getTest().log(Status.INFO, "Post_01 - Step 10 - Click to 'Publish' button");
        adminPostPage.clickToPublishButton("Publish");
        adminPostPage.clickToPublishActiveButton();

        ExtentManager.getTest().log(Status.INFO, "Post_01 - Step 11 - Verify alert message 'Post published' display");
        verifyTrue(adminPostPage.isPublishMessageDisplay("Post published."));

        ExtentManager.getTest().log(Status.INFO, "Post_01 - Step 12 - Verify message " + titleValue + " is now live." + " display");
        verifyEqual(adminPostPage.getMessagePublished(), titleValue+ " is now live.");

    }

    @Test
    public void Post_02_Search_View_Post(Method method){
        ExtentManager.startTest(method.getName() + " - " + browserName, "TC_02_Search_View_Post");
        ExtentManager.getTest().log(Status.INFO, "Post_02 - Step 01 - Click to Post icon");
        adminPostPage.clicktoPostIcon();

        ExtentManager.getTest().log(Status.INFO, "Post_02 - Step 02 - Enter to search textbox");
        adminPostPage.enterToSearchTextbox(titleValue.substring(0,5));

        ExtentManager.getTest().log(Status.INFO, "Post_02 - Step 03 - Click to 'Search Posts' button");
        adminPostPage.clicktoSearchButton();

        ExtentManager.getTest().log(Status.INFO, "Post_02 - Step 04 - Verify data display on table");
        verifyTrue(adminPostPage.getTextInTableDisplay("1", "Title").contains(titleValue.substring(0,5)));
        verifyEqual(adminPostPage.getTextInTableDisplay("1", "Tags"),tagNameValue);
        verifyEqual(adminPostPage.getTextInTableDisplay("1", "Categories"), categoryValue);

        ExtentManager.getTest().log(Status.INFO, "Post_02 - Step 05 - Open user site");
        wpUserHomePage = adminPostPage.openWpUserHomePageObject(driver, userUrl);

        ExtentManager.getTest().log(Status.INFO, "Post_02 - Step 06 - Enter to search textbox");
        wpUserHomePage.enterToSearchTextbox(titleValue.substring(0,5));

        ExtentManager.getTest().log(Status.INFO, "Post_02 - Step 07 - Click to Search button");
        wpSearchPage = wpUserHomePage.clickToSearchButton();

        ExtentManager.getTest().log(Status.INFO, "Post_02 - Step 08 - Verify title post display");
        verifyTrue(wpSearchPage.getTitlePostText().contains(titleValue.substring(0,5)));

        ExtentManager.getTest().log(Status.INFO, "Post_02 - Step 09 - Click title post for view post detail");
        wpPostPage = wpSearchPage.clickToTitlePost();

        ExtentManager.getTest().log(Status.INFO, "Post_02 - Step 10 - Verify title display");
        verifyTrue(wpPostPage.getTitlePostName().contains(titleValue.substring(0,5)));

        ExtentManager.getTest().log(Status.INFO, "Post_02 - Step 10 - Verify body text display");
        verifyTrue(wpPostPage.getBodyText().contains(bodyValue.substring(0,5)));

        ExtentManager.getTest().log(Status.INFO, "Post_02 - Step 10 - Verify tags text display");
        verifyEqual(wpPostPage.getTagNameText(), tagNameValue);

        ExtentManager.getTest().log(Status.INFO, "Post_02 - Step 10 - Verify Categories text display");
        verifyEqual(wpPostPage.getCategoryNameText(), categoryValue);
    }

    @Test
    public void Post_03_Edit_Post(Method method){
        ExtentManager.startTest(method.getName() + " - " + browserName, "TC_03_Edit_Post");
        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 01 - Open admin site");
        adminDashboardPage = wpPostPage.openAdminDashboardPageObject(driver, adminUrl);

        ExtentManager.getTest().log(Status.INFO, "Post_01 - Step 02 - Click Post menu item");
        adminPostPage = adminDashboardPage.clickToPostMenuItem(menuItemName);

        ExtentManager.getTest().log(Status.INFO, "Post_02 - Step 03 - Enter to search textbox");
        adminPostPage.enterToSearchTextbox(titleValue.substring(0,5));

        ExtentManager.getTest().log(Status.INFO, "Post_02 - Step 04 - Click to 'Search Posts' button");
        adminPostPage.clicktoSearchButton();

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 05 - Click to 'Edit' link");
        adminPostPage.clickToActionButtonOnRowTable("1", "Title", "edit");

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 06 - Enter to title textbox");
        adminPostPage.enterToTitleTextbox(editTitleValue);

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 07 - Enter to body textbox");
        adminPostPage.enterToBodyTextbox(editBodyValue);

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 08 - Click to 'Post' tab right menu");
        adminPostPage.clickToPostTab();

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 09 - Click to 'Categories' label");
        adminPostPage.clickToCategoriesLabel();

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 10 - Select 'Automation' category checkbox");
        adminPostPage.unCheckToCategoryCheckbox(categoryValue);
        adminPostPage.sleepInSecond(1);
        adminPostPage.checkToCategoryItemCheckbox(editCategoryValue);

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 11 - Click to 'Tags' label");
        adminPostPage.clickToTagsLabel();

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 12 - Enter new tag");
        adminPostPage.revomeTagNameValue(tagNameValue);
        adminPostPage.enterToNewTagTextbox(editTagValue);

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 13 - Click to 'Update' button");
        adminPostPage.clickToPublishButton("Update");

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 14 - Verify alert message 'Post updated' display");
        verifyTrue(adminPostPage.isPublishMessageDisplay("Post updated."));

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 15 - Click to Post icon");
        adminPostPage.clicktoPostIcon();

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 16 - Enter to search textbox");
        adminPostPage.enterToSearchTextbox(editTitleValue.substring(0,5));

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 17 - Click to 'Search Posts' button");
        adminPostPage.clicktoSearchButton();

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 18 - Verify data display on table");
        Assert.assertTrue(adminPostPage.getTextInTableDisplay("1", "Title").contains(editTitleValue.substring(0,5)));
        Assert.assertEquals(adminPostPage.getTextInTableDisplay("1", "Tags"), editTagValue);
        Assert.assertEquals(adminPostPage.getTextInTableDisplay("1", "Categories"),editCategoryValue);

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 19 - Open user site");
        wpUserHomePage = adminPostPage.openWpUserHomePageObject(driver, userUrl);

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 20 - Enter to search textbox");
        wpUserHomePage.enterToSearchTextbox(editTitleValue.substring(0,5));

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 21 - Click to Search button");
        wpSearchPage = wpUserHomePage.clickToSearchButton();

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 22 - Verify title post display");
        Assert.assertTrue(wpSearchPage.getTitlePostText().contains(editTitleValue.substring(0,5)));

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 23 - Click title post for view post detail");
        wpSearchPage.clickToTitlePost();

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 24 - Verify title display");
        verifyTrue(wpPostPage.getTitlePostName().contains(editTitleValue.substring(0,5)));

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 25 - Verify body text display");
        verifyTrue(wpPostPage.getBodyText().contains(editBodyValue.substring(0,5)));

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 26 - Verify tags text display");
        verifyEqual(wpPostPage.getTagNameText(), editTagValue);

        ExtentManager.getTest().log(Status.INFO, "Post_03 - Step 27 - Verify Categories text display");
        verifyEqual(wpPostPage.getCategoryNameText(), editCategoryValue);
    }

    @Test
    public void Post_04_Delete_Post(Method method){
        ExtentManager.startTest(method.getName() + " - " + browserName, "TC_Delete_Post");
        ExtentManager.getTest().log(Status.INFO, "Post_04 - Step 01 - Open admin site");
        adminDashboardPage = wpPostPage.openAdminDashboardPageObject(driver, adminUrl);

        ExtentManager.getTest().log(Status.INFO, "Post_04 - Step 02 - Click Post menu item");
        adminPostPage = adminDashboardPage.clickToPostMenuItem(menuItemName);

        ExtentManager.getTest().log(Status.INFO, "Post_04 - Step 03 - Enter to search textbox");
        adminPostPage.enterToSearchTextbox(editTitleValue);

        ExtentManager.getTest().log(Status.INFO, "Post_04 - Step 04 - Click to 'Search Posts' button");
        adminPostPage.clicktoSearchButton();

        ExtentManager.getTest().log(Status.INFO, "Post_04 - Step 05 - Click to 'trash' icon");
        adminPostPage.clickToActionButtonOnRowTable("1", "Title", "trash");

        ExtentManager.getTest().log(Status.INFO, "Post_04 - Step 05 - Enter to search textbox");
        adminPostPage.enterToSearchTextbox(editTitleValue);

        ExtentManager.getTest().log(Status.INFO, "Post_04 - Step 04 - Click to 'Search Posts' button");
        adminPostPage.clicktoSearchButton();

        ExtentManager.getTest().log(Status.INFO, "Post_04 - Step 04 - verify 'No posts found.' message is display in Post table");
        verifyTrue(adminPostPage.isPostNotFoundMessageDisplay("No posts found."));
        adminPostPage.sleepInSecond(1);

        ExtentManager.getTest().log(Status.INFO, "Post_04 - Step 01 - Open user site");
        adminPostPage.openWpUserHomePageObject(driver, userUrl);

        ExtentManager.getTest().log(Status.INFO, "Post_04 - Step 01 -Verify deleted post is not displayed at Home page");

        ExtentManager.getTest().log(Status.INFO, "Post_04 - Step 01 -Enter post to search textbox at Home page");
        wpUserHomePage.enterToSearchTextbox(editTitleValue.substring(0,5));

        ExtentManager.getTest().log(Status.INFO, "Post_04 - Step 01 -Click to Search button");
        wpSearchPage = wpUserHomePage.clickToSearchButton();

        ExtentManager.getTest().log(Status.INFO, "Post_04 - Step 01 -Verify 'Sorry, no post found on this archive.' message is display");
        verifyTrue(wpSearchPage.isMessageNotFoundPostDisplay("Sorry, no post found on this archive."));
    }
}
