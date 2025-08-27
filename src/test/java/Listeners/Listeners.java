package Listeners;

import Resources.ExtentReporterNG;
import TestComponents.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {

    ExtentReports extent = ExtentReporterNG.getReporterObject();

    ExtentTest test;

    //to avoid parallel test wrong reporting fails with threadlocal class

    ThreadLocal<ExtentTest> extentTest = new ThreadLocal(); //Thread safe

    // object not created because static keyword used in ExtentReporterNG class
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test); //unique thread id
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Message from listener as Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        //System.out.println("Failed Test "+result.getName());

        // for error message to appear in extent report
        //test.fail(result.getThrowable());
        extentTest.get().fail(result.getThrowable()); //thread safe

        // adding screenshot on failure
        // giving life to driver from result
        try {
            driver = (WebDriver) result.getTestClass().getRealClass()
                    .getField("driver").get(result.getInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String filePath = null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }
}

