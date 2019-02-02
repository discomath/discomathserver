package ca.vapurrmaid.discretemathapplications.domain.computation;

import java.util.LinkedList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Demonstrates an algorithm for solving a mathematical question, or
 * application. A Computation of an application falls under a {@link SubTopic}.
 *
 * @author vapurrmaid
 */
public class Computation {

    /**
     * @return Ordered List of atomic steps for this computation.
     */
    @Getter
    private final List<ComputationalStep> computationalSteps = new LinkedList<>();

    /**
     * The result of a computation.
     *
     * @param result {@link ComputationalResult}
     * @return {@link ComputationalResult}
     */
    @Getter
    @Setter
    private ComputationalResult result;

    /**
     * Append an atomic step to the sequence of steps carried out for this
     * computation.
     *
     * @param step A {@link ComputationalStep} to append.
     */
    public void appendComputationalStep(ComputationalStep step) {
        computationalSteps.add(step);
    }
}
