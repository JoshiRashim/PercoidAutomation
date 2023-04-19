package FacebookTestCaase;

import AmazonPage.Alerts;
import AmazonPage.DropdownTest;
import BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class SelectCountryExec extends TestBase {
    DropdownTest dropdownTest;
    Alerts alerts;
    @BeforeClass
    public void Setup(){
        String browser="Chrome";
        LaunchBrowser(browser);
        dropdownTest=new DropdownTest(driver);
        alerts=new Alerts(driver);
    }
    //@Test(priority = 1)
    public void alertTest() throws InterruptedException {
        alerts.alertclick();
        alerts.readalert();
    }
    @Test
    public void handlewindow() throws InterruptedException {
        String parent_window=driver.getWindowHandle();
        System.out.println("Parent window:-"+parent_window);

        WebElement ele=driver.findElement(By.id("newWindowBtn"));

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);
        ele.click();

        Set<String>handles=driver.getWindowHandles();
        for (String handle:handles) {
            System.out.println("Child Window:-"+handle);
            if (!handle.equals(parent_window)){
                driver.switchTo().window(handle);
                WebElement child_element= driver.findElement(By.id("firstName"));
                WebElement child_element2=driver.findElement(By.id("lastName"));
                js.executeScript("arguments[0].scrollIntoView();", child_element);
                child_element.sendKeys("Firstname");
                child_element.sendKeys(Keys.TA);
                child_element2.sendKeys("Last Name");
                driver.close();
            }
        }
        WebElement parentWindowElement=driver.findElement(By.id("name"));
        js.executeScript("arguments[0].scrollIntoView();", parentWindowElement);
        parentWindowElement.sendKeys("test Element");
    }
/*    public void countrySelect(){
        dropdownTest.countrySelect();
    }*/

}
