package ca.vapurrmaid.discretemathapplications.domain.computation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vapurrmaid
 */
public class PrimeFactorizationResult extends ComputationalResult {

    private final Map<Integer, Integer> primeFactors;

    public PrimeFactorizationResult(boolean resultIsLogicallyTrue, String message) {
        super(resultIsLogicallyTrue, message);
        primeFactors = new HashMap<>();
    }

}
