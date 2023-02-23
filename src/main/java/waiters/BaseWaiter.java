package waiters;

import com.sun.nio.sctp.Association;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWaiter {
    private WebDriver driver;

    public BaseWaiter(WebDriver driver) {
        this.driver = driver;
    }
    public boolean waitForCondition(ExpectedCondition condition){
      WebDriverWait webDriverWait = new WebDriverWait(driver,10);
       try {
           webDriverWait.until(condition);
           return true;
       } catch (Exception ignored){
          return false;
       }
    }


    public void waitForVisibile(WebElement element){
   Assert.assertTrue(waitForCondition(ExpectedConditions.visibilityOf(element)));
    }

    public void waitForVisibileLocator(By locator){
        Assert.assertTrue(waitForCondition(ExpectedConditions.visibilityOfElementLocated(locator)));
    }
    public void waitForClikibal(WebElement element){
        Assert.assertTrue(waitForCondition(ExpectedConditions.elementToBeClickable(element)));
    }

}
