import homeworks.basic_tasks.calculator.CalculatorRandomPrivate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberMatcher;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CalculatorRandomPrivate.class)
public class CalculatorRandomPrivateTest {
    CalculatorRandomPrivate calc = new CalculatorRandomPrivate();
    CalculatorRandomPrivate spiedCalc = PowerMockito.spy(calc);

    private void mockPrivateOperands(int operandOne, int operandTwo) throws Exception {
        PowerMockito
                .when(spiedCalc, MemberMatcher.method(CalculatorRandomPrivate.class, "getOperandOne"))
                .withNoArguments()
                .thenReturn(operandOne);
        PowerMockito
                .when(spiedCalc, MemberMatcher.method(CalculatorRandomPrivate.class, "getOperandTwo"))
                .withNoArguments()
                .thenReturn(operandTwo);
    }

    @Test
    public void shouldReturnPositiveMultiplyResult() throws Exception {
        mockPrivateOperands(10, 2);
        Assert.assertEquals(20, spiedCalc.multiply());
    }

    @Test
    public void shouldReturnPositiveDividingResult() throws Exception {
        mockPrivateOperands(25, 5);
        Assert.assertEquals(5, spiedCalc.divide());
    }

    @Test
    public void shouldReturnPositiveSumResult() throws Exception {
        mockPrivateOperands(14, 5);
        Assert.assertEquals(19, spiedCalc.sum());
    }

    @Test
    public void shouldReturnPositiveDeductResult() throws Exception {
        mockPrivateOperands(34, 30);
        Assert.assertEquals(4, spiedCalc.deduct());
    }

    @Test
    public void shouldReturnPositiveRemainderResult() throws Exception {
        mockPrivateOperands(5, 3);
        Assert.assertEquals(2, spiedCalc.getRemainderFromDividing());
    }

    @Test
    public void shouldReturnNegativeMultiplyResult() throws Exception {
        mockPrivateOperands(10, 2);
        Assert.assertNotEquals(100, spiedCalc.multiply());
    }

    @Test
    public void shouldReturnNegativeDividingResult() throws Exception {
        mockPrivateOperands(25, 5);
        Assert.assertNotEquals(34, spiedCalc.divide());
    }

    @Test
    public void shouldReturnNegativeSumResult() throws Exception {
        mockPrivateOperands(14, 5);
        Assert.assertNotEquals(213, spiedCalc.sum());
    }

    @Test
    public void shouldReturnNegativeDeductResult() throws Exception {
        mockPrivateOperands(34, 30);
        Assert.assertNotEquals(0, spiedCalc.deduct());
    }

    @Test
    public void shouldReturnNegativeRemainderResult() throws Exception {
        mockPrivateOperands(5, 5);
        Assert.assertNotEquals(2, spiedCalc.getRemainderFromDividing());
    }
}
