package MTSPaymentService.iframe;

import BaseClasses.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class PlaceholderFrameMtsPaymentServiceTest extends BaseTest {
    FillFieldsMtsPaymentService fillFieldsMtsPaymentService = new FillFieldsMtsPaymentService();

    @Test
    @DisplayName("Проверка плейсхолдера поля - Номер карты")
    public void placeholderCardNumber() {
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame(driver);
        placeholderFieldsChecker("creditCard", "Номер карты");

    }

    @Test
    @DisplayName("Проверка плейсхолдера поля - Срок действия")
    public void placeholderExpirationDate() {
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame(driver);
        placeholderFieldsChecker("expirationDate", "Срок действия");
    }

    @Test
    @DisplayName("Проверка плейсхолдера поля - CVC")
    public void placeholderCVC() {
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame(driver);
        placeholderFieldsChecker("cvc", "CVC");
    }

    @Test
    @DisplayName("Проверка плейсхолдера поля - Имя держателя (как на карте)")
    public void placeholderCCName() {
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame(driver);
        placeholderFieldsChecker("holder", "Имя держателя (как на карте)");
    }

    private void placeholderFieldsChecker(String fieldName, String expected) {
        String actual = driver.findElement(By.xpath(
                "//input[@formcontrolname='" + fieldName + "']/../label")).getAttribute("innerHTML");

        Assertions.assertEquals(expected, actual, fieldName + "плейсхолдер не соответстувет полю");
    }
}