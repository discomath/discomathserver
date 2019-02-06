package ca.vapurrmaid.discretemathapplications.domain.computation;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

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
