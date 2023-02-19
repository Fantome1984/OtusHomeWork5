package helper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import waiters.BaseWaiter;

public class PageObgect {

    protected Actions actions;
    protected WebDriver driver;
    protected BaseWaiter baseWaiter;

    public PageObgect(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        baseWaiter = new BaseWaiter(driver);
        PageFactory.initElements(driver, this);
    }


    public void actionsMoveElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public  void enterToTextArea(WebElement element, String text){
        element.clear();
        element.sendKeys(text);

    }







}
