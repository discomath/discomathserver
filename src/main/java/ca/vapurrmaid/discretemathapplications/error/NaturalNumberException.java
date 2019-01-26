package ca.vapurrmaid.discretemathapplications.error;

/**
 * @author Vapurrmaid
 */
public class NaturalNumberException extends Exception {

    public NaturalNumberException(Integer number) {
        super(String.format("Expected a natural number. Instead got %s.", number));
    }
}
