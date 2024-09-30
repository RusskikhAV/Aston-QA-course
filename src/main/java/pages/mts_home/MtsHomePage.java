package pages.mts_home;

import common.Config;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import pages.base.BasePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Постарался реализовать паттерн PageObject,
 * с учетов Ваших замечаний
 *
 * В видео Лёши Маршала мы не разделяем логику проверок от наших элементов
 * поэтому пока что оставил так как в его видео
 */
public class MtsHomePage extends BasePage {

    public MtsHomePage(WebDriver driver) {
        super(driver);
    }

    private final By inputNumberPhoneField = By.xpath("//input[@id='connection-phone']");
    private final By inputSumField = By.xpath("//input[@id='connection-sum']");
    private final By inputEmailField = By.xpath("//input[@id='connection-email']");
    private final By btnContinue = By.xpath("//form[@id='pay-connection']/button");
    private final By cookieBtn = By.id("cookie-agree");
    private final By iFrame = By.xpath("//iframe[@class='bepaid-iframe']");
    private final By h2PaymentService = By.xpath("//div[@class='pay__wrapper']/h2");
    private final By hrefAboutService = By.xpath("//div[@class='pay__wrapper']//a");
    private final By h2ElementAfterMovingToHrefPage = By.xpath("//div[@class='container-fluid']/h3[1]");

    public MtsHomePage acceptCookie() {
        WebElement cookieButton = driver.findElement(cookieBtn);
        try {
            waitElementToBeClickable(cookieButton).click();
        } catch (TimeoutException e) {
            System.out.println("Куки не отобразились");
        }

        return this;
    }

    public MtsHomePage fillFieldsMtsPaymentsService() {
        driver.findElement(inputNumberPhoneField).sendKeys(Config.getTelephoneNumber());
        driver.findElement(inputSumField).sendKeys(Config.getSum());
        driver.findElement(inputEmailField).sendKeys(Config.getEmail());

        return this;
    }

    public MtsHomePage clickContinueBtn() {
        WebElement btn = driver.findElement(btnContinue);
        waitElementIsVisible(btn).click();

        return this;
    }

    public MtsHomePage switchFrame() {
        WebElement frame = driver.findElement(iFrame);
        try {
            driver.switchTo().frame(frame);
        } catch (NoSuchWindowException e) {
            System.out.println("Данный фрейм не обнаружен");
        }

        return this;
    }

    public MtsHomePage checkNameBlock() {
        WebElement element = driver.findElement(h2PaymentService);
        String h2 = getElementText(element);

        assertEquals("Онлайн пополнение\nбез комиссии", h2);

        return this;
    }


    public MtsHomePage checkPaymentPartnerVerifiedByVisa(String alt) {
        By paymentSystem = By.xpath("//div[@class='pay__wrapper']//img[@alt='" + alt + "']");
        WebElement element = driver.findElement(paymentSystem);

        assertTrue(element.isDisplayed());

        return this;
    }

    public MtsHomePage checkHref() {
        WebElement element = driver.findElement(hrefAboutService);
        String realReference = getAttributeHref(element);
        String actualReference = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

        assertEquals(actualReference, realReference);

        return this;
    }

    public MtsHomePage isWorkedHref() {
        click(driver.findElement(hrefAboutService));
        String text = getElementText(driver.findElement(h2ElementAfterMovingToHrefPage));

        assertEquals("Оплата банковской картой", text);

        return this;
    }


    public MtsHomePage checkPlaceholderName(String[] expected, String[] xPathFields) {
        String[] actual = new String[expected.length];

        for (int i = 0; i < xPathFields.length; i++) {
            actual[i] = getAttributePlaceholder(driver.findElement(By.xpath("//input[@id='" + xPathFields[i] + "']")));
        }
        Assertions.assertAll("Group by placeholder",
                () -> assertEquals(expected[0], actual[0], "Плейсхолдер " + expected[0] + " неверен"),
                () -> assertEquals(expected[1], actual[1], "Плейсхолдер " + expected[0] + " неверен"),
                () -> assertEquals(expected[2], actual[2], "Плейсхолдер " + expected[0] + " неверен")
        );

        return this;
    }
}
