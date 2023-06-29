package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    public static LoginPO getLoginPageObject(WebDriver driver){
        return new LoginPO(driver);
    }
}
