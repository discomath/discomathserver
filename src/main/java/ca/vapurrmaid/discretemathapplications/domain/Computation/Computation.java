package ca.vapurrmaid.discretemathapplications.domain.Computation;

import ca.vapurrmaid.discretemathapplications.domain.MathTopic.SubTopic;
import java.util.LinkedList;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Demonstrates an algorithm for solving a mathematical question, or
 * application. A Computation of an application falls under a {@link SubTopic}.
 *
 * @author vapurrmaid
 */
public class Computation {

    /**
     * A mathematical {@link SubTopic}
     *
     * @return Categorical {@link SubTopic} of this computation.
     */
    @Getter
    private final SubTopic subTopic;

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
     * Constructor.
     *
     * @param subTopic {@link SubTopic} of this computation.
     */
    public Computation(final @NonNull SubTopic subTopic) {
        this.subTopic = subTopic;
    }

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
