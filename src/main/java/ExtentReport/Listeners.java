package ExtentReport;


import AmazonHelper.ExtentReportsHelper;
import BaseClass.TestBase;
//import Utility.TakeScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends TestBase implements ITestListener {
    ExtentReports extentReports= ExtentReportsHelper.extentReportGenerator();
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {
        test =extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //test.log(Status.PASS,"Successfull");
        test.log(Status.PASS,result.getMethod().getMethodName() + "is Passed");
    }

//    @Override
/*
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());

        String screenshotPath=null;
        //screenshotPath=captureScreenshot1(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg");
        test.addScreenCaptureFromPath(screenshotPath);
        test.fail(result.getThrowable());
*/

    //}

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}