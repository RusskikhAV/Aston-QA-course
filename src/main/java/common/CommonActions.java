package common;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class CommonActions {
    public static WebDriver createDriver() {
        WebDriver driver = null;

        switch (Config.getBrowser()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                Assertions.fail("Неправильно указан браузер: " + Config.getBrowser());
        }
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Config.getImplicitTimeOut()));
        return driver;
    }
}
