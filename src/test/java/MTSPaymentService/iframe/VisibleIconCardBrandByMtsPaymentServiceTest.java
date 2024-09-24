package MTSPaymentService.iframe;

import BaseClasses.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class VisibleIconCardBrandByMtsPaymentServiceTest extends BaseTest {
    FillFieldsMtsPaymentService fillFieldsMtsPaymentService = new FillFieldsMtsPaymentService();

    @Test
    @DisplayName("Проверка отображения платёжной ститемы - VisaSystem")
    public void checkIconCardBrandPaymentSystemVisaSystem() {
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame(driver);
        checkSrcByIcon("visa-system");
    }

    @Test
    @DisplayName("Проверка отображения платёжной ститемы - MastercardSystem")
    public void checkIconCardBrandPaymentSystemMastercardSystem() {
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame(driver);
        checkSrcByIcon("mastercard-system");
    }

    @Test
    @DisplayName("Проверка отображения платёжной ститемы - BelkartSystem")
    public void checkIconCardBrandPaymentSystemBelkartSystem() {
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame(driver);
        checkSrcByIcon("belkart-system");
    }

    @Test
    @DisplayName("Проверка отображения платёжной ститемы - MaestroSystem")
    public void checkIconCardBrandPaymentSystemMaestroSystem() {
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame(driver);
        checkSrcByIcon("maestro-system");
    }

    @Test
    @DisplayName("Проверка отображения платёжной ститемы - MirSystemRu")
    public void checkIconCardBrandPaymentSystemMirSystemRu() {
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame(driver);
        checkSrcByIcon("mir-system-ru");
    }

    private void checkSrcByIcon(String paymentSystem) {
        String firsPart = "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/%s.svg";
        String expected = String.format(firsPart, paymentSystem);

        String actual = driver.findElement(By.xpath(
                    "//div[@class='icons-container ng-tns-c46-1']//img[@src='assets/images/payment-icons/card-types/"
                            + paymentSystem + ".svg']")).getAttribute("src");

        Assertions.assertEquals(expected, actual, paymentSystem + " не отображается");
    }
}
