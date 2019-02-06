package ca.vapurrmaid.discretemathapplications.domain.computation;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DivisibilityResultTest {

    private ComputationalResult one;
    private ComputationalResult ten;

    @Before
    public void setup() {
        one = new DivisibilityResult(false, 2, 1);
        ten = new DivisibilityResult(true, 2, 10);
    }

    @Test
    public void testGetMessage() {
        assertThat(one.getMessage()).isEqualTo("\u2234 2\u22241");
        assertThat(ten.getMessage()).isEqualTo("\u2234 2\u222310");
    }

    @Test
    public void testResultIsLogicallyTrue() {
        assertThat(one.getResultIsLogicallyTrue()).isFalse();
        assertThat(ten.getResultIsLogicallyTrue()).isTrue();
    }

}
