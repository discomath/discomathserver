package ca.vapurrmaid.discretemathapplications.services;

import ca.vapurrmaid.discretemathapplications.domain.computation.Computation;
import ca.vapurrmaid.discretemathapplications.domain.NaturalNumber;

/**
 * Services related to primeness and factorization of {@link NaturalNumber}s
 *
 * @author vapurrmaid
 */
public interface PrimeService {

    /**
     * Tests if a given number is prime.
     *
     * @param n A {@link NaturalNumber} is a positive Integer greater than 0.
     * @return A {@link Computation} object demonstrating the prime test.
     */
    Computation isNaturalNumberPrime(NaturalNumber n);

    /**
     * Computes the prime factorization of a number.
     *
     * @param n A {@link NaturalNumber} is a positive Integer greater than 0.
     * @return A {@link Computation} object containing the prime factorization.
     */
    Computation primeFactorsOfNaturalNumber(NaturalNumber n);

    /**
     * Computes the GCF of the given numbers.
     *
     * @param n1 A {@link NaturalNumber} is a positive Integer greater than 0.
     * @param n2 A {@link NaturalNumber} is a positive Integer greater than 0.
     * @param nums A {@link NaturalNumber} is a positive Integer greater than 0.
     * @return A {@link Computation} object with the GCF.
     */
    Computation computeGCFfromPrimeFactorization(NaturalNumber n1, NaturalNumber n2, NaturalNumber... nums);

    /**
     * Computes the LCM of the given numbers.
     *
     * @param n A {@link NaturalNumber} is a positive Integer greater than 0.
     * @return
     */
    Computation computeLCMfromPrimeFactorization(NaturalNumber... n);
}
