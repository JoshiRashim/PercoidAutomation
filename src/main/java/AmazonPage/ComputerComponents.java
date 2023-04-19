package AmazonPage;

import AmazonHelper.Action;
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

public class ComputerComponents extends TestBase {
    WebDriverWait wait;
    public ComputerComponents(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(xpath = "//a[@id='nav-hamburger-menu']/span[contains(text(), 'All')]")
    WebElement AllDropdown;
    @FindBy(xpath = "//body/div[@id='hmenu-container']/div[@id='hmenu-canvas']/div[@id='hmenu-content']/ul[@class='hmenu hmenu-visible']/li[8]/a[1]")
    WebElement computer;
    @FindBy(xpath = "//a[normalize-space()='Computer Components']")
    WebElement components;

    public void navigateComponents(){
        new Action().HoverMouse(AllDropdown);
        AllDropdown.click();
        new Action().HoverMouse(computer);
        computer.click();
        new Action().HoverMouse(components);
        components.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@class,'s-product-image-container')]")));
    }
    public void countComponents(){
        List<WebElement> componentscount = driver.findElements(By.xpath("//div[starts-with(@class,'s-product-image-container')]"));
        for (int i = 0; i >= componentscount.size(); i++) {
            System.out.println(componentscount.get(i).getText());
        }
    }
}
        /*for(String text : componentscount){
            System.out.println(text.getText());*/
        //System.out.println(componentscount.size());



