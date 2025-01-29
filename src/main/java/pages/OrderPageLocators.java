package pages;
/*
Класс локаторов для страницы с формой заказа
 */

import org.openqa.selenium.By;

public class OrderPageLocators {

    public static final By COOKIES_BTN = By.id("c-p-bn");
    public static final By IFRAME = By.cssSelector("#form_1006 > iframe");
    public static final By LASTNAME = By.cssSelector("input[placeholder='Фамилия']");
    public static final By FIRSTNAME = By.cssSelector("input[placeholder='Имя']");
    public static final By FATHERNAME = By.cssSelector("input[placeholder='Отчество']");
    public static final By EMAIL = By.id("field2");
    public static final By TELEPHONE = By.id("field3");
    public static final By PRODUCT_NAME = By.id("field4");
    public static final By PRODUCT_QTY = By.id("field5");
    public static final By DELIVERY_DATE = By.id("field6");
    public static final By SUBMIT_BUTTON = By.name("submit");
    public static final By ERROR_MESSAGES = By.cssSelector(".errorSummary li");

}
