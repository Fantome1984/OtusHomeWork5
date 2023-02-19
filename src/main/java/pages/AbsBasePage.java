package pages;

import helper.PageObgect;
import org.openqa.selenium.WebDriver;

public abstract class AbsBasePage  extends PageObgect {

   private String BASE_URL = System.getProperty("base.url","https://otus.ru");
   private String path;

   public AbsBasePage(WebDriver driver, String path){
       super(driver);
       this.path = path;
   }


    public void openPage(){

       driver.get(BASE_URL.replaceAll("\\/$","")+path);

    }
}
