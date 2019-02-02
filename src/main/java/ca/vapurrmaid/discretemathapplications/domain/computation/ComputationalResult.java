package ca.vapurrmaid.discretemathapplications.domain.computation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.NonNull;

/**
 * Result of applying a {@link Computation} to a given set of inputs.
 *
 * @author vapurrmaid
 */
@Data
@JsonInclude(Include.NON_NULL)
public final class ComputationalResult {

    @NonNull
    private final String message;

    private final boolean resultIsLogicallyTrue;

    /**
     * Constructor.
     *
     * @param resultIsLogicallyTrue Indicates if the result of the computation
     * is logically consistent with what the operation asks.
     */
    public ComputationalResult(final boolean resultIsLogicallyTrue) {
        this.message = "";
        this.resultIsLogicallyTrue = resultIsLogicallyTrue;
    }

    /**
     * Constructor.
     *
     * @param resultIsLogicallyTrue Indicates if the result of the computation
     * is logically consistent with what the operation asks.
     * @param message The computed result itself or a description
     */
    public ComputationalResult(final boolean resultIsLogicallyTrue, final String message) {
        this.message = message;
        this.resultIsLogicallyTrue = resultIsLogicallyTrue;
    }

}
