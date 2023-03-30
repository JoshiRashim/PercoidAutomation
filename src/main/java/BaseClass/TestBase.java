package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");

                DesiredCapabilities cp=new DesiredCapabilities();
                cp.setCapability(ChromeOptions.CAPABILITY,options);
                options.merge(cp);

                driver=new ChromeDriver(options);
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
        driver.get("https://wordpress.com/hosting/?aff=58022&cid=8348279&cmp_id=9808156547&adg_id=98727271423&kwd=wordpress&device=c");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
}
