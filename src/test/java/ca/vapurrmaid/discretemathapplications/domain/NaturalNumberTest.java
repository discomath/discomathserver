package ca.vapurrmaid.discretemathapplications.domain;

import ca.vapurrmaid.discretemathapplications.error.NaturalNumberException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author vapurrmaid
 */
public class NaturalNumberTest {

    private NaturalNumber one;
    private NaturalNumber max;

    @Before
    public void setup() throws NaturalNumberException {
        one = new NaturalNumber(1);
        max = new NaturalNumber(Integer.MAX_VALUE);
    }

    @Test
    public void testConstructor() {
        try {
            one = new NaturalNumber(1);
            max = new NaturalNumber(Integer.MAX_VALUE);
        } catch (NaturalNumberException ex) {
            System.out.println(ex.getMessage());
            fail();
        }

        try {
            NaturalNumber negativeOne = new NaturalNumber(-1);
            fail();
        } catch (NaturalNumberException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Test
    public void testGetNumberAsInteger() {
        assertEquals(Integer.valueOf(1), one.getNumberAsInteger());
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), max.getNumberAsInteger());
    }

    @Test
    public void testGetLastXDigits() throws NaturalNumberException {
        NaturalNumber n = new NaturalNumber(1234);

        // basic case
        assertEquals(Integer.valueOf(4), n.getLastXDigits(1));
        assertEquals(Integer.valueOf(34), n.getLastXDigits(2));
        assertEquals(Integer.valueOf(234), n.getLastXDigits(3));

        // requesting more digits
        assertEquals(Integer.valueOf(1234), n.getLastXDigits(100));

        // requesting 0 or negative digits
        assertEquals(null, n.getLastXDigits(0));
    }

}
