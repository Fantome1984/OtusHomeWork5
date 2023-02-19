package factories;

import data.BrowserData;
import exeptions.BrowserNotSupportedExeption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Locale;

public class WebDriverFactory implements IFactory{


    private String browserName = System.getProperty("browser.name","chrome");

    @Override
    public WebDriver createDriver() throws BrowserNotSupportedExeption {
      switch (BrowserData.valueOf(browserName.toUpperCase(Locale.ROOT))){
          case CHROME :
              ChromeOptions chromeOptions = new ChromeOptions();
              chromeOptions.addArguments("--start-fullscreen");
              return new ChromeDriver(chromeOptions);

          default:
              throw new BrowserNotSupportedExeption(browserName);
      }
    }
}
