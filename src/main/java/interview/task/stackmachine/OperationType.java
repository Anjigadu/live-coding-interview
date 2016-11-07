package interview.task.stackmachine;

/**
 * Created by mnovoseltsev on 15.09.2016.
 */
enum OperationType {

    SUM("+"),
    MULTIPLY("*"),
    SUBTRACT("-");

    private final String sign;

    OperationType(String operation) {
        this.sign = operation;
    }

    boolean isApplicable(String sign) {
        return this.sign.equalsIgnoreCase(sign);
    }
}
