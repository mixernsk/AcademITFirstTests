package pages;
/*
Локаторы для страницы с Книгами
 */
import org.openqa.selenium.By;

public class BooksPageLocators {
    public static final By BOOKS_LINK = By.xpath("(//a[contains(text(), 'Books')])[1]");
    public static final By PRODUCTS_SIZE = By.id("products-pagesize");
    public static final By PRODUCT_BOX = By.cssSelector(".item-box");
    public static final By SEARCH_FIELD = By.id("small-searchterms");
    public static final By CART_ADD_BUTTON = By.cssSelector("[value='Add to cart']");
    public static final By PRODUCT_TITLE = By.cssSelector("h2.product-title");
    public static final By PRODUCT_ITEMS = By.cssSelector(".product-item");
    public static final By CART_LINK = By.cssSelector(".cart-label");
    public static final By CART_PRODUCT_NAMES = By.cssSelector(".cart-item-row .product-name");

}
