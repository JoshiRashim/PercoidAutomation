package AmazonPage;

import BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropdownTest extends TestBase {
    WebDriverWait wait;

    public DropdownTest(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
   /* @FindBy(xpath = "//div[@rel-title='Select Country']/p/select")
    WebElement country;
*/
    public void countrySelect(){
        Select countrydrop = new Select(driver.findElement(By.xpath("//div[@rel-title='Select Country']/p/select")));
        countrydrop.selectByIndex(3);
    }
        }
