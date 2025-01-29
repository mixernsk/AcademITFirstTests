package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
/*
Класс страницы с формой заказа
 */
public class OrderPage extends BasePage {

    private String baseUrl = "https://formdesigner.ru/examples/order.html";

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        this.open(baseUrl);
        this.clickWithJS(OrderPageLocators.COOKIES_BTN);
    }

    public void inputFirstName(String name) {
        this.fill(OrderPageLocators.FIRSTNAME, name);
    }

    public void inputLastName(String name) {
        this.fill(OrderPageLocators.LASTNAME, name);
    }

    public void inputFatherName(String name) {
        this.fill(OrderPageLocators.FATHERNAME, name);
    }

    public void inputEmail(String email) {
        this.fill(OrderPageLocators.EMAIL, email);
    }

    public void inputTel(String tel) {
        this.fill(OrderPageLocators.TELEPHONE, tel);
    }

    public void inputProductName(String productId) {
        this.selectByValue(OrderPageLocators.PRODUCT_NAME, productId);
    }

    public void inputProductQty(String productQty) {
        this.fill(OrderPageLocators.PRODUCT_QTY, productQty);
    }

    public void inputDeliveryDate(String date) {
        this.fill(OrderPageLocators.DELIVERY_DATE, date);
    }

    public void submit() {
        this.click(OrderPageLocators.SUBMIT_BUTTON);
    }

    public List<String> getErrors() {
        List<String> error_msgs = new ArrayList<>();
        if (this.isVisible(OrderPageLocators.ERROR_MESSAGES)) {
            List<WebElement> errors = driver.findElements(OrderPageLocators.ERROR_MESSAGES);

            for (WebElement error : errors) {
                error_msgs.add(error.getText());
            }
        }
        return error_msgs;
    }

    public void scrollToForm() {
        if (this.isVisible(OrderPageLocators.IFRAME)) {
            this.scrollIntoView(OrderPageLocators.IFRAME);
            this.driver.switchTo().frame(driver.findElement(OrderPageLocators.IFRAME));
        }
    }
}
