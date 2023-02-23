package otus;

import components.AuthPageComponent;
import components.HederComponent;
import data.*;
import data.contries.ContryData;
import data.contries.cities.RussiaCitiesData;
import exeptions.BrowserNotSupportedExeption;
import factories.WebDriverFactory;
import helper.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.AuthPage;
import pages.MainPage;

import java.time.LocalDate;

public class Test_Ui {
    public org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);
    private WebDriver driver;
    @BeforeClass
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void setUp() throws BrowserNotSupportedExeption {
        driver = new WebDriverFactory().createDriver();
    }
    @After

    public void setDown(){
        if (driver !=null){
            driver.quit();
        }
    }
    @Test
    public void profileFilling() throws InterruptedException {
        String fname = "Никита";
        String lname ="Шлеткин";
        String fname_latin ="Nikita";
        String lname_latin ="Shletkin";
        String blog_name ="NiksFantome";
        String company ="RT-DC";
        String work ="Ведущий специалист";
        String contry="Россия";
        String city ="Воронеж";
        String englishLevel ="Начальный уровень (Beginner)";
        String gender ="m";
        String developmentLang ="3";
        String radioButtonExp ="True";
        String chekBoxExp="flexible";
        LocalDate dateOfBirth = LocalDate.of(1997,11,25);
        String communikationContactOne ="facebook";
        String communikationContactTwo ="vk";

        logger.info("Перешли на страницу Отуса");
        new MainPage(driver)
                .openPage();
        new HederComponent(driver).clickButtonSiginIn();
        new AuthPage(driver).HeaderAuthorizationCheck();
        new AuthPageComponent(driver).Auth();
        logger.info("Авторизовались");
        HederComponent hederComponent = new HederComponent(driver);
        hederComponent.chekProfileModals();
        hederComponent.modalsSholdBeVisibal();
        hederComponent.moveProfile().modalsSholdBeNotVisible();
        logger.info("Перешли в профиль и заполнили иноформацию о себе");
        hederComponent.clickProfile().fillingProfileUserPersonalInformation(ProfileFieldData.FIRSTNAME,fname)
                .fillingProfileUserPersonalInformation(ProfileFieldData.FIRSTNAMELATIN,fname_latin)
                .fillingProfileUserPersonalInformation(ProfileFieldData.LASTNAME,lname)
                .fillingProfileUserPersonalInformation(ProfileFieldData.LASTNAMELATIN,lname_latin)
                .fillingProfileUserPersonalInformation(ProfileFieldData.BLOGNAME,blog_name)
                .fillingDateOfBrith(dateOfBirth)
                .selectContry(ContryData.RUSSIA)
                .selectCities(RussiaCitiesData.VORONEZH)
                .selectEnglishLevel(LanguageLevelData.BEGINNER)
                .clickRadioButton()
                .clickChekBox()
                .clickButtonAdd()
                .enteringContactDetails(CommunicationData.VK)
                .enteringContactDetailsTwo(CommunicationData.FACEBOOK)
                .fillingProfileUserPersonalInformation(ProfileFieldData.CONTACTONE,"89056789065")
                .fillingProfileUserPersonalInformation(ProfileFieldData.CONTACTTWO,"Fantome1984")
                .selectGender(GenderData.MALE)
                .fillingProfileUserPersonalInformation(ProfileFieldData.COMPANY,company)
                .fillingProfileUserPersonalInformation(ProfileFieldData.WORK,work)
                .clickAddExperienceButton()
                .addingDevelopmentExperience(DevelopmentlanguagesData.JAVA,DevelopmentExperienceData.JUSTSTARTED)
                .cliickSaveButton();
        logger.info("Открыли в чистом браузере");
        driver.manage().deleteAllCookies();
        new MainPage(driver)
                .openPage();
        new HederComponent(driver).clickButtonSiginIn();
        new AuthPage(driver).HeaderAuthorizationCheck();
        new AuthPageComponent(driver).Auth();
        hederComponent.chekProfileModals();
        hederComponent.modalsSholdBeVisibal();
        hederComponent.moveProfile().modalsSholdBeNotVisible();
        logger.info("Перешли в профиль и проверили введенные данные");
        hederComponent.clickProfile()
                .chekProfileField(ProfileFieldData.FIRSTNAME,fname)
                .chekProfileField(ProfileFieldData.FIRSTNAMELATIN,fname_latin)
                .chekProfileField(ProfileFieldData.LASTNAME,lname)
                .chekProfileField(ProfileFieldData.LASTNAMELATIN,lname_latin)
                .chekProfileField(ProfileFieldData.BLOGNAME,blog_name)
                .chekProfileField(ProfileFieldData.COMPANY,company)
                .chekProfileField(ProfileFieldData.WORK,work)
                .chekDateOfBrith(dateOfBirth)
                .chekContryAndCity(contry,city)
                .chekLavelLanguage(englishLevel)
                .radioButtonChek(radioButtonExp)
                .chekBoxChek(chekBoxExp)
                .communicationChek(CommunicationData.FACEBOOKEXP,communikationContactOne)
                .communicationChek(CommunicationData.VKEXP,communikationContactTwo)
                .genderChek(GenderData.MALE,gender)
                .developmentExperienceChek(DevelopmentlanguagesData.JAVA,developmentLang);
    }

}
