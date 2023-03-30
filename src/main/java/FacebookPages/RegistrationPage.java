package FacebookPages;

import BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends TestBase {

    WebDriverWait wait;

    public RegistrationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(xpath = "//a[contains(text(),'Create new account')]")
    WebElement CreateAccount;

    @FindBy(xpath = "//button[@name='websubmit']")
    WebElement SignupButton;


    public void CreateAccout(){
        CreateAccount.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='websubmit']")));

        boolean status=SignupButton.isDisplayed();
        if (status){
            System.out.println("Sign up button is Displayed"+SignupButton.getText());
        }
        else {
            System.out.println("Signup Buttin is not Displayrd");
        }
    }



}
