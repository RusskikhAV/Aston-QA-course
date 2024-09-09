import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    public static Factorial factorial;

    @BeforeAll
    public static void initialObj() {
        factorial = new Factorial();
    }

    @AfterAll
    public static void setObjNull() {
        factorial = null;
    }

}
