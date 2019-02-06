package ca.vapurrmaid.discretemathapplications.domain.computation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author Vapurrmaid
 */
@EqualsAndHashCode
@RequiredArgsConstructor
@ToString
public class PrimeFactorizationResult implements ComputationalResult {

    @Getter
    private final Map<Integer, Integer> factors = new HashMap<>();

    @Getter
    private final int number;

    public void addPrimeFactor(int prime) {
        if (factors.containsKey(prime)) {
            factors.put(prime, factors.get(prime) + 1);
        } else {
            factors.put(prime, 1);
        }
    }

    @Override
    public String getMessage() {
        String message = String.format("\u2234 %d = ", number);

        // loop through each factor, appending it by how many there are
        Iterator<Entry<Integer, Integer>> it = factors.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, Integer> entry = it.next();
            for (int i = 0; i < entry.getValue(); i++) {
                message += String.format("%d\u22C5", entry.getKey());
            }
        }

        // make sure not to add the final multiplication sign
        return message.substring(0, message.length() - 1);
    }

    @Override
    public boolean getResultIsLogicallyTrue() {
        return true;
    }

}
