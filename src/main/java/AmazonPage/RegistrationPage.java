package AmazonPage;

import BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends TestBase {

    WebDriverWait wait;
    JavascriptExecutor js;

    public RegistrationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
    }

    public String GetTitleofPage(){
        return driver.getTitle();
    }




}
