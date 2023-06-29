package PageUIsWordpress.adminPageUIs;

public class AdminPostPageUI {
    public static final String ADMIN_TITLE_TEXTBOX = "XPATH=//div/h1[contains(@class,'post-title')]";
    public static final String ADMIN_BODY_DEFAULT_TEXTBOX = "XPATH=//p[contains(@class,'block-editor-default')]";
    public static final String ADMIN_BODY_TEXTBOX = "XPATH=//p[contains(@class,'block-editor-rich-text')]";
    public static final String ADMIN_POST_BUTTON_SIDEBAR = "XPATH=//button[contains(@data-label,'Post')]";
    public static final String ADMIN_COMPONENTS_PANEL = "XPATH=//div[@class='components-panel__body']//button[text() = '%s']";
    public static final String ADMIN_INPUT_TAGS_TEXTBOX = "XPATH=//input[contains(@class,'components-form-token-field__input')]";
    public static final String ADMIN_CATEGORIES_CHECKBOX = "XPATH=//label[text()='%s']/preceding-sibling::span";
    public static final String ADMIN_PUBLISH_VIEW_BUTTON = "XPATH=//button[contains(@class,'components-button') and text()='%s']";
    public static final String ADMIN_PUBLISH_ACTIVE_BUTTON = "XPATH=//div[contains(@class,'publish-button')]/button[contains(text(),'%s')]";
    public static final String ADMIN_ALERT_NOTI_MESSAGE = "XPATH=//div[@class='components-snackbar__content' and text()='%s']";
    public static final String ADMIN_PUBLISH_NOTI_MESSAGE = "XPATH=//div[contains(@class,'postpublish-header is-opened')]";
    public static final String ADMIN_VIEW_POST_ICON = "XPATH=//a[contains(@class,'edit-post-fullscreen-mode-close')]";
    public static final String ADMIN_SEARCH_TEXTBOX = "css=input#post-search-input";
    public static final String ADMIN_SEARCH_BUTTON = "css=input#search-submit";
    public static final String ADMIN_CELL_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_NAME = "xpath=//tbody[@id='the-list']//tr[%s]//td[@data-colname='%s']//a";
    public static final String ADMIN_ROW_ACTIONS = "xpath=//div[@class='row-actions']/span[@class='%s']";
    public static final String ADMIN_REMOVE_TAGS = "xpath=//span[text()='%s']/parent::span/following-sibling::button";
    public static final String ADMIN_MESSAGE_SEARCH_NOT_FOUND = "xpath=//tbody[@id='the-list']//td[text()='%s']";

}
