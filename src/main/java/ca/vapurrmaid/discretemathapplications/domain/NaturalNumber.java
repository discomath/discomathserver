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
        return this.number;
    }

}
