import homeworks.basic_tasks.calculator.CalculatorRandomValues;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorRandomValuesTest {

    @Spy
    private CalculatorRandomValues calcSpy;

    private void verifyUsingGetOperandMethods() {
        Mockito.verify(calcSpy, Mockito.times(1)).getOperandOne();
        Mockito.verify(calcSpy, Mockito.times(1)).getOperandTwo();
    }

    @Test
    public void shouldReturnPositiveMultiplyResult() {
        Mockito.when(calcSpy.getOperandOne()).thenReturn(10);
        Mockito.when(calcSpy.getOperandTwo()).thenReturn(5);

        Assert.assertEquals(50, calcSpy.multiply());
        verifyUsingGetOperandMethods();
        Mockito.verify(calcSpy, Mockito.times(1)).multiply();
        Mockito.verifyNoMoreInteractions(calcSpy);

    }

    @Test
    public void shouldReturnPositiveDividingResult() {
        Mockito.when(calcSpy.getOperandOne()).thenReturn(15);
        Mockito.when(calcSpy.getOperandTwo()).thenReturn(5);

        Assert.assertEquals(3, calcSpy.divide());
        verifyUsingGetOperandMethods();
        Mockito.verify(calcSpy, Mockito.times(1)).divide();
        Mockito.verifyNoMoreInteractions(calcSpy);
    }

    @Test
    public void shouldReturnPositiveSumResult() {
        Mockito.when(calcSpy.getOperandOne()).thenReturn(2);
        Mockito.when(calcSpy.getOperandTwo()).thenReturn(2);

        Assert.assertEquals(4, calcSpy.sum());
        verifyUsingGetOperandMethods();
        Mockito.verify(calcSpy, Mockito.times(1)).sum();
        Mockito.verifyNoMoreInteractions(calcSpy);
    }

    @Test
    public void shouldReturnPositiveDeductResult() {
        Mockito.when(calcSpy.getOperandOne()).thenReturn(22);
        Mockito.when(calcSpy.getOperandTwo()).thenReturn(12);

        Assert.assertEquals(10, calcSpy.deduct());
        verifyUsingGetOperandMethods();
        Mockito.verify(calcSpy, Mockito.times(1)).deduct();
        Mockito.verifyNoMoreInteractions(calcSpy);
    }

    @Test
    public void shouldReturnPositiveRemainderResult() {
        Mockito.when(calcSpy.getOperandOne()).thenReturn(5);
        Mockito.when(calcSpy.getOperandTwo()).thenReturn(3);

        Assert.assertEquals(2, calcSpy.getRemainderFromDividing());
        verifyUsingGetOperandMethods();
        Mockito.verify(calcSpy, Mockito.times(1)).getRemainderFromDividing();
        Mockito.verifyNoMoreInteractions(calcSpy);
    }

    @Test
    public void shouldReturnNegativeMultiplyResult() {
        Mockito.when(calcSpy.getOperandOne()).thenReturn(11);
        Mockito.when(calcSpy.getOperandTwo()).thenReturn(122);

        Assert.assertNotEquals(100, calcSpy.multiply());
        verifyUsingGetOperandMethods();
        Mockito.verify(calcSpy, Mockito.times(1)).multiply();
        Mockito.verifyNoMoreInteractions(calcSpy);

    }

    @Test
    public void shouldReturnNegativeDividingResult() {
        Mockito.when(calcSpy.getOperandOne()).thenReturn(66);
        Mockito.when(calcSpy.getOperandTwo()).thenReturn(56);

        Assert.assertNotEquals(34, calcSpy.divide());
        verifyUsingGetOperandMethods();
        Mockito.verify(calcSpy, Mockito.times(1)).divide();
        Mockito.verifyNoMoreInteractions(calcSpy);
    }

    @Test
    public void shouldReturnNegativeSumResult() {
        Mockito.when(calcSpy.getOperandOne()).thenReturn(3);
        Mockito.when(calcSpy.getOperandTwo()).thenReturn(37);

        Assert.assertNotEquals(213, calcSpy.sum());
        verifyUsingGetOperandMethods();
        Mockito.verify(calcSpy, Mockito.times(1)).sum();
        Mockito.verifyNoMoreInteractions(calcSpy);
    }

    @Test
    public void shouldReturnNegativeDeductResult() {
        Mockito.when(calcSpy.getOperandOne()).thenReturn(10);
        Mockito.when(calcSpy.getOperandTwo()).thenReturn(0);

        Assert.assertNotEquals(0, calcSpy.deduct());
        verifyUsingGetOperandMethods();
        Mockito.verify(calcSpy, Mockito.times(1)).deduct();
        Mockito.verifyNoMoreInteractions(calcSpy);
    }

    @Test
    public void shouldReturnNegativeRemainderResult() {
        Mockito.when(calcSpy.getOperandOne()).thenReturn(33);
        Mockito.when(calcSpy.getOperandTwo()).thenReturn(11);

        Assert.assertNotEquals(2, calcSpy.getRemainderFromDividing());
        verifyUsingGetOperandMethods();
        Mockito.verify(calcSpy, Mockito.times(1)).getRemainderFromDividing();
        Mockito.verifyNoMoreInteractions(calcSpy);
    }


}
