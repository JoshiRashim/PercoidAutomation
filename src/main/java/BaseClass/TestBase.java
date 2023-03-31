package BaseClass;

import AmazonHelper.WaitHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.Locale;

public class TestBase {

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement SearcBox;

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
        driver.get("https://www.amazon.com/");
        //new WaitHelper().waitForElementPresent(driver,SearcBox,10);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
}
