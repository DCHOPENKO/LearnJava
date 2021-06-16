import homeworks.basic_tasks.calculator.CalculatorRandomStatic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CalculatorRandomStatic.class)
public class CalculatorRandomStaticTest {

    @Mock
    private CalculatorRandomStatic mock;

    @Before
    public void before() {
        PowerMockito.mockStatic(CalculatorRandomStatic.class);
    }

    private void mockStaticOperands(int operandOne, int operandTwo) {
        Mockito.when(CalculatorRandomStatic.getOperandOne()).thenReturn(operandOne);
        Mockito.when(CalculatorRandomStatic.getOperandTwo()).thenReturn(operandTwo);
    }

    @Test
    public void shouldReturnPositiveMultiplyResult() {
        mockStaticOperands(10, 2);
        Mockito.when(mock.multiply()).thenCallRealMethod();
        Assert.assertEquals(20, mock.multiply());
    }

    @Test
    public void shouldReturnPositiveDividingResult() {
        mockStaticOperands(25, 5);
        Mockito.when(mock.divide()).thenCallRealMethod();
        Assert.assertEquals(5, mock.divide());
    }

    @Test
    public void shouldReturnPositiveSumResult() {
        mockStaticOperands(14, 5);
        Mockito.when(mock.sum()).thenCallRealMethod();
        Assert.assertEquals(19, mock.sum());
    }

    @Test
    public void shouldReturnPositiveDeductResult() {
        mockStaticOperands(34, 30);
        Mockito.when(mock.deduct()).thenCallRealMethod();
        Assert.assertEquals(4, mock.deduct());
    }

    @Test
    public void shouldReturnPositiveRemainderResult() {
        mockStaticOperands(5, 3);
        Mockito.when(mock.getRemainderFromDividing()).thenCallRealMethod();
        Assert.assertEquals(2, mock.getRemainderFromDividing());
    }

    @Test
    public void shouldReturnNegativeMultiplyResult() {
        mockStaticOperands(10, 2);
        Mockito.when(mock.multiply()).thenCallRealMethod();
        Assert.assertNotEquals(100, mock.multiply());
    }

    @Test
    public void shouldReturnNegativeDividingResult() {
        mockStaticOperands(25, 5);
        Mockito.when(mock.divide()).thenCallRealMethod();
        Assert.assertNotEquals(34, mock.divide());
    }

    @Test
    public void shouldReturnNegativeSumResult() {
        mockStaticOperands(14, 5);
        Mockito.when(mock.sum()).thenCallRealMethod();
        Assert.assertNotEquals(213, mock.sum());
    }

    @Test
    public void shouldReturnNegativeDeductResult() {
        mockStaticOperands(34, 30);
        Mockito.when(mock.deduct()).thenCallRealMethod();
        Assert.assertNotEquals(0, mock.deduct());
    }

    @Test
    public void shouldReturnNegativeRemainderResult() {
        mockStaticOperands(5, 5);
        Mockito.when(mock.getRemainderFromDividing()).thenCallRealMethod();
        Assert.assertNotEquals(2, mock.getRemainderFromDividing());
    }
}
