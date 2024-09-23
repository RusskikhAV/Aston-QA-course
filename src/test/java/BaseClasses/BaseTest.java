package BaseClasses;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class BaseTest {
    public static WebDriver driver;
    private static final String url = "https://www.mts.by/";

    @BeforeAll
    public static void beforeTest() {
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void beforeEach() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
    }

    @AfterAll
    public static void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}