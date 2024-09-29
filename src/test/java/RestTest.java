import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {
    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    private final String BODY_TEXT = "This is expected to be sent back as part of response body.";

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

    @Test
    @DisplayName("Put-Method Postman-echo")
    public void putMethodTest() {
        given()
                .contentType(ContentType.TEXT.withCharset(StandardCharsets.UTF_8))
                .body(BODY_TEXT)
                .when()
                .put("/put")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("data", equalTo(BODY_TEXT));
    }

    @Test
    @DisplayName("Patch-Method Postman-echo")
    public void patchMethodTest() {
        given()
                .contentType(ContentType.TEXT.withCharset(StandardCharsets.UTF_8))
                .body(BODY_TEXT)
                .when()
                .patch("/patch")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("data", equalTo(BODY_TEXT));
    }

    @Test
    @DisplayName("Delete-Method Postman-echo")
    public void deleteMethodTest() {
        given()
                .contentType(ContentType.TEXT.withCharset(StandardCharsets.UTF_8))
                .body(BODY_TEXT)
                .when()
                .delete("/delete")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("data", equalTo(BODY_TEXT));
    }
}