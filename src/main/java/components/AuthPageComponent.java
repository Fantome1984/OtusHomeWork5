package components;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.IUtils;
import utils.PropertiesReder;

import java.util.Map;

public class AuthPageComponent extends AbsBaseComponent{
    public AuthPageComponent(WebDriver driver) {
        super(driver);
    }
    private String authForm ="//form[@action= '/login/']//input[@name='%s']";
    @FindBy(css = "[class*='new-input-line_relative']>button")
    WebElement buttonLogin;

    IUtils propRider = new PropertiesReder();
    Map<String,String> props = propRider.read();
    String login = props.get("login");
    String password = props.get("password");

    public AuthPageComponent Auth(){
        String EmailLocator=String.format(authForm,"email");
        driver.findElement(By.xpath(EmailLocator)).sendKeys(login);
        String PassLocator=String.format(authForm,"password");
        driver.findElement(By.xpath(PassLocator)).sendKeys(password);
        buttonLogin.click();
        return this;
    }






}
