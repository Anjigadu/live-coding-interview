package interview.task.stackmachine.api;

/**
 * Created by mnovoseltsev on 06.11.2016.
 */

@FunctionalInterface
public interface Operator<N> {

    N operate(N first, N second);
}
