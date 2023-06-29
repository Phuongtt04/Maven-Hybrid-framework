package pageUIsJquery;

public class UploadFilesPageUI {
    public static final String UPLOAD_FILE = "XPATH=//input[@type = 'file']";
    public static final String BUTTON_START_UPLOAD_FILE = "XPATH=//tbody[@class = 'files']//button[contains(@class,'%s')]";
    public static final String IMAGE_FILE_NAME_LOADED = "XPATH=//p[@class = 'name' and text()= '%s']";
    public static final String IS_DISPLAY_UPLOAD_FILE = "XPATH=//p[@class = 'name']/a[@title = '%s']";

}
