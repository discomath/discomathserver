package ca.vapurrmaid.discretemathapplications.domain.Computation;

import ca.vapurrmaid.discretemathapplications.domain.computation.ComputationalStep;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author vapurrmaid
 */
public class ComputationalStepTest {

    private ComputationalStep cs;

    @Before
    public void setup() {
        cs = new ComputationalStep("message", "equation");
    }

    @Test
    public void testGetMessage() {
        assertEquals("message", cs.getMessage());
    }

    @Test
    public void testGetEquation() {
        assertEquals("equation", cs.getEquation());
    }

}
