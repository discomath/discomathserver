package ca.vapurrmaid.discretemathapplications.services;

import ca.vapurrmaid.discretemathapplications.domain.Computation.Computation;
import ca.vapurrmaid.discretemathapplications.domain.Computation.ComputationalResult;
import ca.vapurrmaid.discretemathapplications.domain.Computation.ComputationalStep;
import ca.vapurrmaid.discretemathapplications.domain.NaturalNumber;
import org.springframework.stereotype.Service;

/**
 * @author vapurrmaid
 */
@Service
public class DivisibilityServiceImpl implements DivisibilityService {

    @Override
    public Computation isNumberDivisibleByTwo(NaturalNumber n) {
        Computation computation = new Computation();

        // obtain last bit
        int lastBit = n.getNumberAsInteger() & 1;
        computation.appendComputationalStep(new ComputationalStep("obtain the least significant bit", String.format("the least significant bit of %d = %s", n.getNumberAsInteger(), lastBit)));

        // test last bit for divisibility by 2
        if (lastBit == 1) {
            computation.appendComputationalStep(new ComputationalStep("test if least significant bit is 0", "least signification bit = 1 => false"));
            computation.setResult(new ComputationalResult(false));
        } else {
            computation.appendComputationalStep(new ComputationalStep("test if least significant bit is 0", "least significant bit = 0 => true"));
            computation.setResult(new ComputationalResult(true, String.format("therefore 2|%d", n.getNumberAsInteger())));
        }

        return computation;
    }

    @Override
    public Computation isNumberDivisibleByThree(NaturalNumber n) {
        Computation computation = new Computation();
        return isNumberDivisibleByThree(n.getNumberAsInteger(), n.getNumberAsInteger(), computation);
    }

    private Computation isNumberDivisibleByThree(Integer original, Integer n, Computation computation) {
        if (n < 10) {
            if (n == 3 || n == 6 || n == 9) {
                computation.appendComputationalStep(new ComputationalStep("test final digit", String.format("remaining digit is %d => true", n)));
                computation.setResult(new ComputationalResult(true, String.format("therefore 3|%d", original)));
            } else {
                computation.appendComputationalStep(new ComputationalStep("test final digit", String.format("remaining digit is %d => false", n)));
                computation.setResult(new ComputationalResult(false));
            }

            return computation;
        } else {
            int digitSum = digitSum(n);
            computation.appendComputationalStep(new ComputationalStep("compute digit sum", String.format("digit sum of %d = %d", n, digitSum)));
            return isNumberDivisibleByThree(original, digitSum, computation);
        }
    }

    /**
     * Returns the value of the summation of the digits in the
     * {@code Natural Number} as an {@code Integer}
     *
     * @return sum of each digit
     */
    private Integer digitSum(Integer number) {
        char[] numbers = Integer.toString(number).toCharArray();

        Integer sum = 0;
        for (char c : numbers) {
            sum += Character.getNumericValue(c);
        }

        return sum;
    }

    @Override
    public Computation isNumberDivisibleByFour(NaturalNumber n) {
        Computation computation = new Computation();
        char[] numbers = n.getNumberAsInteger().toString().toCharArray();

        // obtain last two digits
        int lastTwoDigits;
        if (numbers.length >= 2) {
            lastTwoDigits = Integer.parseInt(Character.toString(numbers[numbers.length - 2]) + Character.toString(numbers[numbers.length - 1]));
        } else {
            lastTwoDigits = Character.getNumericValue(numbers[0]);
        }
        computation.appendComputationalStep(new ComputationalStep("examine last 2 digits", String.format("last 2 digits are %d", lastTwoDigits)));

        // test if last two digits are a multiple of 4
        if (lastTwoDigits % 4 == 0) {
            computation.appendComputationalStep(new ComputationalStep(String.format("test 4|%d", lastTwoDigits), String.format("4|%d => true", lastTwoDigits)));
            computation.setResult(new ComputationalResult(true, String.format("therefore 4|%d", n.getNumberAsInteger())));
        } else {
            computation.appendComputationalStep(new ComputationalStep(String.format("test 4|%d", lastTwoDigits), String.format("4 does not divide %d => false", lastTwoDigits)));
            computation.setResult(new ComputationalResult(false));
        }

        return computation;
    }

    @Override
    public Computation isNumberDivisibleByFive(NaturalNumber n) {
        Computation computation = new Computation();
        String numberString = n.getNumberAsInteger().toString();

        // obtain last digit
        int lastDigit = Integer.parseInt(numberString.substring(numberString.length() - 1));
        computation.appendComputationalStep(new ComputationalStep("obtain last digit", String.format("last digit is %d", lastDigit)));

        // test if last digit is 0 or 5
        if (lastDigit == 0 || lastDigit == 5) {
            computation.appendComputationalStep(new ComputationalStep("test last digit is {0, 5}", String.format("last digit is %d => true", lastDigit)));
            computation.setResult(new ComputationalResult(true, String.format("therefore 5|%d", n.getNumberAsInteger())));
        } else {
            computation.appendComputationalStep(new ComputationalStep("test last digit is {0, 5}", String.format("last digit is %d => false", lastDigit)));
            computation.setResult(new ComputationalResult(false));
        }

        return computation;
    }

    @Override
    public Computation isNumberDivisibleBySix(NaturalNumber n) {
        Computation computation = new Computation();

        // test divisibility by 2
        computation.appendComputationalStep(new ComputationalStep(String.format("test 2|%d", n.getNumberAsInteger()), ""));

        Computation isDivisibleByTwo = isNumberDivisibleByTwo(n);
        isDivisibleByTwo.getComputationalSteps().forEach((ComputationalStep step) -> {
            computation.appendComputationalStep(step);
        });

        if (isDivisibleByTwo.getResult().getResultIsLogicallyTrue()) {
            // test divisibility by 3
            computation.appendComputationalStep(new ComputationalStep(String.format("test 3|%d", n.getNumberAsInteger()), ""));

            Computation isDivisibleByThree = isNumberDivisibleByThree(n);
            isDivisibleByThree.getComputationalSteps().forEach((ComputationalStep step) -> {
                computation.appendComputationalStep(step);
            });

            if (isDivisibleByThree.getResult().getResultIsLogicallyTrue()) {
                computation.setResult(new ComputationalResult(true, String.format("therefore 6|%d", n.getNumberAsInteger())));
            } else {
                computation.setResult(new ComputationalResult(false));
            }
        } else {
            computation.setResult(new ComputationalResult(false));
        }

        // test divisibility by 3
        return computation;
    }

    @Override
    public Computation isNumberDivisibleBySeven(NaturalNumber n) {
        Computation computation = new Computation();

        return computation;
    }

    @Override
    public Computation isNumberDivisibleByEight(NaturalNumber n) {
        Computation computation = new Computation();

        return computation;
    }

    @Override
    public Computation isNumberDivisibleByNine(NaturalNumber n) {
        Computation computation = new Computation();

        return computation;
    }

    @Override
    public Computation isNumberDivisibleByTen(NaturalNumber n) {
        Computation computation = new Computation();

        return computation;
    }

    @Override
    public Computation isNumberDivisibleByEleven(NaturalNumber n) {
        Computation computation = new Computation();

        return computation;
    }

    @Override
    public Computation isNumberDivisibleByTwelve(NaturalNumber n) {
        Computation computation = new Computation();

        return computation;
    }

}
