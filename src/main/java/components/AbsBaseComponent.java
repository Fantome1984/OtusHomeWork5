package components;

import pages.PageObgect;
import org.openqa.selenium.WebDriver;


public abstract class AbsBaseComponent extends PageObgect {
    public AbsBaseComponent(WebDriver driver){
        super(driver);
    }

}
