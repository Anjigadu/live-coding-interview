package interview.task.stackmachine.api;

/**
 * Created by mnovoseltsev on 15.09.2016.
 */

public interface Operation<N> {

    N perform(N first, N second);

    boolean isApplicable(String sign);
}
