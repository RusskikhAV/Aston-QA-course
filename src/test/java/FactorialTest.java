import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest extends TestBase {

    @DisplayName("Test factorial method")
    @Test
    public void factorialTest() {
        assertEquals(120, factorial.factorial(5));
    }

}
