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
public class PrimeServiceImpl implements PrimeService {

    @Override
    public Computation isNaturalNumberPrime(NaturalNumber n) {
        Integer number = n.getNumberAsInteger();

        // start with the assumption of primeness, and look to disprove
        Computation computation = new Computation();
        computation.setResult(new ComputationalResult(true, String.format("%d is prime", number)));

        // quick return for cases of 2 or 3, since the main loop starts at 3
        if (number == 2 || number == 3) {
            return computation;
        }

        // check if multiple of 2
        computation.appendComputationalStep(new ComputationalStep("Check if number is even", ""));
        if (number % 2 == 0) {
            computation.setResult(new ComputationalResult(false, String.format("2|%d => not prime", number)));
            return computation;
        }

        // split sqrt on decimal
        double sqrt = Math.sqrt(number);

        String[] numberParts = Double.toString(sqrt).split("\\.");
        computation.appendComputationalStep(new ComputationalStep(String.format("obtain sqrt(%d)", number), String.format("sqrt(%d) = %.2f", number, sqrt)));

        // 0 decimal means the sqrt came out as a natural number
        if ("0".equals(numberParts[1])) {
            computation.setResult(new ComputationalResult(false, String.format("%d is a square number => not prime", number)));
        } else {
            // try every number from 3 -> sqrt(n)
            computation.appendComputationalStep(new ComputationalStep(String.format("try dividing all odd numbers from 3 to sqrt(%d)", number), ""));

            int i = 3;
            do {
                if ((number % i) != 0) {
                    computation.appendComputationalStep(new ComputationalStep(String.format("try %d|%d", i, number), String.format("%d does not divide %d", i, number)));
                } else {
                    computation.appendComputationalStep(new ComputationalStep(String.format("try %d|%d", i, number), String.format("%d divides %d", i, number)));
                    computation.setResult(new ComputationalResult(false, String.format("%d is a composite number", number)));
                    break;
                }
                i += 2;
            } while (i <= Integer.parseInt(numberParts[0]));
        }

        return computation;
    }

    @Override
    public Computation primeFactorsOfNaturalNumber(NaturalNumber n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Computation computeGCFfromPrimeFactorization(NaturalNumber... n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Computation computeLCMfromPrimeFactorization(NaturalNumber... n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
