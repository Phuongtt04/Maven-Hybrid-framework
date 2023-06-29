package pageUIsJquery;

public class HomePageUI {
    public static final String HEADER_TEXTBOX_BY_HEADER_NAME = "XPATH=//div[text()='%s']/parent::div/following-sibling::input";
    public static final String ROW_VALUE_BY_HEADER_NAME = "XPATH=//td[@data-key='females' and text() = '%s']/following-sibling::td[@data-key='country' and text() = '%s']/following-sibling::td[@data-key='males' and text() = '%s']/following-sibling::td[@data-key='total' and text() = '%s']";
    public static final String ACTION_ICON = "XPath=//td[@data-key='country' and text() = '%s']/preceding-sibling::td/button[contains(@class, '%s')]";
    public static final String PAGE_NUMBER = "XPATH=//a[text() = '%s']";
    public static final String PAGE_ACTIVE_NUMBER = "XPATH=//a[contains(@class, 'active') and text() = '%s']";


    public static final String HEADER_INDEX_BY_NAME = "XPATH=//th[text()='%s']/preceding-sibling::th";
    public static final String CELL_TEXTBOX_BY_HEADER_INDEX_AND_ROW_INDEX = "XPATH=//tr[%s]/td[%s]/input";
    public static final String CELL_DROPDOWN_BY_HEADER_INDEX_AND_ROW_INDEX = "XPATH=//tr[%s]/td[%s]/div/select";
    public static final String LOAD_BUTTON = "XPATH=//button[@id='load']";
}
