package interview.task.stackmachine;

import interview.task.stackmachine.api.StackMachineFactory;

/**
 * Created by mnovoseltsev on 06.11.2016.
 */
public final class FactoryProvider {

    public static StackMachineFactory<Integer> getIntegerFactory() {
        return new IntegerStackMachineFactory();
    }

    public static StackMachineFactory<Double> getDoubleFactory() {
        return new DoubleStackMachineFactory();
    }
}
