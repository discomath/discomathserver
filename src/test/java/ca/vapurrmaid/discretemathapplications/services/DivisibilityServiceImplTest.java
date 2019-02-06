package ca.vapurrmaid.discretemathapplications.services;

import ca.vapurrmaid.discretemathapplications.domain.computation.Computation;
import ca.vapurrmaid.discretemathapplications.domain.NaturalNumber;
import ca.vapurrmaid.discretemathapplications.error.NaturalNumberException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author vapurrmaid
 */
public class DivisibilityServiceImplTest {

    private DivisibilityService divisibilityService;

    @Before
    public void setup() {
        divisibilityService = new DivisibilityServiceImpl();
    }

    private void testIsNumberDivisibleByX(int x, Method method) throws NaturalNumberException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for (int i = 1; i < 10_000; i++) {
            NaturalNumber n = new NaturalNumber(i);
            if (i % x == 0) {
                assertThat(
                        ((Computation) method.invoke(divisibilityService, n))
                                .getResult()
                                .getResultIsLogicallyTrue())
                        .isTrue();
            } else {
                assertThat(
                        ((Computation) method.invoke(divisibilityService, n))
                                .getResult()
                                .getResultIsLogicallyTrue())
                        .isFalse();
            }
        }
    }

    @Test
    public void testIsNumberDivisibleByTwo() throws NaturalNumberException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class[] parameterTypes = {NaturalNumber.class};
        Method m = DivisibilityServiceImpl.class.getMethod("isNumberDivisibleByTwo", parameterTypes);
        testIsNumberDivisibleByX(2, m);
    }

    @Test
    public void testIsNumberDivisibleByThree() throws NaturalNumberException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class[] parameterTypes = {NaturalNumber.class};
        Method m = DivisibilityServiceImpl.class.getMethod("isNumberDivisibleByThree", parameterTypes);
        testIsNumberDivisibleByX(3, m);
    }

    @Test
    public void testIsNumberDivisibleByFour() throws NaturalNumberException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class[] parameterTypes = {NaturalNumber.class};
        Method m = DivisibilityServiceImpl.class.getMethod("isNumberDivisibleByFour", parameterTypes);
        testIsNumberDivisibleByX(4, m);
    }

    @Test
    public void testIsNumberDivisibleByFive() throws NaturalNumberException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class[] parameterTypes = {NaturalNumber.class};
        Method m = DivisibilityServiceImpl.class.getMethod("isNumberDivisibleByFive", parameterTypes);
        testIsNumberDivisibleByX(5, m);
    }

    @Test
    public void testIsNumberDivisibleBySix() throws NaturalNumberException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Class[] parameterTypes = {NaturalNumber.class};
        Method m = DivisibilityServiceImpl.class.getMethod("isNumberDivisibleBySix", parameterTypes);
        testIsNumberDivisibleByX(6, m);
    }

    @Test
    public void testIsNumberDivisibleByEight() throws NoSuchMethodException, NaturalNumberException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class[] parameterTypes = {NaturalNumber.class};
        Method m = DivisibilityServiceImpl.class.getMethod("isNumberDivisibleByEight", parameterTypes);
        testIsNumberDivisibleByX(8, m);
    }

    @Test
    public void testIsNumberDivisibleByNine() throws NoSuchMethodException, NaturalNumberException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class[] parameterTypes = {NaturalNumber.class};
        Method m = DivisibilityServiceImpl.class.getMethod("isNumberDivisibleByNine", parameterTypes);
        testIsNumberDivisibleByX(9, m);
    }

    @Test
    public void testIsNumberDivisibleByTen() throws NoSuchMethodException, NaturalNumberException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class[] parameterTypes = {NaturalNumber.class};
        Method m = DivisibilityServiceImpl.class.getMethod("isNumberDivisibleByTen", parameterTypes);
        testIsNumberDivisibleByX(10, m);
    }

    @Test
    public void testIsNumberDivisibleByTwelve() throws NoSuchMethodException, NaturalNumberException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class[] parameterTypes = {NaturalNumber.class};
        Method m = DivisibilityServiceImpl.class.getMethod("isNumberDivisibleByTwelve", parameterTypes);
        testIsNumberDivisibleByX(12, m);
    }
}
