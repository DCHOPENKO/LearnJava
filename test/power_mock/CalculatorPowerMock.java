package power_mock;

import lessons.for_test.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberMatcher;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Calculator.class)
public class CalculatorPowerMock {

    /*
    @Test
    public void shouldMockStatic() {
        PowerMockito.mockStatic(Calculator.class);

        Mockito.when(Calculator.getRandomStatic()).thenReturn(10);
        Mockito.when(Calculator.sumStatic(ArgumentMatchers.anyInt())).thenCallRealMethod();

        Assert.assertEquals(15, Calculator.sumStatic(5));
    }


     */
    @Test
    public void shouldMockPrivate() throws Exception {
        Calculator calculator = new Calculator();

        Calculator spiedCalc = PowerMockito.spy(calculator);

        PowerMockito
                .when(spiedCalc, MemberMatcher.method(Calculator.class, "getRandomPrivate"))
                .withNoArguments()
                .thenReturn(10);

        Assert.assertEquals(15, spiedCalc.sumRandomPrivate(5));
    }

}
