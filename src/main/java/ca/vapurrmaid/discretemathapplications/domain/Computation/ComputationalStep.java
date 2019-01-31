package ca.vapurrmaid.discretemathapplications.domain.Computation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * An singular, atomic sequence of a {@link Computation}.
 *
 * @see Computation
 * @author vapurrmaid
 */
@EqualsAndHashCode
@Getter
@ToString
public final class ComputationalStep {

    /**
     * @return An informative message describing the step.
     */
    @NonNull
    private final String message;

    /**
     * @return The executed equation of the step.
     */
    @NonNull
    private final String equation;

    /**
     * Constructor.
     *
     * @param message An informative message describing the step.
     * @param equation The executed equation of the step.
     */
    public ComputationalStep(final String message, final String equation) {
        this.message = message;
        this.equation = equation;
    }

}
