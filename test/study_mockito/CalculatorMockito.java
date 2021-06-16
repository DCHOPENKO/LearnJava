package study_mockito;

import lessons.for_test.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorMockito {

    @Mock
    private Calculator mock;

    @Spy
    private Calculator calcSpy;

    @Test
    public void shouldReturnSumValuesMock() {
//        Calculator mock = Mockito.mock(Calculator.class);

        Mockito.when(mock.getRandom()).thenReturn(10);
        Mockito.when(mock.sumRandom(ArgumentMatchers.anyInt())).thenCallRealMethod();

        Assert.assertEquals(19, mock.sumRandom(9));

    }

    @Test
    public void shouldReturnSumValuesSpy() {

        Mockito.when(calcSpy.getRandom()).thenReturn(10);

        Assert.assertEquals(19, calcSpy.sumRandom(9));

        Mockito.verify(calcSpy, Mockito.times(1)).getRandom();
        Mockito.verify(calcSpy, Mockito.times(1)).sumRandom(ArgumentMatchers.anyInt());
        Mockito.verifyNoMoreInteractions(calcSpy);

    }
}
