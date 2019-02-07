package ca.vapurrmaid.discretemathapplications.services;

import ca.vapurrmaid.discretemathapplications.domain.NaturalNumber;
import ca.vapurrmaid.discretemathapplications.domain.computation.ComputationalResult;
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
                                .getResultIsLogicallyTrue())
                        .isTrue();
            } else {
                assertThat(
                        primeService
                                .isNaturalNumberPrime(n)
                                .getResult()
                                .getResultIsLogicallyTrue())
                        .isFalse();
            }
        }
    }
    
    @Test
    public void testPrimeFactorsOfNaturalNumber() throws NaturalNumberException {
        // test edge case - 1
        ComputationalResult res = primeService.primeFactorsOfNaturalNumber(new NaturalNumber(1)).getResult();
        assertThat(res.getResultIsLogicallyTrue()).isTrue();
        assertThat(res.getMessage()).isEqualTo("\u2234 1 = 1");

        // basic case - 2 different factors
        res = primeService.primeFactorsOfNaturalNumber(new NaturalNumber(6)).getResult();
        assertThat(res.getResultIsLogicallyTrue()).isTrue();
        assertThat(res.getMessage()).isEqualTo("\u2234 6 = 2\u22C53");

        // advanced case - 3 different factors, one repeating, one with multiple digits
        res = primeService.primeFactorsOfNaturalNumber(new NaturalNumber(220)).getResult();
        assertThat(res.getResultIsLogicallyTrue()).isTrue();
        assertThat(res.getMessage()).isEqualTo("\u2234 220 = 2\u22c52\u22C55\u22C511");

        // Issue #7 https://github.com/discomath/discomathserver/issues/7 - Test Message Ordering
        res = primeService.primeFactorsOfNaturalNumber(new NaturalNumber(1589)).getResult();
        assertThat(res.getResultIsLogicallyTrue()).isTrue();
        assertThat(res.getMessage()).isEqualTo("\u2234 1589 = 7\u22C5227");

        // test primes yield themselves
        for (int p : first100Primes) {
            assertThat(primeService.primeFactorsOfNaturalNumber(new NaturalNumber(p)).getResult().getMessage()).isEqualTo("\u2234 " + p + " = " + p);
        }

        // finally, test first 10_000 integers do not cause an infinite loop
        for (int i = 98; i <= 10_000; i++) {
            primeService.primeFactorsOfNaturalNumber(new NaturalNumber(i));
        }
    }
    
    @Test
    public void testComputeGCFfromPrimeFactorization() throws NaturalNumberException {
        // test same number
        ComputationalResult res = primeService.computeGCFfromPrimeFactorization(new NaturalNumber(1), new NaturalNumber(1)).getResult();
        assertThat(res.getResultIsLogicallyTrue()).isTrue();
        assertThat(res.getMessage()).isEqualTo("\u2234 GCF(1,1) = 1");
        
        res = primeService.computeGCFfromPrimeFactorization(new NaturalNumber(5), new NaturalNumber(5), new NaturalNumber(5)).getResult();
        assertThat(res.getResultIsLogicallyTrue()).isTrue();
        assertThat(res.getMessage()).isEqualTo("\u2234 GCF(5,5,5) = 5");

        // test numbers that has GCF > 1
        res = primeService.computeGCFfromPrimeFactorization(new NaturalNumber(3), new NaturalNumber(9)).getResult();
        assertThat(res.getResultIsLogicallyTrue()).isTrue();
        assertThat(res.getMessage()).isEqualTo("\u2234 GCF(3,9) = 3");
        
        res = primeService.computeGCFfromPrimeFactorization(new NaturalNumber(8), new NaturalNumber(12), new NaturalNumber(40), new NaturalNumber(400)).getResult();
        assertThat(res.getResultIsLogicallyTrue()).isTrue();
        assertThat(res.getMessage()).isEqualTo("\u2234 GCF(8,12,40,400) = 4");

        // test numbers where GCF = 1
        res = primeService.computeGCFfromPrimeFactorization(new NaturalNumber(8), new NaturalNumber(9), new NaturalNumber(10)).getResult();
        assertThat(res.getResultIsLogicallyTrue()).isTrue();
        assertThat(res.getMessage()).isEqualTo("\u2234 GCF(8,9,10) = 1");

        // test can handle Array input
        NaturalNumber[] nums = {new NaturalNumber(3), new NaturalNumber(4)};
        res = primeService.computeGCFfromPrimeFactorization(new NaturalNumber(188), new NaturalNumber(306), nums).getResult();
        assertThat(res.getResultIsLogicallyTrue()).isTrue();
        
    }

//    @Test
//    public void testComputeLCMfromPrimeFactorization() {
//        fail("The test case is a prototype.");
//    }
}
