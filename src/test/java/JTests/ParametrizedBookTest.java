package JTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;
import pages.BooksPage;

import java.util.List;

public class ParametrizedBookTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"Laptop", "Smartphone", "Fiction"})
    public void testSearchBooksAdded(String searchText) {
        BooksPage booksPage = new BooksPage(driver);

        booksPage.navigate();

        booksPage.searchProducts(searchText);

        WebElement foundFirstProduct = booksPage.getSearchResults().getFirst();

        var productName = booksPage.getProductName(foundFirstProduct);

        booksPage.addProductToCart(foundFirstProduct);

        booksPage.goToCart();
        List<String> productsAdded = booksPage.getProductsFromCart();

        Assertions.assertTrue(productsAdded.contains(productName));

    }
}
