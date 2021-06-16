import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import lessons.for_test.Calculator;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

/*    @Before
    public void beforeEachTest() {
        System.out.println("Before each test");
    }

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Before all tests");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("After all tests");
    }

    @After
    public void afterEachTest() {
        System.out.println("After each test");
    }*/

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Test
    public void shouldReturnSumValues() {
        Calculator calculator = new Calculator();

        int sum = calculator.sum(5, 2);

        Assert.assertEquals(7, sum);
    }

    @Test
    public void shouldReturnSumValues1() {
        Calculator calculator = new Calculator();

        int sum = calculator.sum(5, 2);

        Assert.assertEquals(7, sum);
    }

    @Test
    public void shouldPrintInConsole() {
        Calculator calculator = new Calculator();

        calculator.print();

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("Hello"));

    }

    @Test
    @Parameters({"8|6", "7|5", "-3|2"})
    public void testSum(int value1, int value2) {
        Calculator calculator = new Calculator();

        int sum = calculator.sum(value1, value2);

        Assert.assertEquals(value1 + value2, sum);
    }
}
