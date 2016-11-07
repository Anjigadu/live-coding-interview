package interview.task.stackmachine.api;

/**
 * Created by mnovoseltsev on 06.11.2016.
 */
public interface StackMachineFactory<E> {

    StackMachine<E> getStackMachine();
}
