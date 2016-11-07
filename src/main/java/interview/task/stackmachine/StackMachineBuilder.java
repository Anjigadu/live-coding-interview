package interview.task.stackmachine;

import interview.task.stackmachine.api.Operation;
import interview.task.stackmachine.api.Parser;
import interview.task.stackmachine.api.StackMachine;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mnovoseltsev on 06.11.2016.
 */

class StackMachineBuilder<E> {

    private Set<Operation<E>> operations;
    private Parser<E> parser;

    public StackMachineBuilder() {
        operations = new HashSet<>();
    }

    public StackMachineBuilder<E> with(Set<Operation<E>> operations) {
        this.operations.addAll(operations);
        return this;
    }

    public StackMachineBuilder<E> with(Parser<E> parser) {
        this.parser = parser;
        return this;
    }

    public StackMachine<E> build() {
        return new GeneralStackMachine<>(operations, parser);
    }
}
