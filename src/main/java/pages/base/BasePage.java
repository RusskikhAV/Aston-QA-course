package pages.base;

import common.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public String getAttributeInnerSRC(WebElement element) {
        return element.getAttribute("src");
    }

}
