package AmazonHelper;

import BaseClass.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelper extends TestBase {
    public static String captureScreenshot1(String filename)
    {
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File sourcefile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile=new File("Screenshots/"+filename);

        try {
            FileUtils.copyFile(sourcefile,destFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Screenshot saves successfully");
        return destFile.getAbsolutePath();
    }
}
