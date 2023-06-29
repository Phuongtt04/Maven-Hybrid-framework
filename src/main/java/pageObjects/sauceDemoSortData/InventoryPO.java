package pageObjects.sauceDemoSortData;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIsSauceDemoSortData.InventoryPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryPO extends BasePage {
    WebDriver driver;

    public InventoryPO(WebDriver driver) {
        this.driver = driver;
    }

    public void selectToSortDropDown(String sortValue) {
        waitForElementClickable(driver, InventoryPageUI.SORT_DROP_DOWN);
        selectItemInDefaultDropdown(driver, InventoryPageUI.SORT_DROP_DOWN, sortValue);
    }

    public boolean isProductNameSortAscending(){
        waitForListElementVisible(driver, InventoryPageUI.PRODUCT_NAME);
        List<WebElement> listProductName = getListWebElement(driver, InventoryPageUI.PRODUCT_NAME);

        List<String> listProductNameUI = new ArrayList<String>();

        for (WebElement nameItem: listProductName) {
            listProductNameUI.add(nameItem.getText());
        }
        System.out.println("-------Dữ liệu trên UI---------");
        for (String name: listProductNameUI){
            System.out.println(name);
        }

        // tạo list sort
        List<String> listProductNameSort = new ArrayList<String>(listProductNameUI);

        //Sort
        Collections.sort(listProductNameSort);

        System.out.println("--------Dữ liệu đã sort asc-----------");
        for (String name: listProductNameSort){
            System.out.println(name);
        }

        return listProductNameSort.equals(listProductNameUI);
    }

    public boolean isProductNameSortDescending(){
        waitForListElementVisible(driver, InventoryPageUI.PRODUCT_NAME);
        List<WebElement> listProductName = getListWebElement(driver, InventoryPageUI.PRODUCT_NAME);

        List<String> listProductNameUI = new ArrayList<String>();

        for (WebElement nameItem: listProductName) {
            listProductNameUI.add(nameItem.getText());
        }
        System.out.println("-------Dữ liệu trên UI---------");
        for (String name: listProductNameUI){
            System.out.println(name);
        }

        // tạo list sort
        List<String> listProductNameSort = new ArrayList<String>(listProductNameUI);

        //Sort
        Collections.sort(listProductNameSort);

        //Reverse
        Collections.reverse(listProductNameSort);

        System.out.println("--------Dữ liệu đã sort Desc-----------");
        for (String name: listProductNameSort){
            System.out.println(name);
        }

        return listProductNameSort.equals(listProductNameUI);
    }

    public boolean isProductPriceSortAscending(){
        waitForListElementVisible(driver, InventoryPageUI.PRODUCT_PRICE);
        List<WebElement> listProductPrice = getListWebElement(driver, InventoryPageUI.PRODUCT_PRICE);

        List<Float> listProductPriceUI = new ArrayList<Float>();

        for (WebElement priceItem: listProductPrice) {
            listProductPriceUI.add(Float.valueOf(priceItem.getText().replace("$", "")));
        }
        System.out.println("-------Dữ liệu trên UI---------");
        for (Float price: listProductPriceUI){
            System.out.println(price);
        }

        // tạo list sort
        List<Float> listProductPriceSort = new ArrayList<Float>(listProductPriceUI);

        //Sort
        Collections.sort(listProductPriceSort);

        System.out.println("--------Dữ liệu đã sort asc-----------");
        for (Float price:listProductPriceSort){
            System.out.println(price);
        }

        return listProductPriceSort.equals(listProductPriceUI);
    }

    public boolean isProductPriceSortDescending(){
        waitForListElementVisible(driver, InventoryPageUI.PRODUCT_PRICE);
        List<WebElement> listProductPrice = getListWebElement(driver, InventoryPageUI.PRODUCT_PRICE);

        List<Float> listProductPriceUI = new ArrayList<Float>();

        for (WebElement priceItem: listProductPrice) {
            listProductPriceUI.add(Float.valueOf(priceItem.getText().replace("$", "")));
        }
        System.out.println("-------Dữ liệu trên UI---------");
        for (Float price: listProductPriceUI){
            System.out.println(price);
        }

        // tạo list sort
        List<Float> listProductPriceSort = new ArrayList<Float>(listProductPriceUI);

        //Sort
        Collections.sort(listProductPriceSort);

        //Reverse
        Collections.reverse(listProductPriceSort);

        System.out.println("--------Dữ liệu đã sort desc-----------");
        for (Float price: listProductPriceSort){
            System.out.println(price);
        }

        return listProductPriceSort.equals(listProductPriceUI);
    }

    public boolean isDataSortAscWithJava8() {
        List<WebElement> listName= getListWebElement(driver, InventoryPageUI.PRODUCT_NAME);
        List<String> listNameUI = listName.stream().map(n->n.getText()).collect(Collectors.toList());
        List<String> listNameSort = new ArrayList<String>(listNameUI);
        Collections.sort(listNameSort);
        return listName.equals(listNameSort);
    }
}
