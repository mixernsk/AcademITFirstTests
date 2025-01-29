package pages;
/*
Класс страницы Интернет-Магазина
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
}
