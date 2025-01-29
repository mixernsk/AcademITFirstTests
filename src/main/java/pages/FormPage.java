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
        this.fill(FormPageLocators.FIRST_NAME, name);
    }

    public void inputLastName(String name) {
        this.fill(FormPageLocators.LAST_NAME, name);
    }

    public void inputEmail(String email) {
        this.fill(FormPageLocators.EMAIL, email);
    }

    public void clickMaleGender() {
        this.click(FormPageLocators.GENDER_MALE);
    }

    public void inputMobile(String number) {
        this.fill(FormPageLocators.MOBILE, number);
    }

    public void inputBirthDate(String day, String month, String year) {
        this.click(FormPageLocators.BIRTHDATE);
        this.selectByValue(FormPageLocators.YEAR_SELECT, year);
        this.selectByValue(FormPageLocators.MONTH_SELECT, month);
        List<WebElement> dayElems = driver.findElements(FormPageLocators.DAY_DIV); // Получаем все элементы с числом месяца
        for (WebElement element : dayElems) { // Ищем переданное число в тексте каждого элемента
            String eleText = element.getText();
            if (eleText.equals(day)) {
                element.click();
                break;
            }
        }
    }

    public void inputSubjects(String text) {
        this.fill(FormPageLocators.SUBJECTS, text);
        this.keyTab();
    }

    public void checkSports() {
        this.click(FormPageLocators.HOBBIES_SPORTS);
    }

    public void checkReading() {
        this.click(FormPageLocators.HOBBIES_READING);
    }

    public void checkMusic() {
        this.click(FormPageLocators.HOBBIES_MUSIC);
    }

    public void selectPictureFile(String imgPath) {
        this.fill(FormPageLocators.PICTURE_FILE, imgPath);
    }

    public void inputAddress(String address) {
        this.fill(FormPageLocators.CURRENT_ADDRESS, address);
    }

    public void selectState(String name) {
        this.fill(FormPageLocators.STATE_MENU, name);
        this.keyEnter();
    }

    public void selectCity(String name) {
        this.fill(FormPageLocators.CITY_MENU, name);
        this.keyEnter();
    }

    public void submit() {
        this.clickWithJS(FormPageLocators.SUBMIT_BUTTON);
    }

    public boolean resultsTableDisplayed() {
        return this.isVisible(FormPageLocators.RESULT_TABLE);
    }

    public Map<String, String> getResults() { // Помещаем все результаты в "словарь"
        Map<String, String> results = new HashMap<>();

        results.put("fullName", this.getText(FormPageLocators.RESULT_NAME));
        results.put("email", this.getText(FormPageLocators.RESULT_EMAIL));
        results.put("gender", this.getText(FormPageLocators.RESULT_GENDER));
        results.put("mobile", this.getText(FormPageLocators.RESULT_MOBILE));
        results.put("birthDate", this.getText(FormPageLocators.RESULT_BIRTHDATE));
        results.put("subjects", this.getText(FormPageLocators.RESULT_SUBJECTS));
        results.put("hobbies", this.getText(FormPageLocators.RESULT_HOBBIES));
        results.put("picture", this.getText(FormPageLocators.RESULT_PICTURE));
        results.put("address", this.getText(FormPageLocators.RESULT_ADDRESS));
        results.put("stateCity", this.getText(FormPageLocators.RESULT_STATECITY));

        return results;
    }
}
