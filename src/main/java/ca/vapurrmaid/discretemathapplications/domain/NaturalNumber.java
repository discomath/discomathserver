package ca.vapurrmaid.discretemathapplications.domain;

import ca.vapurrmaid.discretemathapplications.error.NaturalNumberException;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author Vapurrmaid
 */
@EqualsAndHashCode
@ToString
public final class NaturalNumber {

    private final Integer number;

    /**
     * Constructor.
     *
     * @param number A positive {@code Integer} greater than zero.
     * @throws NaturalNumberException
     */
    public NaturalNumber(final @NonNull Integer number) throws NaturalNumberException {
        if (number < 1) {
            throw new NaturalNumberException(number);
        }

        this.number = number;
    }

    /**
     * Returns the value of this {@code NaturalNumber} as an {@code Integer}
     *
     * @return {@code Integer} representation.
     */
    public Integer getNumberAsInteger() {
        return number;
    }

    public Integer getLastXDigits(int x) {
        char[] numbers = getNumberAsInteger().toString().toCharArray();
        
        // if requesting more digits than the number has, just return
        // the number (note, this is NOT padded with extra zeroes
        if (x >= numbers.length) {
            return getNumberAsInteger();
        } else if (x <= 0) {
            return null;
        }

        // otherwise walk array of digits from the back
        String result = "";
        do {
            result = result + numbers[numbers.length - (1 * x)];
            x--;
        } while (x > 0);

        return Integer.parseInt(result);
    }

}
