package components;

import data.*;
import data.contries.ContryData;
import data.contries.cities.ICities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class ProfilePageComponent extends AbsBaseComponent {

    public ProfilePageComponent(WebDriver driver) {
        super(driver);
    }


    private String profileFieldPersonalInformationSelector = "#id_%s";
    private String ListSelectionPattern = "button[title='%s']";
    private String messengerLocator = "button[@data-value='%s']";
    private String gender ="option[value='%s']";
    private String fieldExpSelector ="//option[text()='%s']";
    private String communicationExpected="[name='contact-%s]";



    @FindBy(css = "[name='date_of_birth']")
    private WebElement dateOfBrith;
    @FindBy(xpath = "//div[@data-slave-selector='.js-lk-cv-dependent-slave-city']")
    private WebElement сountryInputField;
    @FindBy(css = "[class*='js-lk-cv-dependent-slave-city']")
    private WebElement cityInputField;
    @FindBy(xpath = "//input[@data-title='Уровень знания английского языка']/parent::label/parent::div")
    private WebElement languageInputField;
    @FindBy(xpath = "//input[@id='id_ready_to_relocate_1']/..")
    private WebElement radioButton;
    @FindBy(xpath = "//input[@title='Гибкий график']/parent::label/span")
    private WebElement chekBox;
    @FindBy(xpath = "//button[text()='Добавить']")
    private WebElement buttonAdd;
    @FindBy(id = "id_contact-0-value")
    private WebElement fieldContactsOne;
    @FindBy(xpath = "//span[text()='Способ связи']")
    private WebElement сommunicationMethodOne;
    @FindBy(css = "[data-num='1'] [data-selected-option-class]")
    private WebElement сommunicationMethodTwo;
    @FindBy(xpath = "//div[@class='select select_full']")
    private WebElement genderList;
    @FindBy(css = "[title='Добавить']")
    private WebElement addExperienceButton;
    @FindBy(xpath = "//div[@class='experience-row__col']/child::div[1]")
    private WebElement listLanguages;
    @FindBy(xpath = "//button[@title='Сохранить и продолжить']")
    private WebElement saveButton;


    @FindBy(xpath = "//input[@title='Гибкий график']/.")
    private WebElement chekBoxExp;
    @FindBy(xpath = "//input[@id='id_ready_to_relocate_1']")
    private WebElement radioButtonExp;





    public ProfilePageComponent fillingProfileUserPersonalInformation(ProfileFieldData profileFieldData, String data) {
        String selector = String.format(profileFieldPersonalInformationSelector, profileFieldData.getName());
        enterToTextArea(driver.findElement(By.cssSelector(selector)), data);
        return this;

    }

    public ProfilePageComponent fillingDateOfBrith(LocalDate brithDate) {
        enterToTextArea(dateOfBrith, brithDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        return this;
    }

    public ProfilePageComponent selectContry(ContryData contryData) {
        String selector = String.format(ListSelectionPattern, contryData.getContryName());
        baseWaiter.waitForVisibile(сountryInputField);
        сountryInputField.click();
        driver.findElement(By.cssSelector(selector)).click();
        return this;
    }

    public ProfilePageComponent selectCities(ICities cities) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String selector = String.format(ListSelectionPattern, cities.getName());
        baseWaiter.waitForVisibile(cityInputField);
        actions.moveToElement(cityInputField);
        cityInputField.click();
        js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(selector)));
        return this;

    }

    public ProfilePageComponent selectEnglishLevel(LanguageLevelData levelData) {
        String selector = String.format(ListSelectionPattern, levelData.getName());
        baseWaiter.waitForVisibile(languageInputField);
        languageInputField.click();
        driver.findElement(By.cssSelector(selector)).click();
        return this;

    }

    public ProfilePageComponent clickRadioButton() {
        baseWaiter.waitForVisibile(radioButton);
        radioButton.click();
        return this;
    }

    public ProfilePageComponent clickChekBox() {
       baseWaiter.waitForVisibile(chekBox);
        chekBox.click();
        return this;
    }

    public ProfilePageComponent clickButtonAdd() {
        baseWaiter.waitForVisibile(buttonAdd);
        buttonAdd.click();
        return this;

    }

    public ProfilePageComponent enteringContactDetails(CommunicationData communicationData) {
        String selector = String.format("//"+messengerLocator, communicationData.getName());
        baseWaiter.waitForVisibile(сommunicationMethodOne);
        сommunicationMethodOne.click();
        driver.findElement(By.xpath(selector)).click();
        return this;

    }

    public ProfilePageComponent enteringContactDetailsTwo(CommunicationData communicationData) {
        String selector = String.format("//input[@name='contact-1-service']/parent::label/following-sibling::div/descendant::"+messengerLocator,
                communicationData.getName());
        baseWaiter.waitForVisibile(сommunicationMethodTwo);
        сommunicationMethodTwo.click();
        baseWaiter.waitForVisibile(driver.findElement(By.xpath(selector)));
        actions.moveToElement(driver.findElement(By.xpath(selector)));
        driver.findElement(By.xpath(selector)).click();
        return this;

    }
    public ProfilePageComponent selectGender(GenderData genderData){
        String selector = String.format(gender,genderData.getName());
        genderList.click();
        driver.findElement(By.cssSelector(selector)).click();
        return this;
    }

    public ProfilePageComponent clickAddExperienceButton(){
        baseWaiter.waitForVisibile(addExperienceButton);
        addExperienceButton.click();
        return this;
    }

    public ProfilePageComponent addingDevelopmentExperience(DevelopmentlanguagesData dataLanguages,DevelopmentExperienceData experienceData){
        String selector = String.format(fieldExpSelector,dataLanguages.getName());
        String selectorTwo = String.format(fieldExpSelector,experienceData.getName());
        listLanguages.click();
        driver.findElement(By.xpath(selector)).click();
        driver.findElement(By.xpath(selectorTwo)).click();
        return this;
    }

    public ProfilePageComponent cliickSaveButton(){
        baseWaiter.waitForVisibile(saveButton);
        saveButton.click();
        return this;
    }




    public ProfilePageComponent chekProfileField(ProfileFieldData profileFieldData, String expected){
        String selector = String.format(String.format(profileFieldPersonalInformationSelector,profileFieldData.getName()));
        Assert.assertEquals(expected,driver.findElement(By.cssSelector(selector)).getAttribute("value"));
        return this;
    }

    public ProfilePageComponent chekDateOfBrith(LocalDate expDate){
        Assert.assertEquals(expDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),dateOfBrith.getAttribute("value"));
        return this;
    }

    public ProfilePageComponent chekContryAndCity(String contryExp,String cityExp){
        Assert.assertEquals(contryExp,сountryInputField.getText());
        Assert.assertEquals(cityExp,cityInputField.getText());
        return this;
    }

   public ProfilePageComponent chekLavelLanguage(String expLang){
        Assert.assertEquals(expLang,languageInputField.getText());
        return this;

    }

    public ProfilePageComponent radioButtonChek(String expButton) {
        Assert.assertEquals(expButton,radioButtonExp.getAttribute("value"));
        return this;
    }

    public ProfilePageComponent chekBoxChek(String expChekBox) {
       Assert.assertEquals(expChekBox,chekBoxExp.getAttribute("value"));
        return this;
    }

    public ProfilePageComponent genderChek(GenderData genderData,String genderExp){
        String selector = String.format(String.format(gender,genderData.getName()));
        Assert.assertEquals(genderExp,driver.findElement(By.cssSelector(selector)).getAttribute("value"));
        return this;
    }

    public ProfilePageComponent developmentExperienceChek(DevelopmentlanguagesData developmentlanguagesData,String langEpx){
        String selector = String.format(String.format(fieldExpSelector,developmentlanguagesData.getName()));
        Assert.assertEquals(langEpx,driver.findElement(By.xpath(selector)).getAttribute("value"));
        return this;
    }

    public ProfilePageComponent communicationChek(CommunicationData communicationData,String langEpx){
        String selector = String.format(String.format(communicationExpected,communicationData.getName()));
        Assert.assertEquals(langEpx,driver.findElement(By.cssSelector(selector)).getAttribute("value"));
        return this;
    }












}
