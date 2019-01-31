package ca.vapurrmaid.discretemathapplications.domain;

import ca.vapurrmaid.discretemathapplications.error.NaturalNumberException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author vapurrmaid
 */
public class NaturalNumberTest {

    private NaturalNumber one;
    private NaturalNumber max;
    private NaturalNumber negativeOne;

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
            negativeOne = new NaturalNumber(-1);
            fail();
        } catch (NaturalNumberException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Test
    public void testGetNumberAsInteger() {
        try {
            one = new NaturalNumber(1);
            max = new NaturalNumber(Integer.MAX_VALUE);
            assert (one.getNumberAsInteger().equals(1));
            assert (max.getNumberAsInteger().equals(Integer.MAX_VALUE));
        } catch (NaturalNumberException ex) {
            System.out.println(ex.getMessage());
            fail();
        }
    }

}
