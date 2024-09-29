import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    @DisplayName("Get-Method Postman-echo")
    public void getMethodTest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("args.foo1", equalTo("bar1"))
                .and()
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    @DisplayName("Post-Method Raw Text Postman-echo")
    public void postMethodTestRawText() {
        String text = "{\n    \"test\": \"value\"\n}";
        given()
                .contentType(ContentType.TEXT.withCharset(StandardCharsets.UTF_8))
                .body(text)
                .when()
                .post("/post")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("data", equalTo(text));
    }

    @Test
    @DisplayName("Post-Method Form Data Postman-echo")
    public void postMethodTestFromData() {
        given()
                .contentType(ContentType.URLENC.withCharset(StandardCharsets.UTF_8))
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("form.foo1", equalTo("bar1"))
                .and()
                .body("form.foo2", equalTo("bar2"));
    }

    @ParameterizedTest
    @MethodSource("paramForRequestMethod")
    @DisplayName("Delete-Method Postman-echo")
    public void requestMethodTest(String method, String endpoint) {
        String BODY_TEXT = "This is expected to be sent back as part of response body.";

        given()
                .contentType(ContentType.TEXT.withCharset(StandardCharsets.UTF_8))
                .body(BODY_TEXT)
                .when()
                .request(method, endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("data", equalTo(BODY_TEXT));
    }

    private static Stream<Arguments> paramForRequestMethod() {
        return Stream.of(
                Arguments.of("PUT", "/put"),
                Arguments.of("PATCH", "/patch"),
                Arguments.of("POST", "/post")
        );
    }
}