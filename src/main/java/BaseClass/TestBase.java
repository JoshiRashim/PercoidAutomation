package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Locale;

public class TestBase {

    public static WebDriver driver;

    public void LaunchBrowser(String browser){

        switch (browser.toLowerCase(Locale.ROOT))
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "safari":
                driver=new SafariDriver();
                break;

            default:
                driver=null;
                break;
        }
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/login/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
}
