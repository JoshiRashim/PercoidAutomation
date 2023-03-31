package AmazonHelper;

import BaseClass.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action extends TestBase {

    public void HoverMouse(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
}
