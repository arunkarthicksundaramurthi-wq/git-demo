package ArunKarthickLearnings;

import Listeners.Retry;
import PageObjects.WelcomePage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebsiteTest extends BaseTest {

    /*@BeforeTest Added it to Listeners class
    //ExtentReports extent;
    public void config(){
        String directory = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(directory);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Arun Karthick");
    }
    */

    @Test(retryAnalyzer = Retry.class)
    public void checkMovies(){
        // an object is created from extent.createTest, And this object will be responsible
        // for all listening and report all happenings back to extent report
        //ExtentTest test = extent.createTest("Check Movies");

        WelcomePage wp = new WelcomePage(driver);
        wp.goToWebsite();
        Assert.assertTrue(false);

        //test.fail("Results do not match");

        //extent.flush(); adding it in listener class

    }
}
