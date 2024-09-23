package BaseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookieAcceptSupport {
    WebDriver driver;

    public CookieAcceptSupport(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookie() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree"))).click();
        } catch (TimeoutException e) {
            System.out.println("Куки не отобразились");
        }
    }
}