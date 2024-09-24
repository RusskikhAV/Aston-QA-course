package MTSPaymentService;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaceholderCheckerMtsPaymentService {

    public void checkPlaceholderName(WebDriver driver, String[] expected, String[] xPathFields) {
        String[] actual = new String[expected.length];

        for (int i = 0; i < xPathFields.length; i++) {
            actual[i] = driver.findElement(By.xpath("//input[@id='" + xPathFields[i] + "']"))
                    .getAttribute("placeholder");
        }
        Assertions.assertAll("Group by placeholder",
                () -> Assertions.assertEquals(expected[0], actual[0], "Плейсхолдер " + expected[0] + " неверен"),
                () -> Assertions.assertEquals(expected[1], actual[1], "Плейсхолдер " + expected[0] + " неверен"),
                () -> Assertions.assertEquals(expected[2], actual[2], "Плейсхолдер " + expected[0] + " неверен")
        );
    }
}
