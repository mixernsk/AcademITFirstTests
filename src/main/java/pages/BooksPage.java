package pages;
/*
Класс страницы Интернет-Магазина
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BooksPage extends BasePage {

    private String baseUrl = "https://demowebshop.tricentis.com";

    public BooksPage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        this.open(baseUrl);
    }

    public void goToBooks() {
        this.click(BooksPageLocators.BOOKS_LINK);
    }

    public void selectPageSize(int pageSize) {
        Select pageSizeSelect = new Select(driver.findElement(BooksPageLocators.PRODUCTS_SIZE));
        pageSizeSelect.selectByVisibleText(String.valueOf(pageSize));
    }

    public int getBooksNumber() {
        return driver.findElements(BooksPageLocators.PRODUCT_BOX).size();
    }

    public void searchProducts(String searchText) {
        this.fill(BooksPageLocators.SEARCH_FIELD, searchText);
        this.keyEnter();
    }

    public List<WebElement> getSearchResults() {
        return this.driver.findElements(BooksPageLocators.PRODUCT_ITEMS);
    }

    public String getProductName(WebElement element) {
        return element.findElement(BooksPageLocators.PRODUCT_TITLE).getText();
    }

    public void addProductToCart(WebElement element) {
        element.findElement(BooksPageLocators.CART_ADD_BUTTON).click();
    }

    public void goToCart() {
        this.click(BooksPageLocators.CART_LINK);
    }

    public List<String> getProductsFromCart() {
        List<String> productList = new ArrayList<>();
        for (WebElement element : this.driver.findElements(BooksPageLocators.CART_PRODUCT_NAMES)) {
            productList.add(element.getText());
        }
        return productList;
    }

}
