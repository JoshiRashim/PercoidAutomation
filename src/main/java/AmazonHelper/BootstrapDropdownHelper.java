package AmazonHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BootstrapDropdownHelper {
    WebDriver _driver;
    public void bootstap(WebElement element, String s){
        element.click();
        List<WebElement> DropDownText=_driver.findElements(By.xpath("//div[@class='menu transition visible']/div"));
        System.out.println(DropDownText.size());

       // String option="Male";

        for (int i=0;i<=DropDownText.size();i++)
        {
            if (DropDownText.get(i).getText().contains(s)){
                DropDownText.get(i).click();
                System.out.println("Clicked");
                break;
            }

        }
    }
}
