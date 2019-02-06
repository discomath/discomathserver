package ca.vapurrmaid.discretemathapplications.domain.computation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author vapurrmaid
 */
@EqualsAndHashCode
@RequiredArgsConstructor
@ToString
public class PrimeTestResult implements ComputationalResult {

    private final boolean resultIsLogicallyTrue;

    @Getter
    private final int number;

    @Override
    public String getMessage() {
        if (resultIsLogicallyTrue) {
            return String.format("\u2234 %d is prime", number);
        } else {
            return String.format("\u2234 %d is composite", number);
        }
    }

    @Override
    public boolean getResultIsLogicallyTrue() {
        return resultIsLogicallyTrue;
    }

}
