package ca.vapurrmaid.discretemathapplications.domain.computation;

/**
 * Result of applying a {@link Computation} to a given set of inputs.
 *
 * @author vapurrmaid
 */
public interface ComputationalResult {

    /**
     * Human-friendly message containing the results of the computation. Message
     * might be an equation, a description or an error message.
     *
     * @return message or equation describing result
     */
    public String getMessage();

    /**
     * Indicates if the result of the computation is logically consistent with
     * what the operation asks. For some operations, this may always be true.
     *
     * Example:
     * <ul>
     * <li>isNumberPrime(4): getResultIsLogicallyTrue() -> false</li>
     * <li>isNumberPrime(3): getResultIsLogicallyTrue() -> true</li>
     * </ul>
     *
     * @return true if and only if result is logically true
     */
    public boolean getResultIsLogicallyTrue();

}
