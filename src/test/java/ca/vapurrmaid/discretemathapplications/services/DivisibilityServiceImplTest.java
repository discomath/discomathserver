package ca.vapurrmaid.discretemathapplications.services;

import ca.vapurrmaid.discretemathapplications.domain.NaturalNumber;
import ca.vapurrmaid.discretemathapplications.error.NaturalNumberException;
import org.junit.Test;
import org.junit.Before;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author vapurrmaid
 */
public class DivisibilityServiceImplTest {

    private DivisibilityServiceImpl divisibilityService;

    @Before
    public void setup() {
        divisibilityService = new DivisibilityServiceImpl();
    }

    @Test
    public void testIsNumberDivisibleByTwo() throws NaturalNumberException {
        for (int i = 1; i < 10_000; i++) {
            NaturalNumber n = new NaturalNumber(i);
            if (i % 2 == 0) {
                assertThat(
                        divisibilityService
                                .isNumberDivisibleByTwo(n)
                                .getResult()
                                .getResultIsLogicallyTrue())
                        .isTrue();
            } else {
                assertThat(
                        divisibilityService
                                .isNumberDivisibleByTwo(n)
                                .getResult()
                                .getResultIsLogicallyTrue())
                        .isFalse();
            }
        }
    }

    @Test
    public void testIsNumberDivisibleByThree() throws NaturalNumberException {
        for (int i = 1; i < 10_000; i++) {
            NaturalNumber n = new NaturalNumber(i);
            if (i % 3 == 0) {
                assertThat(
                        divisibilityService
                                .isNumberDivisibleByThree(n)
                                .getResult()
                                .getResultIsLogicallyTrue())
                        .isTrue();
            } else {
                assertThat(
                        divisibilityService
                                .isNumberDivisibleByThree(n)
                                .getResult()
                                .getResultIsLogicallyTrue())
                        .isFalse();
            }
        }
    }

    @Test
    public void testIsNumberDivisibleByFour() throws NaturalNumberException {
        for (int i = 1; i < 10_000; i++) {
            NaturalNumber n = new NaturalNumber(i);
            if (i % 4 == 0) {
                assertThat(
                        divisibilityService
                                .isNumberDivisibleByFour(n)
                                .getResult()
                                .getResultIsLogicallyTrue())
                        .isTrue();
            } else {
                assertThat(
                        divisibilityService
                                .isNumberDivisibleByFour(n)
                                .getResult()
                                .getResultIsLogicallyTrue())
                        .isFalse();
            }
        }
    }

    @Test
    public void testIsNumberDivisibleByFive() throws NaturalNumberException {
        for (int i = 1; i < 10_000; i++) {
            NaturalNumber n = new NaturalNumber(i);
            if (i % 5 == 0) {
                assertThat(
                        divisibilityService
                                .isNumberDivisibleByFive(n)
                                .getResult()
                                .getResultIsLogicallyTrue())
                        .isTrue();
            } else {
                assertThat(
                        divisibilityService
                                .isNumberDivisibleByFive(n)
                                .getResult()
                                .getResultIsLogicallyTrue())
                        .isFalse();
            }
        }
    }

    @Test
    public void testIsNumberDivisibleBySix() throws NaturalNumberException {
        for (int i = 1; i < 10_000; i++) {
            NaturalNumber n = new NaturalNumber(i);
            if (i % 6 == 0) {
                assertThat(
                        divisibilityService
                                .isNumberDivisibleBySix(n)
                                .getResult()
                                .getResultIsLogicallyTrue())
                        .isTrue();
            } else {
                assertThat(
                        divisibilityService
                                .isNumberDivisibleBySix(n)
                                .getResult()
                                .getResultIsLogicallyTrue())
                        .isFalse();
            }
        }
    }

//    @Test
//    public void testIsNumberDivisibleBySeven() {
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testIsNumberDivisibleByEight() {
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testIsNumberDivisibleByNine() {
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testIsNumberDivisibleByTen() {
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testIsNumberDivisibleByEleven() {
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testIsNumberDivisibleByTwelve() {
//        fail("The test case is a prototype.");
//    }
}
