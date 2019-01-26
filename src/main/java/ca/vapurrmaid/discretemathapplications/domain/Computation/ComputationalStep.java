package ca.vapurrmaid.discretemathapplications.domain.Computation;

import lombok.Data;

/**
 * An singular, atomic sequence of a {@link Computation}.
 *
 * @see Computation
 * @author vapurrmaid
 */
@Data
public final class ComputationalStep {

    private final String message;

    private final String equation;
}
