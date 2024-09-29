package pages.mts_home.iFrame;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class MtsHomeCardPaymentSystemPage extends BasePage {

    public MtsHomeCardPaymentSystemPage(WebDriver driver) {
        super(driver);
    }

    private final By sumDescription = By.xpath("//div[@class='pay-description__cost']/span[1]");
    private final By sumButton = By.xpath("//button[@class='colored disabled']");
    private final By telephoneNumberDescription = By.xpath("//div[@class='pay-description__text']/span");



    public MtsHomeCardPaymentSystemPage checkSumByPayDescriptionCost() {
        String textDesc = getAttributeInnerHTMLText(driver.findElement(sumDescription));
        String textTelephoneNumber = getAttributeInnerHTMLText(driver.findElement(telephoneNumberDescription));
        String textSumOnBtn = getAttributeInnerHTMLText(driver.findElement(sumButton));
        //сделать костатнту в проперти
        Assertions.assertAll(
                () -> Assertions.assertEquals("101.00 BYN", textDesc),
                () -> Assertions.assertEquals("Оплата: Услуги связи\nНомер:375297777777", textTelephoneNumber),
                () -> Assertions.assertEquals(" Оплатить  101.00 BYN <!---->", textSumOnBtn)
        );

        return this;
    }

    public MtsHomeCardPaymentSystemPage placeholderFieldsChecker(String fieldName, String expected) {
        String actual = driver.findElement(By.xpath(
                "//input[@formcontrolname='" + fieldName + "']/../label")).getAttribute("innerHTML");

        Assertions.assertEquals(expected, actual, fieldName + "плейсхолдер не соответстувет полю");

        return this;
    }

    public MtsHomeCardPaymentSystemPage checkSrcByIcon(String paymentSystem) {
        String firsPart = "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/%s.svg";
        String expected = String.format(firsPart, paymentSystem);

        String actual = driver.findElement(By.xpath(
                "//div[@class='icons-container ng-tns-c46-1']//img[@src='assets/images/payment-icons/card-types/"
                        + paymentSystem + ".svg']")).getAttribute("src");

        Assertions.assertEquals(expected, actual, paymentSystem + " не отображается");

        return this;
    }
}
