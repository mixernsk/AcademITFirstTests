package JTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BooksPage;
/*
Проверка кол-ва выводимых товаров в разделе Книги
 */
public class BooksTest extends BaseTest {

    @Test
    public void TestBooksPageSize() {

        int select4 = 4;
        int select8 = 8;
        BooksPage booksPage = new BooksPage(driver);

        booksPage.navigate();
        booksPage.goToBooks();

        booksPage.selectPageSize(select4);
        Assertions.assertTrue(select4 >= booksPage.getBooksNumber());

        booksPage.selectPageSize(select8);
        Assertions.assertTrue(select8 >= booksPage.getBooksNumber());
    }
}
