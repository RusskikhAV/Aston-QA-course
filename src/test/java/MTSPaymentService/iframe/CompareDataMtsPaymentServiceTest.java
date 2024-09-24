package MTSPaymentService.iframe;

import BaseClasses.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CompareDataMtsPaymentServiceTest extends BaseTest {
    FillFieldsMtsPaymentService fillFieldsMtsPaymentService = new FillFieldsMtsPaymentService();

    @Test
    @DisplayName("Проверка суммы в заголовке фрейма")
    public void checkSumByPayDescriptionCost() {
        String expected = "101.00 BYN";
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame(driver);
        String actual = driver.findElement(By.xpath("//div[@class='pay-description__cost']/span[1]"))
                .getAttribute("innerHTML");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка суммы в кнопке фрейма")
    public void checkSumInButton() {
        String expected = " Оплатить  101.00 BYN <!---->";
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame(driver);
        String actual = driver.findElement(By.xpath("//button[@class='colored disabled']"))
                .getAttribute("innerHTML");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка номера телефона в заголовке фрейма")
    public void checkTelephoneNumberByPayDescriptionText() {
        String expected = "Оплата: Услуги связи\nНомер:375297777777";
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame(driver);
        String actual = driver.findElement(By.xpath(
                "//div[@class='pay-description__text']/span")).getAttribute("innerHTML");

        Assertions.assertEquals(expected, actual);
    }
}
