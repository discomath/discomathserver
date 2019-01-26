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

    public NaturalNumber(final @NonNull Integer number) {
        if (number < 1) {
            throw new IllegalArgumentException(new NaturalNumberException(number));
        }

        this.number = number;
    }

    protected NaturalNumber() {
        this(1);
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
