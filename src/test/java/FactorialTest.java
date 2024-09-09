import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTest extends TestBase {

    @DataProvider(name = "numbers")
    public static Object[][] evenNumbers() {
        return new Object[][]{{1, 1}, {2, 2}, {3, 6}, {4, 24}, {5, 120}};
    }

    @Test(dataProvider = "numbers")
    public void factorialTest(int factorialNumber, int result) {
        assertEquals(result, factorial.factorial(factorialNumber));
    }
}
