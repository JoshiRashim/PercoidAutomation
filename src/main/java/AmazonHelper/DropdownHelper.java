package AmazonHelper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownHelper {
    public void selectDropdowb(WebElement element, int i){
        Select select=new Select(element);
        select.selectByIndex(i);

    }
}
