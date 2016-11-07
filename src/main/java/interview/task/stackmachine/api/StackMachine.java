package interview.task.stackmachine.api;

/**
 * Created by mnovoseltsev on 15.09.2016.
 */
public interface StackMachine<E> {

    E compute(String string);

    E compute(String string, String separator);
}
