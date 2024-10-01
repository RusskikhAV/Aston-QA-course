package pages.base;

import common.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Базовая страница для всех представлений,
 * вынес в этот класс основные используемые методы в тестах
 */
public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(Config.getExplicitTimeOut()))
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(Config.getExplicitTimeOut()))
                .until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public String getAttributeInnerHTMLText(WebElement element) {
        return element.getAttribute("innerHTML");
    }

    public String getAttributeSRC(WebElement element) {
        return element.getAttribute("src");
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public String getAttributeHref(WebElement element) {
        return element.getAttribute("href");
    }

    public String getAttributePlaceholder(WebElement element) {
        return element.getAttribute("placeholder");
    }

    public void click(WebElement element) {
        try {
            element.click();
        } catch (ElementNotInteractableException ex) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        }
    }

    public boolean isTextToBePresentInElement(WebElement element, String text) {
        boolean result = false;
        try {
            result = new WebDriverWait(driver, Duration.ofSeconds(Config.getExplicitTimeOut()))
                    .until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (TimeoutException e) {
            System.out.println("Номер телефона/Сумма оплаты не совпадает");
        }
        return result;
    }
}
