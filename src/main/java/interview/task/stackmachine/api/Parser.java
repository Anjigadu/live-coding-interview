package interview.task.stackmachine.api;

/**
 * Created by mnovoseltsev on 06.11.2016.
 */
@FunctionalInterface
public interface Parser<T> {

    T parse(String number);
}
