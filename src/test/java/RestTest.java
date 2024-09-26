import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestTest {
    private final String BASE_URI = "https://postman-echo.com";
    private final String EQUAL_STR = "This is expected to be sent back as part of response body.";
    private final String RESPONSE_STR = EQUAL_STR.replace(" ", "%20");

    @Test
    @DisplayName("Get-Method Postman-echo")
    public void getMethodTest() {
        given()
                .baseUri(BASE_URI)
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("args.foo1", equalTo("bar1"))
                .and()
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    @DisplayName("Post-Method Postman-echo")
    public void postMethodTest() {
        given()
                .baseUri(BASE_URI)
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
                .baseUri(BASE_URI)
                .contentType(ContentType.TEXT.withCharset(StandardCharsets.UTF_8))
                .formParam(EQUAL_STR)
                .when()
                .put("/put")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("data", equalTo(RESPONSE_STR));
    }

    @Test
    @DisplayName("Patch-Method Postman-echo")
    public void patchMethodTest() {
        given()
                .baseUri(BASE_URI)
                .contentType(ContentType.TEXT.withCharset(StandardCharsets.UTF_8))
                .formParam(EQUAL_STR)
                .when()
                .patch("/patch")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("data", equalTo(RESPONSE_STR));
    }

    @Test
    @DisplayName("Delete-Method Postman-echo")
    public void deleteMethodTest() {
        given()
                .baseUri(BASE_URI)
                .contentType(ContentType.TEXT.withCharset(StandardCharsets.UTF_8))
                .formParam(EQUAL_STR)
                .when()
                .delete("/delete")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("data", equalTo(RESPONSE_STR));
    }
}

