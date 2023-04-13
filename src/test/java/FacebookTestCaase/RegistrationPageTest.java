package FacebookTestCaase;

import AmazonHelper.DropDownHelper;
import BaseClass.TestBase;
import AmazonPage.RegistrationPage;
import org.testng.Assert;
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
    @Test(priority = 1)
    public void AmazonTitleOfPage(){
        String Title=registrationPage.GetTitleofPage();
        System.out.println("Title of page:-"+Title);
        String Expected_Output="Amazon.com. Spend less. Smile more.";
        Assert.assertEquals(Title,Expected_Output,"String is not Matched");
    }
    @Test(priority = 2)
    public void GotoAccountTab(){
        registrationPage.NavigatetoAccount();
    }
    @Test(priority = 3)
    public void CreateAccountTest(){
        registrationPage.CreateAccount();
    }

    public void pickDropDownTest() throws InterruptedException {
        new DropDownHelper().PickDropDown("Male");
    }


}
