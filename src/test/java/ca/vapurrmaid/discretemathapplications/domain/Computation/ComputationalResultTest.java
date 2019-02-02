package ca.vapurrmaid.discretemathapplications.domain.Computation;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author vapurrmaid
 */
public class ComputationalResultTest {

    private ComputationalResult falseNoMessage;
    private ComputationalResult falseMessage;
    private ComputationalResult trueNoMessage;
    private ComputationalResult trueMessage;

    @Before
    public void setup() {
        falseNoMessage = new ComputationalResult(Boolean.FALSE);
        falseMessage = new ComputationalResult(Boolean.FALSE, "false");
        trueNoMessage = new ComputationalResult(Boolean.TRUE);
        trueMessage = new ComputationalResult(Boolean.TRUE, "true");
    }

    @Test
    public void testGetMessage() {
        assertEquals("", falseNoMessage.getMessage());
        assertEquals("false", falseMessage.getMessage());
        assertEquals("", trueNoMessage.getMessage());
        assertEquals("true", trueMessage.getMessage());
    }

    @Test
    public void testIsLogicallyTrue() {
        assertEquals(false, falseNoMessage.isResultIsLogicallyTrue());
        assertEquals(false, falseMessage.isResultIsLogicallyTrue());
        assertEquals(true, trueNoMessage.isResultIsLogicallyTrue());
        assertEquals(true, trueMessage.isResultIsLogicallyTrue());
    }

}
