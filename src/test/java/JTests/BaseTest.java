package JTests;
/*
Базовый класс для тестовых классов
 */
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeAll
    public static void setUp() { // Инициализация браузера
        String browserType = System.getProperty("browser");

        if (browserType == null) {
            browserType = "chrome";
        }

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

        driver = switch (browserType) {
            case "chrome" -> new ChromeDriver(chromeOptions);
            case "firefox" -> new FirefoxDriver(firefoxOptions);
            case "edge" -> new EdgeDriver(edgeOptions);
            default -> new ChromeDriver(chromeOptions);
        };
        driver.manage().window().maximize();

    }

    @AfterAll
    public static void tearDown() { // Закрытие браузера
        if (driver != null) {
            driver.quit();
        }
    }
}
