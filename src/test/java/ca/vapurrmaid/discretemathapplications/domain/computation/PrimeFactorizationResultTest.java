package ca.vapurrmaid.discretemathapplications.domain.computation;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

/**
 * @author Vapurrmaid
 */
public class PrimeFactorizationResultTest {

    ComputationalResult one;
    ComputationalResult ten;
    ComputationalResult fourtyFour;

    @Before
    public void setUp() {
        one = new PrimeFactorizationResult(1);
        ((PrimeFactorizationResult) one).addPrimeFactor(1);

        ten = new PrimeFactorizationResult(10);
        ((PrimeFactorizationResult) ten).addPrimeFactor(2);
        ((PrimeFactorizationResult) ten).addPrimeFactor(5);

        fourtyFour = new PrimeFactorizationResult(44);
        ((PrimeFactorizationResult) fourtyFour).addPrimeFactor(2);
        ((PrimeFactorizationResult) fourtyFour).addPrimeFactor(2);
        ((PrimeFactorizationResult) fourtyFour).addPrimeFactor(11);
    }

    @Test
    public void testAddPrimeFactor() {
        assertThat(((PrimeFactorizationResult) one).getFactors()).hasSize(1);

        // add same key
        ((PrimeFactorizationResult) one).addPrimeFactor(1);
        assertThat(((PrimeFactorizationResult) one).getFactors())
                .hasSize(1)
                .containsExactly(entry(1, 2));
    }

    @Test
    public void testGetMessage() {
        assertThat(one.getMessage()).isEqualTo("\u2234 1 = 1");
        assertThat(ten.getMessage()).isEqualTo("\u2234 10 = 2\u22C55");
        assertThat(fourtyFour.getMessage()).isEqualTo("\u2234 44 = 2\u22C52\u22C511");
    }

    @Test
    public void testResultIsLogicallyTrue() {
        assertThat(one.getResultIsLogicallyTrue()).isTrue();
    }

}
