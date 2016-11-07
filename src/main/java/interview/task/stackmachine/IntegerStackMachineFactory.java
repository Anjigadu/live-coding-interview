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
final class IntegerStackMachineFactory implements StackMachineFactory<Integer> {

    private final StackMachineBuilder<Integer> builder;

    private static final Set<Operation<Integer>> OPERATIONS = Stream.of(
            new BasicOperation<Integer>(OperationType.SUM, (first, second) -> first + second),
            new BasicOperation<Integer>(OperationType.MULTIPLY, (first, second) -> first * second),
            new BasicOperation<Integer>(OperationType.SUBTRACT, (first, second) -> second - first))
            .collect(Collectors.toSet());

    IntegerStackMachineFactory() {
        builder = new StackMachineBuilder<>();
    }

    @Override
    public StackMachine<Integer> getStackMachine() {
        return builder.with(Integer::valueOf).with(OPERATIONS).build();
    }
}
