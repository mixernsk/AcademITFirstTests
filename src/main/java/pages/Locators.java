package pages;
/*
Класс локаторов для страницы FormPage
 */
import org.openqa.selenium.By;

public class Locators {
    public static final By FIRST_NAME = By.id("firstName");
    public static final By LAST_NAME = By.id("lastName");
    public static final By EMAIL = By.id("userEmail");
    public static final By GENDER_MALE = By.cssSelector("[type='radio'][value='Male']+label");
    public static final By MOBILE = By.id("userNumber");
    public static final By BIRTHDATE = By.id("dateOfBirthInput");
    public static final By YEAR_SELECT = By.cssSelector(".react-datepicker__year-select");
    public static final By MONTH_SELECT = By.cssSelector(".react-datepicker__month-select");
    public static final By DAY_DIV = By.cssSelector(".react-datepicker__day");
    public static final By SUBJECTS = By.id("subjectsInput");
    public static final By HOBBIES_SPORTS = By.cssSelector("label[for='hobbies-checkbox-1']");
    public static final By HOBBIES_READING = By.cssSelector("label[for='hobbies-checkbox-2']");
    public static final By HOBBIES_MUSIC = By.cssSelector("label[for='hobbies-checkbox-3']");
    public static final By PICTURE_FILE = By.id("uploadPicture");
    public static final By CURRENT_ADDRESS = By.id("currentAddress");
    public static final By STATE_MENU = By.id("react-select-3-input");
    public static final By CITY_MENU = By.id("react-select-4-input");
    public static final By SUBMIT_BUTTON = By.id("submit");
    public static final By RESULT_TABLE = By.cssSelector(".modal-body");
    public static final By RESULT_NAME = By.xpath("//td[contains(text(), 'Name')]/following-sibling::*");
    public static final By RESULT_EMAIL = By.xpath("//td[contains(text(), 'Email')]/following-sibling::*");
    public static final By RESULT_GENDER = By.xpath("//td[contains(text(), 'Gender')]/following-sibling::*");
    public static final By RESULT_MOBILE = By.xpath("//td[contains(text(), 'Mobile')]/following-sibling::*");
    public static final By RESULT_BIRTHDATE = By.xpath("//td[contains(text(), 'Date')]/following-sibling::*");
    public static final By RESULT_SUBJECTS = By.xpath("//td[contains(text(), 'Subjects')]/following-sibling::*");
    public static final By RESULT_HOBBIES = By.xpath("//td[contains(text(), 'Hobbies')]/following-sibling::*");
    public static final By RESULT_PICTURE = By.xpath("//td[contains(text(), 'Picture')]/following-sibling::*");
    public static final By RESULT_ADDRESS = By.xpath("//td[contains(text(), 'Address')]/following-sibling::*");
    public static final By RESULT_STATECITY = By.xpath("//td[contains(text(), 'State')]/following-sibling::*");
}