package interview.task.stackmachine;

import interview.task.stackmachine.api.Operation;
import interview.task.stackmachine.api.Parser;
import interview.task.stackmachine.api.StackMachine;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.String.format;
import static java.util.Objects.isNull;

/**
 * Created by mnovoseltsev on 15.09.2016.
 */
public class GeneralStackMachine<E> implements StackMachine<E> {

    private static final String ILLEGAL_EXPRESSION_MSG = "Provided string expression - '%s' cannot be calculated";
    private static final String OPERATIONS_NOT_FOUND_MSG = "Must be at least one operation";
    private static final String PARSER_NOT_NULL_MSG = "Parser cannot be null";

    public static final String DEFAULT_SEPARATOR = " ";

    private final Set<Operation<E>> operations;
    private final Parser<E> parser;

    public GeneralStackMachine(Collection<Operation<E>> operations, Parser<E> parser) {
        if (isNull(operations) || operations.isEmpty()) {
            throw new IllegalArgumentException(OPERATIONS_NOT_FOUND_MSG);
        }

        if (isNull(parser)) {
            throw new IllegalArgumentException(PARSER_NOT_NULL_MSG);
        }

        this.parser = parser;
        this.operations = new HashSet<>(operations);
    }

    @Override
    public E compute(String expression) {
        return compute(expression, DEFAULT_SEPARATOR);
    }

    @Override
    public E compute(String expression, String separator) {

        Deque<E> stack = new ArrayDeque<>();
        AtomicBoolean operationFound = new AtomicBoolean(false);
        for (String element : expression.split(DEFAULT_SEPARATOR)) {
            operations.stream()
                    .filter(o -> o.isApplicable(element))
                    .findAny()
                    .ifPresent(o -> {
                        if (stack.size() < 2) {
                            throw new IllegalStateException(format(ILLEGAL_EXPRESSION_MSG, expression));
                        }

                        E operationResult = o.perform(stack.pop(), stack.pop());
                        stack.push(operationResult);
                        operationFound.compareAndSet(false, true);
                    });

            if (!operationFound.get()) {
                stack.push(parser.parse(element));
            }
            operationFound.compareAndSet(true, false);
        }

        return stack.pop();
    }
}
