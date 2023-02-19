package components;

import modals.IModals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AuthPage;

public class HederComponent extends AbsBaseComponent implements IModals {


    public HederComponent(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "button[class='header3__button-sign-in']")
    private WebElement buttonSiginIn;

    @FindBy(xpath = "//span[@class='header3__user-info-name']")
    private WebElement avatar;
    @FindBy(xpath = "//div[@class=\"header3__user-info-popup-links\"]//a[1]")
    private WebElement name;


    private String headerProfileModals = "[data-name='user-info'][class*=' js-header3-popup']";

    private By profile = By.cssSelector("[data-name='user-info'][class*=' js-header3-popup']");



   public void chekProfileModals(){
      baseWaiter.waitForVisibileLocator(profile);

   }

    @Override
    public void modalsSholdBeNotVisible() {
        baseWaiter.waitForCondition(ExpectedConditions.not(ExpectedConditions.attributeContains
                (driver.findElement(By.cssSelector(headerProfileModals)),"style","none")));

    }

    @Override
    public void modalsSholdBeVisibal() {
        baseWaiter.waitForCondition(ExpectedConditions.attributeContains
                (driver.findElement(By.cssSelector(headerProfileModals)),"style","none"));

    }








    public AuthPage clickButtonSiginIn(){
      buttonSiginIn.click();
      return new AuthPage(driver);
    }
    public HederComponent moveProfile(){
        baseWaiter.waitForVisibile(avatar);
        actionsMoveElement(avatar);
        return this;
    }
    public ProfilePageComponent clickProfile(){
        name.click();
        return new ProfilePageComponent(driver);
    }
}



