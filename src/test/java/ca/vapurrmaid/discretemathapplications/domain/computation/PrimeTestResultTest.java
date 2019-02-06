package ca.vapurrmaid.discretemathapplications.domain.computation;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeTestResultTest {

    private ComputationalResult two;
    private ComputationalResult four;

    @Before
    public void setUp() {
        two = new PrimeTestResult(true, 2);
        four = new PrimeTestResult(false, 4);
    }

    @Test
    public void testGetMessage() {
        assertThat(two.getMessage()).isEqualTo("\u2234 2 is prime");
        assertThat(four.getMessage()).isEqualTo("\u2234 4 is composite");
    }

    @Test
    public void testResultIsLogicallyTrue() {
        assertThat(two.getResultIsLogicallyTrue()).isTrue();
        assertThat(four.getResultIsLogicallyTrue()).isFalse();
    }

}
