package pages.mts_home;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import pages.base.BasePage;
import pages.mts_home.iFrame.MtsHomeCardPaymentSystemPage;

public class MtsHomePage extends BasePage {

    public MtsHomePage(WebDriver driver) {
        super(driver);
    }

    private final By numberPhoneField = By.xpath("//input[@id='connection-phone']");
    private final By sumField = By.xpath("//input[@id='connection-sum']");
    private final By emailField = By.xpath("//input[@id='connection-email']");
    private final By btnContinue = By.xpath("//form[@id='pay-connection']/button");
    private final By cookieBtn  = By.id("cookie-agree");
    private final By iFrame = By.xpath("//iframe[@class='bepaid-iframe']");

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
        //перенести данные в костанты
        driver.findElement(numberPhoneField).sendKeys("297777777");
        driver.findElement(sumField).sendKeys("101");
        driver.findElement(emailField).sendKeys("");

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

    public MtsHomePage checkPlaceholderName(String[] expected, String[] xPathFields) {
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

        return this;
    }
}
