package FacebookPages;

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

    @FindBy(xpath = "//nav[@class='x-nav']/ul[2]/li[1]/a")
    WebElement LoginTab;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement ContinueButton;



    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement Register;

    @FindBy(xpath = "//button[contains(text(),'Create your account')]")
    WebElement CreateYourAccount;



    public void NavigatetoCreateAccoutPage() {
        LoginTab.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create your account')]")));
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        String element = CreateYourAccount.getText();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void CreateAccout(){
        Register.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='websubmit']")));

        boolean status=Register.isDisplayed();
        if (status){
            System.out.println("Register button is Displayed"+Register.getText());
        }
        else {
            System.out.println("Regiter Buttin is not Displayed");
        }
    }



}
