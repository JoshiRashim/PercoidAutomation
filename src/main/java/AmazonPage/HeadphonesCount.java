package AmazonPage;

import AmazonHelper.Action;
import AmazonHelper.WaitHelper;
import BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HeadphonesCount extends TestBase {
    WebDriverWait wait;

    public HeadphonesCount(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//a[@id='nav-hamburger-menu']/span[contains(text(), 'All')]")
    WebElement AllDropdown;
    @FindBy(xpath = "//body/div[@id='hmenu-container']/div[@id='hmenu-canvas']/div[@id='hmenu-content']/ul[1]/li[7]/a[1]")
    WebElement Electronics;
    @FindBy(xpath = "//a[contains(text(),'Headphones')]")
    WebElement Headphones;
   /* @FindBy(xpath = "//span[@class='rush-component s-latency-cf-section']/div[1]/div")
    List<WebElement> products;*/


    public void clickHeadphones(){
        new Action().HoverMouse(AllDropdown);
        AllDropdown.click();
        new Action().HoverMouse(Electronics);
        Electronics.click();
        new Action().HoverMouse(Headphones);
        Headphones.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='rush-component s-latency-cf-section']/div[1]/div")));
        //new WaitHelper().waitForElementPresent(driver,products,5000);
    }
    public void countHeadphones(){
        List<WebElement> products = driver.findElements(By.xpath("//span[@class='rush-component s-latency-cf-section']/div[1]/div"));

        System.out.println(products.size());
    }
}
