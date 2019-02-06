package ca.vapurrmaid.discretemathapplications.domain.Computation;

import ca.vapurrmaid.discretemathapplications.domain.computation.PrimeFactorizationResult;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class PrimeFactorizationResultTest {

    PrimeFactorizationResult one;
    PrimeFactorizationResult ten;
    PrimeFactorizationResult twenty;

    @Before
    public void setup() {
        one = new PrimeFactorizationResult(true, "1 = 1");
        ten = new PrimeFactorizationResult(true, "10 = 2 \u22C5 5");
        twenty = new PrimeFactorizationResult(true, "20 = 2 \u22C5 2 \u22C5 5");
    }

    @Test
    public void testGetFactors() {
        assertThat(one.getFactors())
                .containsExactly(
                        entry(1, 1));

        assertThat(ten.getFactors())
                .containsExactly(
                        entry(2, 1),
                        entry(5, 1));

        assertThat(twenty.getFactors())
                .containsExactly(
                        entry(2, 2),
                        entry(5, 1));
    }

}
