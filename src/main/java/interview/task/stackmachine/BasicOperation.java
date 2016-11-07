package interview.task.stackmachine;

import interview.task.stackmachine.api.Operation;
import interview.task.stackmachine.api.Operator;

import static java.util.Objects.isNull;

/**
 * Created by mnovoseltsev on 20.09.2016.
 */
public class BasicOperation<N> implements Operation<N> {

    private static final String NULL_OPERAND_MSG = "Provided operands cannot be NULL";

    private final OperationType operationType;
    private final Operator<N> operator;

    public BasicOperation(OperationType operationType, Operator<N> operator) {
        if (isNull(operationType)) {
            throw new IllegalStateException("Operation type cannot be NULL");
        }

        if (isNull(operator)) {
            throw new IllegalArgumentException(NULL_OPERAND_MSG);
        }

        this.operationType = operationType;
        this.operator = operator;
    }

    @Override
    public final boolean isApplicable(String sign) {
        return this.operationType.isApplicable(sign);
    }

    @Override
    public N perform(N first, N second) {

        if (isNull(first) || isNull(second)) {
            throw new IllegalArgumentException(NULL_OPERAND_MSG);
        }

        return operator.operate(first, second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicOperation that = (BasicOperation) o;

        return operationType.equals(that.operationType);

    }

    @Override
    public int hashCode() {
        return operationType.hashCode();
    }
}
