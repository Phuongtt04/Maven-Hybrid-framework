package pageObjects.JqueryDataTablePageObject;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static HomePagePO getHomePageObject(WebDriver driver){
        return new HomePagePO(driver);
    }

}
