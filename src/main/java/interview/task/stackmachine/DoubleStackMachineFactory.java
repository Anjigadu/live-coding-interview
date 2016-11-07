package interview.task.stackmachine;

import interview.task.stackmachine.api.Operation;
import interview.task.stackmachine.api.StackMachine;
import interview.task.stackmachine.api.StackMachineFactory;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mnovoseltsev on 06.11.2016.
 */
final class DoubleStackMachineFactory implements StackMachineFactory<Double> {

    private final StackMachineBuilder<Double> builder;

    private static final Set<Operation<Double>> OPERATIONS = Stream.of(
            new BasicOperation<Double>(OperationType.SUM, (first, second) -> first + second),
            new BasicOperation<Double>(OperationType.MULTIPLY, (first, second) -> first * second),
            new BasicOperation<Double>(OperationType.SUBTRACT, (first, second) -> second - first))
            .collect(Collectors.toSet());

    DoubleStackMachineFactory() {
        this.builder = new StackMachineBuilder<>();
    }

    @Override
    public StackMachine<Double> getStackMachine() {
        return builder.with(OPERATIONS).with(Double::valueOf).build();
    }
}
