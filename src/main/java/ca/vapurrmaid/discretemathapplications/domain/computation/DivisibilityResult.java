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
public class DivisibilityResult implements ComputationalResult {

    private final boolean resultIsLogicallyTrue;

    @Getter
    private final int divisor;

    @Getter
    private final int number;

    @Override
    public String getMessage() {
        String divisibilityOperator;
        if (resultIsLogicallyTrue) {
            divisibilityOperator = "\u2223";
        } else {
            divisibilityOperator = "\u2224";
        }

        return String.format("\u2234 %d%s%d", divisor, divisibilityOperator, number);
    }

    @Override
    public boolean getResultIsLogicallyTrue() {
        return resultIsLogicallyTrue;
    }

}
