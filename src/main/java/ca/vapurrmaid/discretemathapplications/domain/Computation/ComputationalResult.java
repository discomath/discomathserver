package ca.vapurrmaid.discretemathapplications.domain.Computation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.NonNull;

/**
 * Result of applying a {@link Computation} to a given set of inputs.
 *
 * @author vapurrmaid
 */
@JsonInclude(Include.NON_NULL)
public final class ComputationalResult {

    /**
     * @return An error message indicating why a result wasn't successfully
     * computed.
     */
    @Getter
    private final String errorMessage;

    /**
     * @return A success message describing a computed result.
     */
    @Getter
    private final String successMessage;

    /**
     * @return The result of a successful computation.
     */
    @Getter
    private final Object result;

    /**
     * Constructor.
     *
     * @param result The numerical result of a successful computation.
     */
    public ComputationalResult(final @NonNull Object result) {
        this.errorMessage = null;
        this.successMessage = null;
        this.result = result;
    }

    /**
     * Constructor.
     *
     * @param result The numerical result of a successful computation.
     * @param successMessage A description of the computed result
     */
    public ComputationalResult(final @NonNull Object result, final @NonNull String successMessage) {
        this.errorMessage = null;
        this.successMessage = successMessage;
        this.result = result;
    }

    /**
     * Constructor.
     *
     * @param errorMessage An error message indicating why a result wasn't
     * successfully computed.
     */
    public ComputationalResult(final @NonNull String errorMessage) {
        this.errorMessage = errorMessage;
        this.successMessage = null;
        this.result = null;
    }

    /**
     * Returns whether or not a result was successfully computed.
     *
     * @return true if and only if a result was successfully computed.
     */
    public Boolean wasSuccessful() {
        return this.result == null;
    }

}
