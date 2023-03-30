package FacebookTestCaase;

import BaseClass.TestBase;
import FacebookPages.RegistrationPage;

public class RegistrationPageTest extends TestBase {
    RegistrationPage registrationPage;

    public void Setup()
    {
        String browser="Chrome";
        LaunchBrowser(browser);
        registrationPage=new RegistrationPage(driver);
    }

    public void SignupPageTest()
    {
        registrationPage.CreateAccout();
    }
}
