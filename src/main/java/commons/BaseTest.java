package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver = null;
    protected final Log log;

    public BaseTest() {
       log = LogFactory.getLog(getClass());
    }

    protected WebDriver getBrowserDriver(String browserName) {

        // Factory pattern
        //Enum
        BrowserName browser = BrowserName.valueOf(browserName.toUpperCase());
        switch (browser) {
            case FIREFOX:
               driver = WebDriverManager.firefoxdriver().create();
                break;
            case CHROME:
                driver = WebDriverManager.chromedriver().create();
                break;
            case EDGE:
                driver = WebDriverManager.edgedriver().create();
                break;
            case OPERA:
                driver = WebDriverManager.operadriver().create();
                break;
            default:
                throw new RuntimeException("Please enter the connect Browser name!");
        }
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.get(GlobalConstants.LIVE_USER_URL);
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String url) {

        // Factory pattern
        //Enum
        BrowserName browser = BrowserName.valueOf(browserName.toUpperCase());
        switch (browser) {
            case FIREFOX:
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case CHROME:
                driver = WebDriverManager.chromedriver().create();
                break;
            case EDGE:
                driver = WebDriverManager.edgedriver().create();
                break;
            case OPERA:
                driver = WebDriverManager.operadriver().create();
                break;
            default:
                throw new RuntimeException("Please enter the connect Browser name!");
        }
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }

    protected String randomEmail() {
        Random rand = new Random();
        int rd = rand.nextInt(999);
        return "PhuongTest" + rd + "@gmail.com";
    }

    protected Integer random() {
        Random rand = new Random();
        int rd = rand.nextInt(9999);
        return rd;
    }

    protected boolean verifyTrue(boolean condition){
        boolean status = true;
        try {
            Assert.assertTrue(condition);
            System.out.println("--------------------PASSED--------------------");
        } catch (Throwable e){
            status = false;
            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            System.out.println("--------------------FAILED--------------------");

        }
        return status;
    }

    protected boolean verifyFalse(boolean condition){
        boolean status = true;
        try {
            Assert.assertTrue(condition);
            System.out.println("--------------------PASSED--------------------");
        } catch (Throwable e){
            status = false;
            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            System.out.println("--------------------FAILED--------------------");
        }
        return status;
    }

    protected boolean verifyEqual(Object actual, Object expected){
        boolean status = true;
        try {
            Assert.assertEquals(actual, expected);
            System.out.println("--------------------PASSED--------------------");
        } catch (Throwable e){
            status = false;
            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            System.out.println("--------------------FAILED--------------------");
        }
        return status;
    }

    //Hàm getter
    public WebDriver getDriver(){
        return this.driver;
    }

    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("Window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
