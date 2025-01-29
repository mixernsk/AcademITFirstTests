package pages;
/*
Локаторы для страницы с Книгами
 */
import org.openqa.selenium.By;

public class BooksPageLocators {
    public static final By BOOKS_LINK = By.xpath("(//a[contains(text(), 'Books')])[1]");
    public static final By PRODUCTS_SIZE = By.id("products-pagesize");
    public static final By PRODUCT_BOX = By.cssSelector(".item-box");
}
