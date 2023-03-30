package FacebookTestCaase;

import BaseClass.TestBase;
import FacebookPages.RegistrationPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationPageTest extends TestBase {
    RegistrationPage registrationPage;


    @BeforeClass
    public void Setup()
    {
        String browser="Chrome";
        LaunchBrowser(browser);
        registrationPage=new RegistrationPage(driver);
    }
    @Test
    public void NavigatetoLoginTest(){
        registrationPage.NavigatetoCreateAccoutPage();
    }

   // @Test
    public void SignupPageTest()
    {
        registrationPage.CreateAccout();
    }
    //@AfterClass
    public void Aftercalss()
    {
        driver.quit();
    }
}
