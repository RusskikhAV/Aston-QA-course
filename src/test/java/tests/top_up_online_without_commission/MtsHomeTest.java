package tests.top_up_online_without_commission;

import common.Config;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import tests.base.BaseTest;

import java.util.stream.Stream;

/**
 * Тут представлены тесты главной страницы МТС,
 * добавил тесты с Лекции_15
 * попробовал параметризованные тесты, с источником данных из метода
 * и используя значения аннотации
 */
public class MtsHomeTest extends BaseTest {

    @BeforeEach
    public void before() {
        basePage
                .open(Config.getURL());
    }

    @Test
    @DisplayName("Наличие заголовка указанного блока")
    public void checkNameBlockTest() {
        mtsHomePage
                .checkNameBlock();
    }

    @Test
    @DisplayName("Наличие ссылки \"Подробнее о сервисе\"")
    public void checkHrefTest() {
        mtsHomePage
                .checkHref();
    }

    @Test
    @DisplayName("Проверка работы ссылки \"Подробнее о сервисе\"")
    public void isWorkedHref() {
        mtsHomePage
                .acceptCookie()
                .isWorkedHref();

    }

    @ParameterizedTest
    @ValueSource(strings = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"})
    @DisplayName("Наличие логотипа платёжной системы Verified By Visa")
    public void checkPaymentPartnerVerifiedByVisaTest(String alt) {
        mtsHomePage
                .checkPaymentPartnerVerifiedByVisa(alt);
    }

    @ParameterizedTest
    @MethodSource("parametersForCheckPlaceholderNameTest")
    @DisplayName("Проверка надпесей в незаполненых полях каждого варианта оплаты услуг")
    public void checkPlaceholderNameTest(String[] expected, String[] xPathFields) {
        mtsHomePage
                .checkPlaceholderName(expected, xPathFields);
    }

    private static Stream<Arguments> parametersForCheckPlaceholderNameTest() {

        return Stream.of(
                Arguments.of(
                        new String[]{"Номер телефона", "Сумма", "E-mail для отправки чека"},
                        new String[]{"connection-phone", "connection-sum", "connection-email"}
                ),
                Arguments.of(
                        new String[]{"Номер абонента", "Сумма", "E-mail для отправки чека"},
                        new String[]{"internet-phone", "internet-sum", "internet-email"}
                ),
                Arguments.of(
                        new String[]{"Номер счета на 44", "Сумма", "E-mail для отправки чека"},
                        new String[]{"score-instalment", "instalment-sum", "instalment-email"}
                ),
                Arguments.of(
                        new String[]{"Номер счета на 2073", "Сумма", "E-mail для отправки чека"},
                        new String[]{"score-arrears", "arrears-sum", "arrears-email"}
                )
        );
    }
}
