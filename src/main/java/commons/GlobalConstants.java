package commons;

import java.io.File;

public class GlobalConstants {
    // System Infor
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String FILE_SEPARATOR = File.separator;

    //app infor user
    public static final String DEV_USER_URL = "https://dev.nopcommerce.com/";
    public static final String STAGING_USER_URL = "https://staging.nopcommerce.com/";
    public static final String LIVE_USER_URL = "https://demo.nopcommerce.com/";

    //app infor ADMIN
    public static final String DEV_ADMIN_URL = "https://admin-dev.nopcommerce.com/";
    public static final String STAGING_ADMIN_URL = "https://admin-staging.nopcommerce.com/";
    public static final String LIVE_ADMIN_URL = "https://admin-demo.nopcommerce.com/";
    public static final String ADMIN_USERNAME = "admin@yourstore.com";
    public static final String ADMIN_PASSWORD = "admin";

    //WAIT INFOR
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 10;

    //download/ Upload file
    public static final String UPLOAD_PATH= getFolderSeparator("uploadFiles");
    public static final String DOWNLOAD_PATH = getFolderSeparator("downloadFiles");

    // retry case failed
    public static final int RETRY_NUMBER = 3;

    // Browser Logs/ Extension
    public static final String BROWSER_LOG_PATH = getFolderSeparator("browserLogs");
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + "";

    // HTML report folder
    public static final String REPORTNG_SCREENSHORT_PATH = getFolderSeparator("screenShortReportNG");
    public static final String EXTENT_PATH = getFolderSeparator("htmlExtentReport");
    public static final String ALLURE_PATH = PROJECT_PATH + "";

    //Data test
    public static final String DATA_PATH = PROJECT_PATH + "/src/test/resources/dataTest/";

    private static String getFolderSeparator( String folderName){
        return PROJECT_PATH + FILE_SEPARATOR + folderName + FILE_SEPARATOR;
    }

}
