package reportConfig;

import commons.BaseTest;
import commons.GlobalConstants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        // Lấy được driver ra
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();

        //Chụp hình và đưa vào report HTML
//        String screenshotPath = captureScreenshotAsFile(webDriver, iTestResult.getName()); //Dùng hàm lưu FILE //iTestResult.getName(): lấy tên của testcase
        String screenshotPath = captureScreenshotAsBase64(webDriver, iTestResult.getName()); // DÙng hàm Base64 //iTestResult.getName(): lấy tên của testcase

        // Trạng thái của Testcase: Pass/Fail/Skip
        Reporter.getCurrentTestResult();
//        Reporter.log("<br><a target=\"_blank\" href=\"file:///" + screenshotPath + "\">" + "<img src=\"file:///" + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>"); //Dùng hàm lưu FILE
        Reporter.log("<br><a target=\"_blank\" href=\"data:image/png;base64," + screenshotPath + "\">" + "<img src=\"data:image/png;base64," + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>"); // DÙng hàm Base64

        Reporter.setCurrentTestResult(null);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    //hàm chụp hình
    public String captureScreenshotAsFile(WebDriver driver, String screenshotName) {
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenPath = GlobalConstants.REPORTNG_SCREENSHORT_PATH + screenshotName + "_" + formater.format(calendar.getTime()) + ".png";
            FileUtils.copyFile(source, new File(screenPath));
            return screenPath;
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
            return e.getMessage();
        }
    }

    public String captureScreenshotAsBase64(WebDriver driver, String screenshotName) {
        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        return screenshotBase64;
    }
}
