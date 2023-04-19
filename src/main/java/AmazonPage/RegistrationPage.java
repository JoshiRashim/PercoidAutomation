package AmazonPage;

import AmazonHelper.Action;
import AmazonHelper.WaitHelper;
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

    @FindBy(xpath = "//span[contains(text(),'Account & Lists')]")
    WebElement HovertheMouse;

    @FindBy(xpath = "//a[contains(text(),'Create your Amazon account')]")
    WebElement CreateAccoutButton;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement ContinueButton;

    /*
        Amzon Create Account Input text
     */

    @FindBy(xpath = "//input[@id='ap_customer_name']")
    WebElement Fname;

    public String GetTitleofPage(){
        return driver.getTitle();
    }

    public void NavigatetoAccount(){
        new Action().HoverMouse(HovertheMouse);
        HovertheMouse.click();
        new WaitHelper().waitForElementPresent(driver,CreateAccoutButton,10);
    }

    public void CreateAccount(){
        CreateAccoutButton.click();

        new WaitHelper().waitForElementPresent(driver,ContinueButton,10);
        Fname.sendKeys("Mathew");
    }






}
