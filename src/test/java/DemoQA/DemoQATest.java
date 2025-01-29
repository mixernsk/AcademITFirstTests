package DemoQA;
/*
Проверка корректной обработки формы регистрации
 */
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import pages.FormPage;
import java.util.Map;

public class DemoQATest extends BaseTest {

    @Test
    public void testFormFill() {

        // Given

        String firstName = "Ilya";
        String lastName = "Khrushchev";
        String email = "test@test.com";
        String mobile = "1234567890";
        String bDay = "23";
        String bMonth = "8"; // Индекс месяца для выбора в форме (от 0 до 11), где 8 - Сентябрь
        String bYear = "1985";
        String checkDate = "23 September,1985"; // Дата в формате необходимом для проверки в результатах
        String subjects = "Maths";
        String picPath = "C:\\downloads\\testpic.jpg";
        String picName = "testpic.jpg"; // Имя файла изображения для проверки в результатах
        String address = "Los Angeles, Rodeo Dv., 25";
        String state = "Haryana";
        String city = "Panipat";

        FormPage formPage = new FormPage(driver);

        // When

        formPage.navigate();

        formPage.inputFirstName(firstName);

        formPage.inputLastName(lastName);

        formPage.inputEmail(email);

        formPage.clickMaleGender();

        formPage.inputMobile(mobile);

        formPage.inputBirthDate(bDay, bMonth, bYear);

        formPage.inputSubjects(subjects);

        formPage.checkMusic();
        formPage.checkReading();
        formPage.checkSports();

        formPage.selectPictureFile(picPath);

        formPage.inputAddress(address);

        formPage.selectState(state);

        formPage.selectCity(city);
        formPage.submit();

        // Then

        assertTrue(formPage.resultsTableDisplayed());
        Map<String, String> results = formPage.getResults();

        assertTrue(results.get("fullName").contains(firstName), "Name assertion error");
        assertTrue(results.get("fullName").contains(lastName), "Last name assertion error");
        assertTrue(results.get("email").contains(email), "Email assertion error");
        assertTrue(results.get("gender").contains("Male"), "Gender assertion error");
        assertTrue(results.get("mobile").contains(mobile), "Mobile assertion error");
        assertTrue(results.get("birthDate").contains(checkDate), "Date assertion error" + results.get("birthDate"));
        assertTrue(results.get("subjects").contains(subjects), "Subjects assertions error");
        assertTrue(results.get("hobbies").contains("Sports"), "Sports assertion error");
        assertTrue(results.get("hobbies").contains("Reading"), "Reading assertion error");
        assertTrue(results.get("hobbies").contains("Music"), "Music");
        assertTrue(results.get("picture").contains(picName), "Picname");
        assertTrue(results.get("address").contains(address), "Address");
        assertTrue(results.get("stateCity").contains(state), "State");
        assertTrue(results.get("stateCity").contains(city), "City");
    }
}
