package MTSPaymentService.iframe;

import BaseClasses.BaseTest;
import MTSPaymentService.iframe.localisation.Localisation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class VisibleIconCardBrandByMtsPaymentServiceTest extends BaseTest {
    FillFieldsMtsPaymentService fillFieldsMtsPaymentService = new FillFieldsMtsPaymentService(driver);
    String firsPart = "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/";
    String secondPart = ".svg";
    String BY = "BY";

    @Test
    @DisplayName("Проверка отображения платёжной ститемы - VisaSystem")
    public void checkIconCardBrandPaymentSystemVisaSystem() {
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame();
        checkSrcByIcon("visa-system", Localisation.BY);
    }

    @Test
    @DisplayName("Проверка отображения платёжной ститемы - MastercardSystem")
    public void checkIconCardBrandPaymentSystemMastercardSystem() {
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame();
        checkSrcByIcon("mastercard-system", Localisation.BY);
    }

    @Test
    @DisplayName("Проверка отображения платёжной ститемы - BelkartSystem")
    public void checkIconCardBrandPaymentSystemBelkartSystem() {
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame();
        checkSrcByIcon("belkart-system", Localisation.BY);
    }

    @Test
    @DisplayName("Проверка отображения платёжной ститемы - MaestroSystem")
    public void checkIconCardBrandPaymentSystemMaestroSystem() {
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame();
        checkSrcByIcon("maestro-system", Localisation.USA);
    }

    @Test
    @DisplayName("Проверка отображения платёжной ститемы - MirSystemRu")
    public void checkIconCardBrandPaymentSystemMirSystemRu() {
        fillFieldsMtsPaymentService.fillAllFieldAndSwitchFrame();
        checkSrcByIcon("mir-system-ru", Localisation.RU);
    }

    private void checkSrcByIcon(String paymentSystem, Localisation localisation) {
        String expectedAfterConcatenate = firsPart + paymentSystem + secondPart;

        String actual;
        if (localisation.equals(Localisation.BY)) {
            actual = driver.findElement(By.xpath(
                    "//div[@class='icons-container ng-tns-c46-1']//img[@src='assets/images/payment-icons/card-types/"
                            + paymentSystem + ".svg']")).getAttribute("src");

        } else {
            actual = driver.findElement(By.xpath(
                    "//div[@class='icons-container ng-tns-c46-1']/div/div/div/img[@src='assets/images/payment-icons/card-types/"
                            + paymentSystem + ".svg']")).getAttribute("src");

        }
        Assertions.assertEquals(expectedAfterConcatenate, actual, paymentSystem + " не отображается");
    }
}
