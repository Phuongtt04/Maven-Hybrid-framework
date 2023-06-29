package pageObjects.sauceDemoSortData;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static InventoryPO getInventoryPage(WebDriver driver) {
        return new InventoryPO(driver);
    }
}
