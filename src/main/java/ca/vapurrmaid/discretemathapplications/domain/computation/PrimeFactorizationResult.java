package ca.vapurrmaid.discretemathapplications.domain.computation;

import java.util.HashMap;
import lombok.NonNull;

/**
 * Specialization of {@link ComputationalResult} for factorization
 *
 * @author vapurrmaid
 */
public class PrimeFactorizationResult extends ComputationalResult {

    // disallow empty constructor
    private PrimeFactorizationResult() {
        super(false, "");
    }

    /**
     * Constructor.
     *
     * @param resultIsLogicallyTrue Indicates if the result of the computation
     * is logically consistent with what the operation asks.
     * @param message The computed result itself or a description
     */
    public PrimeFactorizationResult(boolean resultIsLogicallyTrue, @NonNull String message) {
        super(resultIsLogicallyTrue, message);
    }

    /**
     * Returns a tally, in the form of a <code>HashMap<Integer, Integer></code>,
     * of each prime factor.
     *
     * @return tally of prime factors
     */
    public HashMap<Integer, Integer> getFactors() {
        // holds a tally of each prime factor
        HashMap<Integer, Integer> factors = new HashMap<>();
        
        // getMessage() is in the form:     number = factor \u22C5 factor ...
        String stringFactors = getMessage().split("=")[1].trim();
        stringFactors = stringFactors.replace("\u22C5", "");
        stringFactors = stringFactors.replace(" ", "");

        for (int i = 0; i < stringFactors.length(); i++) {
            Integer key = Integer.valueOf(String.valueOf(stringFactors.charAt(i)));
            if (factors.containsKey(key)) {
                factors.put(key, factors.get(key) + 1);
            } else {
                factors.put(key, 1);
            }
        }

        return factors;
    }

}
