package MTSPaymentService;

import BaseClasses.BaseTest;
import BaseClasses.CookieAcceptSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Тестирование блока \"Онлайн пополнение без комиссии\"")
public class MtsPaymentServiceTests extends BaseTest {
    private final PlaceholderCheckerMtsPaymentService checker = new PlaceholderCheckerMtsPaymentService();
    private final CookieAcceptSupport cookieAcceptSupport = new CookieAcceptSupport();

    @Test
    @DisplayName("Проверка плейсхолдеров полей - Услуги связи ")
    public void checkPlaceholderTextOn() {
        String[] expected = new String[]{"Номер телефона", "Сумма", "E-mail для отправки чека"};
        String[] xPathFields = new String[]{"connection-phone", "connection-sum", "connection-email"};
        cookieAcceptSupport.acceptCookie(driver);
        checker.checkPlaceholderName(driver, expected, xPathFields);
    }

    @Test
    @DisplayName("Проверка плейсхолдеров полей - Домашний интернет")
    public void sec() {
        String[] expected = new String[]{"Номер абонента", "Сумма", "E-mail для отправки чека"};
        String[] xPathFields = new String[]{"internet-phone", "internet-sum", "internet-email"};
        cookieAcceptSupport.acceptCookie(driver);
        checker.checkPlaceholderName(driver, expected, xPathFields);
    }

    @Test
    @DisplayName("Проверка плейсхолдеров полей - Рассрочка")
    public void three() {
        String[] expected = new String[]{"Номер счета на 44", "Сумма", "E-mail для отправки чека"};
        String[] xPathFields = new String[]{"score-instalment", "instalment-sum", "instalment-email"};
        cookieAcceptSupport.acceptCookie(driver);
        checker.checkPlaceholderName(driver, expected, xPathFields);
    }

    @Test
    @DisplayName("Проверка плейсхолдеров полей - Задолженность")
    public void four() {
        String[] expected = new String[]{"Номер счета на 2073", "Сумма", "E-mail для отправки чека"};
        String[] xPathFields = new String[]{"score-arrears", "arrears-sum", "arrears-email"};
        cookieAcceptSupport.acceptCookie(driver);
        checker.checkPlaceholderName(driver, expected, xPathFields);
    }
}