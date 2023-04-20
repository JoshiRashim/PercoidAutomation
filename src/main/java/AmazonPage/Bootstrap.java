package AmazonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Bootstrap {
    @FindBy(xpath = "//div[@class='menu transition visible']/div")
    List <WebElement> element;
    public void getSize(){
        element.size();
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver _driver;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        _driver=new ChromeDriver(chromeOptions);
        _driver.manage().window().maximize();
        _driver.get("https://semantic-ui.com/modules/dropdown.html");

        JavascriptExecutor js=(JavascriptExecutor) _driver;
        WebElement Element=_driver.findElement(By.xpath("//p[contains(text(),'A dropdown can be used to select between choices in a form')]"));
        js.executeScript("arguments[0].scrollIntoView();", Element);

        _driver.findElement(By.xpath("//div[@class='ui active tab']/div[4]/div")).click();
        Thread.sleep(2000);
        List<WebElement> DropDownText=_driver.findElements(By.xpath("//div[@class='menu transition visible']/div"));
        System.out.println(DropDownText.size());

        String option="Male";

        for (int i=0;i<=DropDownText.size();i++)
        {
            if (DropDownText.get(i).getText().contains(option)){
                DropDownText.get(i).click();
                System.out.println("Clicked");
                break;
            }

        }

    }
}
