package FacebookTestCaase;

import AmazonPage.Alerts;
import AmazonPage.DropdownTest;
import AmazonPage.IFrameTest;
import BaseClass.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class SelectCountryExec extends TestBase {
    DropdownTest dropdownTest;
    Alerts alerts;

    IFrameTest iFrameTest;
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
    public void switchTab(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='payment-nav ng-scope']/li[1]/a")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='payment-nav ng-scope']/li[2]/a")));
        driver.findElement(By.xpath("//h5[contains(text(),'Daraz ')]")).click();
        //driver.findElement(By.xpath("//div[@id='"+value+"'"));
        ArrayList<String> newTab=new ArrayList<>(driver.getWindowHandles());
        System.out.println(newTab);
        driver.switchTo().window(newTab.get(1));
        driver.switchTo().frame(1);
        System.out.println("Title of New Window:-"+driver.getTitle());
        driver.close();
        driver.switchTo().window(newTab.get(0));
        System.out.println("Title of Parent Window:-"+driver.getTitle());
    }

/*    public void handlewindow() throws InterruptedException {
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
                child_element.sendKeys(Keys.TAB);
                child_element2.sendKeys("Last Name");
                driver.close();
            }
        }
        WebElement parentWindowElement=driver.findElement(By.id("name"));
        js.executeScript("arguments[0].scrollIntoView();", parentWindowElement);
        parentWindowElement.sendKeys("test Element");
    }*/
/*    public void countrySelect(){
        dropdownTest.countrySelect();
    }*/

}
