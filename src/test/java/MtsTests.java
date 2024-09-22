import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DisplayName("Тестирование блока \"Онлайн пополнение без комиссии\"")
public class MtsTests extends BaseTest {

    @Test
    @DisplayName("Наличие заголовка указанного блока")
    public void checkNameBlock() {
        WebElement element = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        String h2 = element.getText();

        Assertions.assertEquals("Онлайн пополнение\nбез комиссии", h2);
    }

    @Test
    @DisplayName("Наличие логотипа платёжной системы Visa")
    public void checkPaymentPartnerVisa() {
        String xPath = "//div[@class='pay__wrapper']//img[@alt='Visa']";
        WebElement element = driver.findElement(By.xpath(xPath));

        Assertions.assertTrue(element.isDisplayed());
    }

    @Test
    @DisplayName("Наличие логотипа платёжной системы Verified By Visa")
    public void checkPaymentPartnerVerifiedByVisa() {
        String xPath = "//div[@class='pay__wrapper']//img[@alt='Verified By Visa']";
        WebElement element = driver.findElement(By.xpath(xPath));

        Assertions.assertTrue(element.isDisplayed());
    }

    @Test
    @DisplayName("Наличие логотипа платёжной системы MasterCard")
    public void checkPaymentPartnerMasterCard() {
        String xPath = "//div[@class='pay__wrapper']//img[@alt='MasterCard']";
        WebElement element = driver.findElement(By.xpath(xPath));

        Assertions.assertTrue(element.isDisplayed());
    }

    @Test
    @DisplayName("Наличие логотипа платёжной системы MasterCard Secure Code")
    public void checkPaymentPartnerMasterCardSecureCode() {
        String xPath = "//div[@class='pay__wrapper']//img[@alt='MasterCard Secure Code']";
        WebElement element = driver.findElement(By.xpath(xPath));

        Assertions.assertTrue(element.isDisplayed());
    }

    @Test
    @DisplayName("Наличие логотипа платёжной системы Белкарт")
    public void checkPaymentPartnerBelCard() {
        String xPath = "//div[@class='pay__wrapper']//img[@alt='Белкарт']";
        WebElement element = driver.findElement(By.xpath(xPath));

        Assertions.assertTrue(element.isDisplayed());
    }

    @Test
    @DisplayName("Наличие ссылки \"Подробнее о сервисе\"")
    public void checkHref() {
        String xPath = "//div[@class='pay__wrapper']//a";

        WebElement element = driver.findElement(By.xpath(xPath));
        String realReference = element.getAttribute("href");
        String actualReference = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

        Assertions.assertEquals(actualReference, realReference);
    }

    @Test
    @DisplayName("Проверка работы ссылки \"Подробнее о сервисе\"")
    public void isWorkedHref() {
        String xPathHrefElement = "//div[@class='pay__wrapper']//a";
        String xPathH2ElementAfterMovingToHrefPage = "//div[@class='container-fluid']/h3[1]";

        try {
            new WebDriverWait(driver, Duration.ofSeconds(1))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='cookie show']")));
            driver.findElement(By.xpath("//button[@id='cookie-agree']")).click();
        } catch (TimeoutException e) {
            System.out.println("Куки не отобразились");
        }

        WebElement elementFromFistPage = driver.findElement(By.xpath(xPathHrefElement));
        elementFromFistPage.click();

        WebElement elementFromSecondPage = driver.findElement(By.xpath(xPathH2ElementAfterMovingToHrefPage));
        String text = elementFromSecondPage.getText();

        Assertions.assertEquals("Оплата банковской картой", text);
    }

    @Test
    @DisplayName("Проверка работы сервиса")
    public void isWorkedService() {
        String telephoneNumber = "297777777";
        String sum = "101";
        String email = "google@google.com";
        String xPathConnectionTelephone = "//input[@id='connection-phone']";
        String xPathConnectionSum = "//input[@id='connection-sum']";
        String xPathConnectionEmail = "//input[@id='connection-email']";
        String xPathButton = "//form[@id='pay-connection']/button";

        try {
            new WebDriverWait(driver, Duration.ofSeconds(1))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='cookie show']")));
                driver.findElement(By.xpath("//button[@id='cookie-agree']")).click();
        } catch (TimeoutException e) {
            System.out.println("Куки не отобразились");
        }
        WebElement elementConnectionTelephone = driver.findElement(By.xpath(xPathConnectionTelephone));
        elementConnectionTelephone.sendKeys(telephoneNumber);

        WebElement elementConnectionSum = driver.findElement(By.xpath(xPathConnectionSum));
        elementConnectionSum.sendKeys(sum);

        WebElement elementConnectionEmail = driver.findElement(By.xpath(xPathConnectionEmail));
        elementConnectionEmail.sendKeys(email);

        WebElement button = driver.findElement(By.xpath(xPathButton));
        button.click();


        WebElement frame = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        try {
            driver.switchTo().frame(frame);
        } catch (NoSuchWindowException e) {
            e.printStackTrace();
        }

        new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement currentAmountDisplayedOnPage = driver.findElement(By.xpath("//div[@class='pay-description__cost']/span[1]"));
        
        Assertions.assertEquals(sum + ".00 BYN", currentAmountDisplayedOnPage.getAttribute("innerHTML"));
    }
}

