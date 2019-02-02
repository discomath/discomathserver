package ca.vapurrmaid.discretemathapplications.services;

import ca.vapurrmaid.discretemathapplications.domain.computation.Computation;
import ca.vapurrmaid.discretemathapplications.domain.NaturalNumber;

/**
 * Services for the divisibility of {@link NaturalNumber}s
 *
 * @author vapurrmaid
 */
public interface DivisibilityService {

    /**
     * Demonstrates a computation for deciding if the given number is a multiple
     * of 2.
     *
     * @param n A {@link NaturalNumber} is a positive Integer greater than 0.
     * @return A {@link Computation} object demonstrating the divisibility test.
     */
    Computation isNumberDivisibleByTwo(NaturalNumber n);

    /**
     * Demonstrates a computation for deciding if the given number is a multiple
     * of 3.
     *
     * @param n A {@link NaturalNumber} is a positive Integer greater than 0.
     * @return A {@link Computation} object demonstrating the divisibility test.
     */
    Computation isNumberDivisibleByThree(NaturalNumber n);

    /**
     * Demonstrates a computation for deciding if the given number is a multiple
     * of 4.
     *
     * @param n A {@link NaturalNumber} is a positive Integer greater than 0.
     * @return A {@link Computation} object demonstrating the divisibility test.
     */
    Computation isNumberDivisibleByFour(NaturalNumber n);

    /**
     * Demonstrates a computation for deciding if the given number is a multiple
     * of 5.
     *
     * @param n A {@link NaturalNumber} is a positive Integer greater than 0.
     * @return A {@link Computation} object demonstrating the divisibility test.
     */
    Computation isNumberDivisibleByFive(NaturalNumber n);

    /**
     * Demonstrates a computation for deciding if the given number is a multiple
     * of 6.
     *
     * @param n A {@link NaturalNumber} is a positive Integer greater than 0.
     * @return A {@link Computation} object demonstrating the divisibility test.
     */
    Computation isNumberDivisibleBySix(NaturalNumber n);

    /**
     * Demonstrates a computation for deciding if the given number is a multiple
     * of 8.
     *
     * @param n A {@link NaturalNumber} is a positive Integer greater than 0.
     * @return A {@link Computation} object demonstrating the divisibility test.
     */
    Computation isNumberDivisibleByEight(NaturalNumber n);

    /**
     * Demonstrates a computation for deciding if the given number is a multiple
     * of 9.
     *
     * @param n A {@link NaturalNumber} is a positive Integer greater than 0.
     * @return A {@link Computation} object demonstrating the divisibility test.
     */
    Computation isNumberDivisibleByNine(NaturalNumber n);

    /**
     * Demonstrates a computation for deciding if the given number is a multiple
     * of 10.
     *
     * @param n A {@link NaturalNumber} is a positive Integer greater than 0.
     * @return A {@link Computation} object demonstrating the divisibility test.
     */
    Computation isNumberDivisibleByTen(NaturalNumber n);

    /**
     * Demonstrates a computation for deciding if the given number is a multiple
     * of 12.
     *
     * @param n A {@link NaturalNumber} is a positive Integer greater than 0.
     * @return A {@link Computation} object demonstrating the divisibility test.
     */
    Computation isNumberDivisibleByTwelve(NaturalNumber n);
}
