package AmazonPage;

import BaseClass.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts extends TestBase {
    WebDriverWait wait;
    public Alerts(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    WebElement alert;
    public void alertclick() throws InterruptedException {
        Thread.sleep(5000);
        alert.click();
    }
    public void readalert(){
        Alert alert1=driver.switchTo().alert();
        String a = alert1.getText();
        System.out.println(a);
      //  driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
    }
}
