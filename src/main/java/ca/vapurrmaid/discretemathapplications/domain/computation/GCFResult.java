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
public class GCFResult implements ComputationalResult {

    @Getter
    private final int[] numbers;

    @Getter
    private final int greatestCommonFactor;

    @Override
    public String getMessage() {
        String messageStart = "\u2234 GCF(";
        String messageEnd = ") = " + greatestCommonFactor;
        
        // --> GCF(num, num, ...num,
        for (int n : numbers) {
            messageStart += String.format("%d,", n);
        }
        
        // make sure to trim last comma
        return messageStart.substring(0, messageStart.length() - 1) + messageEnd;
    }

    @Override
    public boolean getResultIsLogicallyTrue() {
        return true;
    }

}
