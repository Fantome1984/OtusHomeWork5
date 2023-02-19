package components;

import helper.PageObgect;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbsBaseComponent extends PageObgect {
    public AbsBaseComponent(WebDriver driver){
        super(driver);
    }

}
