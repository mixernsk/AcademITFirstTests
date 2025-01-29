package JTests;
/*
Проверка ошибок при заполнении формы
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.OrderPage;

import java.util.List;

public class OrderTest extends BaseTest {

    @Test
    public void TestOrderPageErrors() {
        // Given
        List<String> errorMessages = List.of(
                "Необходимо заполнить поле ФИО:.",
                "Необходимо заполнить поле E-mail.",
                "Необходимо заполнить поле Количество.",
                "Необходимо заполнить поле Дата доставки."
        );
        OrderPage orderPage = new OrderPage(driver);

        // When
        orderPage.navigate();

        orderPage.scrollToForm();

        orderPage.submit();

        // Then
        List<String> error_results = orderPage.getErrors();
        if (!error_results.isEmpty()) {
            Assertions.assertTrue(error_results.containsAll(errorMessages));
        } else {
            System.out.println("При заполнении формы нет ошибок");
        }
    }
}
