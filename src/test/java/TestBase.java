import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    public Factorial factorial;

    @BeforeTest
    public void initObj() {
        factorial = new Factorial();
    }

    @AfterTest
    public void closeSource() {
        factorial = null;
    }
}
