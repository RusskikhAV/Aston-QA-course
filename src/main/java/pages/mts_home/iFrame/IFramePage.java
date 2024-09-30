package pages.mts_home.iFrame;

import common.Config;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

/***
 * В действительности не понял как точно отобразить "Пейджом" данный popUp
 * поэтому вынес его в отдельную директорию от главной страницы
 *
 * {@see placeholderFieldsChecker}
 * так же не совсем понял как работать с "динамическими" xPath,
 * то есть где изменяется только одно значение
 * есть вариант через String.format,
 * но пока что оставил как есть
 *
 */
public class IFramePage extends BasePage {

    public IFramePage(WebDriver driver) {
        super(driver);
    }

    private final By sumDescription = By.xpath("//div[@class='pay-description__cost']/span[1]");
    private final By sumButton = By.xpath("//button[@class='colored disabled']");
    private final By telephoneNumberDescription = By.xpath("//div[@class='pay-description__text']/span");


    public IFramePage checkSumByPayDescriptionCost() {
        String textDesc = getAttributeInnerHTMLText(driver.findElement(sumDescription));
        String textTelephoneNumber = getAttributeInnerHTMLText(driver.findElement(telephoneNumberDescription));
        String textSumOnBtn = getAttributeInnerHTMLText(driver.findElement(sumButton));
        Assertions.assertAll(
                () -> assertEquals(Config.getSum() + ".00 BYN", textDesc),
                () -> assertEquals("Оплата: Услуги связи\nНомер:375" + Config.getTelephoneNumber(), textTelephoneNumber),
                () -> assertEquals(" Оплатить  " + Config.getSum() + ".00 BYN <!---->", textSumOnBtn)
        );

        return this;
    }

    public IFramePage placeholderFieldsChecker(String fieldName, String expected) {
        String actual = getAttributeInnerHTMLText(driver.findElement(By.xpath(
                "//input[@formcontrolname='" + fieldName + "']/../label")));

        assertEquals(expected, actual, fieldName + "плейсхолдер не соответствует полю");

        return this;
    }

    public IFramePage checkSrcByIcon(String paymentSystem) {
        String firsPart = "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/%s.svg";
        String expected = String.format(firsPart, paymentSystem);

        String actual = getAttributeSRC(driver.findElement(By.xpath(
                "//div[@class='icons-container ng-tns-c46-1']//img[@src='assets/images/payment-icons/card-types/"
                        + paymentSystem + ".svg']")));

        assertEquals(expected, actual, paymentSystem + " не отображается");

        return this;
    }

    public IFramePage isWorkedService() {
        assertEquals(Config.getSum() + ".00 BYN", getAttributeInnerHTMLText(driver.findElement(sumDescription)));

        return this;
    }
}