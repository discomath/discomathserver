package ca.vapurrmaid.discretemathapplications.services;

import ca.vapurrmaid.discretemathapplications.domain.NaturalNumber;
import ca.vapurrmaid.discretemathapplications.error.NaturalNumberException;
import java.util.HashSet;
import java.util.Set;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.Before;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Vapurrmaid
 */
public class PrimeServiceImplTest {

    private PrimeServiceImpl primeService;

    private final int[] first100Primes = {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
        31, 37, 41, 43, 47, 53, 59, 61, 67,
        71, 73, 79, 83, 89, 97
    };

    private Set<Integer> primeSet;

    @Before
    public void setup() {
        primeService = new PrimeServiceImpl();
        primeSet = new HashSet(Arrays.asList(first100Primes));
    }

    @Test
    public void testIsNaturalNumberPrime() throws NaturalNumberException {
        for (int i = 1; i < 101; i++) {
            NaturalNumber n = new NaturalNumber(i);
            if (primeSet.contains(i)) {
                assertThat(
                        primeService
                                .isNaturalNumberPrime(n)
                                .getResult()
                                .isResultIsLogicallyTrue())
                        .isTrue();
            } else {
                assertThat(
                        primeService
                                .isNaturalNumberPrime(n)
                                .getResult()
                                .isResultIsLogicallyTrue())
                        .isFalse();
            }
        }
    }

    @Test
    public void testPrimeFactorsOfNaturalNumber() throws NaturalNumberException {
        // test edge case - 1
        assertThat(primeService.primeFactorsOfNaturalNumber(new NaturalNumber(1)).getResult().getMessage()).isEqualTo("1");

        // test 2, 3, 5 and multiples
        assertThat(primeService.primeFactorsOfNaturalNumber(new NaturalNumber(6)).getResult().getMessage()).isEqualTo("2 3");
        assertThat(primeService.primeFactorsOfNaturalNumber(new NaturalNumber(30)).getResult().getMessage()).isEqualTo("2 3 5");
        assertThat(primeService.primeFactorsOfNaturalNumber(new NaturalNumber(180)).getResult().getMessage()).isEqualTo("2 2 3 3 5");

        // test primes yield themselves
        for (int p : first100Primes) {
            assertThat(primeService.primeFactorsOfNaturalNumber(new NaturalNumber(p)).getResult().getMessage()).isEqualTo(p + "");
        }

        // finally, test first 10_000 integers do not cause an infinite loop
        for (int i = 98; i <= 10_000; i++) {
            primeService.primeFactorsOfNaturalNumber(new NaturalNumber(i));
        }
    }

//    @Test
//    public void testComputeGCFfromPrimeFactorization() {
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testComputeLCMfromPrimeFactorization() {
//        fail("The test case is a prototype.");
//    }
}
