package AmazonHelper;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsHelper extends TestBase {
    static ExtentReports extentReports;
    public static ExtentReports extentReportGenerator(){
        String path=System.getProperty("user.dir")+"\\ExtentReportGenerate\\index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Kwant Automation Result");
        reporter.config().setDocumentTitle("Test Result");

        extentReports=new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("QA","Bishal Shah");
        extentReports.setSystemInfo("OS",System.getProperty("os.name"));
        return  extentReports;
    }
}
