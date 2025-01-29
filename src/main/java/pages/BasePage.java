package pages;
/*
Базовый класс страницы
 */

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void open(String url) {
        driver.get(url);
    }

    public void click(By locator) {
        wait.until(presenceOfElementLocated(locator)).click();
    }

    public void fill(By locator, String text) {
        var element = wait.until(presenceOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public boolean isVisible(By locator) {
        try {
            return wait.until(presenceOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isEnabled(By locator) {
        return wait.until(presenceOfElementLocated(locator)).isEnabled();
    }

    public String getText(By locator) {
        return wait.until(presenceOfElementLocated(locator)).getText();
    }

    public void keyEnter() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void keyTab() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
    }

    public void keyDown() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).perform();
    }

    public void clickWithJS(By locator) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(locator));
    }

    public void selectByValue(By locator, String value) {
        WebElement selectElem = wait.until(presenceOfElementLocated(locator));
        Select select = new Select(selectElem);
        select.selectByValue(value);
    }

    public void scrollIntoView(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }
}
