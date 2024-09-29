package tests.top_up_online_without_commission.i_frame;

import common.Config;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.base.BaseTest;

import java.util.stream.Stream;

public class IFrameTest extends BaseTest {

    @BeforeEach
    public void before() {
        basePage.open(Config.getURL());

        mtsHomePage
                .acceptCookie()
                .fillFieldsMtsPaymentsService()
                .clickContinueBtn()
                .switchFrame();
    }

    @ParameterizedTest
    @MethodSource("paramsForCheckSumByPayDescriptionTest")
    @DisplayName("Корректность отображения реквизитов карты")
    public void checkSumByPayDescription(String field, String expected) {
        mtsHomeCardPaymentSystemPage
                .placeholderFieldsChecker(field, expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForCheckLogoByPayDescriptionTest")
    @DisplayName("Проверка наличия иконок систем")
    public void checkLogoByPayDescription(String paymentSystem) {
        mtsHomeCardPaymentSystemPage
                .checkSrcByIcon(paymentSystem);
    }

    @Test
    @DisplayName("Проверка правильного отображения сумм и номера телефона в описанни платежа")
    public void checkingSumAndTelephoneNumberByPayDescriptionTest() {
        mtsHomeCardPaymentSystemPage
                .checkSumByPayDescriptionCost();
    }

    private static Stream<Arguments> paramsForCheckSumByPayDescriptionTest() {
        return Stream.of(
                Arguments.of("creditCard", "Номер карты"),
                Arguments.of("expirationDate", "Срок действия"),
                Arguments.of("cvc", "CVC"),
                Arguments.of("holder", "Имя держателя (как на карте)")
        );
    }

    private static Stream<Arguments> paramsForCheckLogoByPayDescriptionTest() {
        return Stream.of(
                Arguments.of("visa-system"),
                Arguments.of("mastercard-system"),
                Arguments.of("belkart-system"),
                Arguments.of("maestro-system"),
                Arguments.of("mir-system-ru")
        );
    }


}
