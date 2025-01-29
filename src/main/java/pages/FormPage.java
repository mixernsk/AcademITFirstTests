package pages;
/*
Класс страницы с формой
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormPage extends BasePage {

    private String baseUrl = "https://demoqa.com/automation-practice-form";

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        this.open(baseUrl);
    }

    public void inputFirstName(String name) {
        this.fill(Locators.FIRST_NAME, name);
    }

    public void inputLastName(String name) {
        this.fill(Locators.LAST_NAME, name);
    }

    public void inputEmail(String email) {
        this.fill(Locators.EMAIL, email);
    }

    public void clickMaleGender() {
        this.click(Locators.GENDER_MALE);
    }

    public void inputMobile(String number) {
        this.fill(Locators.MOBILE, number);
    }

    public void inputBirthDate(String day, String month, String year) {
        this.click(Locators.BIRTHDATE);
        this.selectByValue(Locators.YEAR_SELECT, year);
        this.selectByValue(Locators.MONTH_SELECT, month);
        List<WebElement> dayElems = driver.findElements(Locators.DAY_DIV); // Получаем все элементы с числом месяца
        for (WebElement element : dayElems) { // Ищем переданное число в тексте каждого элемента
            String eleText = element.getText();
            if (eleText.equals(day)) {
                element.click();
                break;
            }
        }
    }

    public void inputSubjects(String text) {
        this.fill(Locators.SUBJECTS, text);
        this.keyTab();
    }

    public void checkSports() {
        this.click(Locators.HOBBIES_SPORTS);
    }

    public void checkReading() {
        this.click(Locators.HOBBIES_READING);
    }

    public void checkMusic() {
        this.click(Locators.HOBBIES_MUSIC);
    }

    public void selectPictureFile(String imgPath) {
        this.fill(Locators.PICTURE_FILE, imgPath);
    }

    public void inputAddress(String address) {
        this.fill(Locators.CURRENT_ADDRESS, address);
    }

    public void selectState(String name) {
        this.fill(Locators.STATE_MENU, name);
        this.keyEnter();
    }

    public void selectCity(String name) {
        this.fill(Locators.CITY_MENU, name);
        this.keyEnter();
    }

    public void submit() {
        this.clickWithJS(Locators.SUBMIT_BUTTON);
    }

    public boolean resultsTableDisplayed() {
        return this.isVisible(Locators.RESULT_TABLE);
    }

    public Map<String, String> getResults() { // Помещаем все результаты в "словарь"
        Map<String, String> results = new HashMap<>();

        results.put("fullName", this.getText(Locators.RESULT_NAME));
        results.put("email", this.getText(Locators.RESULT_EMAIL));
        results.put("gender", this.getText(Locators.RESULT_GENDER));
        results.put("mobile", this.getText(Locators.RESULT_MOBILE));
        results.put("birthDate", this.getText(Locators.RESULT_BIRTHDATE));
        results.put("subjects", this.getText(Locators.RESULT_SUBJECTS));
        results.put("hobbies", this.getText(Locators.RESULT_HOBBIES));
        results.put("picture", this.getText(Locators.RESULT_PICTURE));
        results.put("address", this.getText(Locators.RESULT_ADDRESS));
        results.put("stateCity", this.getText(Locators.RESULT_STATECITY));

        return results;
    }
}
