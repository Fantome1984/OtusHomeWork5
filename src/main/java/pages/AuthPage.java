package pages;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage extends AbsBasePage{

    public AuthPage(WebDriver driver) {
        super(driver, "/");
    }


    @FindBy(css = "[class='new-log-reg__title-wrapper']")
   private WebElement authPageTextSelector;






    public void HeaderAuthorizationCheck(){
        baseWaiter.waitForVisibile(authPageTextSelector);
        Assert.assertEquals(authPageTextSelector.getText(),"ВОЙДИТЕ В СВОЙ АККАУНТ");
    }

}
