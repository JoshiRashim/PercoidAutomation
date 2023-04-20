package AmazonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    public static void main(String[] args) {


                WebDriver _driver;

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
                _driver=new ChromeDriver(chromeOptions);
                _driver.manage().window().maximize();
                _driver.get("https://demoqa.com/select-menu");

                WebElement element=_driver.findElement(By.id("oldSelectMenu"));
                Select select=new Select(element);

        /*List<WebElement> list=select.getOptions();
        for (WebElement options:list){
            System.out.println(options.getText());
        }*/

                /*Select the drop down by index*/
        /*System.out.println("Select Dropdown of Index 4");
        select.selectByIndex(5);
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());*/

        /*System.out.println("Slect drop down of value");
        select.selectByValue("7");
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());*/

                System.out.println("Select Dropdown by visible texxt");
                select.selectByVisibleText("Aqua");
                System.out.println("Select value is: " + select.getFirstSelectedOption().getText());



            }
        }



