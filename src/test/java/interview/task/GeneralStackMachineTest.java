package interview.task;

import interview.task.stackmachine.FactoryProvider;
import interview.task.stackmachine.api.StackMachine;
import interview.task.stackmachine.api.StackMachineFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by mnovoseltsev on 15.09.2016.
 */
public class GeneralStackMachineTest {

    private final StackMachineFactory<Integer> integerFactory = FactoryProvider.getIntegerFactory();
    private final StackMachineFactory<Double> doubleFactory = FactoryProvider.getDoubleFactory();

    @Test
    public void shouldComputeIntegerExpressionProperly() {
        StackMachine<Integer> stackMachine = integerFactory.getStackMachine();
        String expression = "1 3 + 6 * 3 -";
        // (1 + 3) * 6 - 3
        Assert.assertEquals(Integer.valueOf(21), stackMachine.compute(expression));
    }

    @Test
    @Ignore("Need improve work with rounding")
    public void shouldComputeDoubleExpressionProperly() {
        StackMachine<Double> stackMachine = doubleFactory.getStackMachine();
        String expression = "1.3 3.1 + 6 * 3.56 -";
        // (1.3 + 3.1) * 6 - 3.56
        Assert.assertEquals(Double.valueOf(22.84), stackMachine.compute(expression));
    }
}