package ca.vapurrmaid.discretemathapplications.services;

import ca.vapurrmaid.discretemathapplications.domain.computation.Computation;
import ca.vapurrmaid.discretemathapplications.domain.computation.ComputationalStep;
import ca.vapurrmaid.discretemathapplications.domain.NaturalNumber;
import ca.vapurrmaid.discretemathapplications.domain.computation.PrimeFactorizationResult;
import ca.vapurrmaid.discretemathapplications.domain.computation.PrimeTestResult;
import ca.vapurrmaid.discretemathapplications.error.NaturalNumberException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        computation.setResult(new PrimeTestResult(true, number));

        // quick return for cases of 2 or 3, since the main loop starts at 3
        if (number == 2 || number == 3) {
            return computation;
        }

        // check if multiple of 2
        computation.appendComputationalStep(new ComputationalStep("Check if number is even", ""));
        if (number % 2 == 0) {
            computation.setResult(new PrimeTestResult(false, number));
            return computation;
        }

        // split sqrt on decimal
        double sqrt = Math.sqrt(number);

        String[] numberParts = Double.toString(sqrt).split("\\.");
        computation.appendComputationalStep(new ComputationalStep(String.format("obtain sqrt(%d)", number), String.format("sqrt(%d) = %.2f", number, sqrt)));

        // 0 decimal means the sqrt came out as a natural number
        if ("0".equals(numberParts[1])) {
            computation.setResult(new PrimeTestResult(false, number));
        } else {
            // try every number from 3 -> sqrt(n)
            computation.appendComputationalStep(new ComputationalStep(String.format("try dividing all odd numbers from 3 to sqrt(%d)", number), ""));

            int i = 3;
            do {
                if ((number % i) != 0) {
                    computation.appendComputationalStep(new ComputationalStep(String.format("try %d|%d", i, number), String.format("%d does not divide %d", i, number)));
                } else {
                    computation.appendComputationalStep(new ComputationalStep(String.format("try %d|%d", i, number), String.format("%d divides %d", i, number)));
                    computation.setResult(new PrimeTestResult(false, number));
                    break;
                }
                i += 2;
            } while (i <= Integer.parseInt(numberParts[0]));
        }

        return computation;
    }

    private int findNextPrime(int p) {
        try {
            if (p % 2 == 0) {
                p++;
            } else {
                p += 2;
            }

            while (!isNaturalNumberPrime(new NaturalNumber(p)).getResult().getResultIsLogicallyTrue()) {
                p += 2;
            }
        } catch (NaturalNumberException ex) {
            Logger.getLogger(PrimeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

    @Override
    public Computation primeFactorsOfNaturalNumber(NaturalNumber n) {
        Computation computation = new Computation();
        int original = n.getNumberAsInteger();
        PrimeFactorizationResult factorization = new PrimeFactorizationResult(original);

        if (n.getNumberAsInteger() == 1) {
            factorization.addPrimeFactor(1);
            computation.setResult(factorization);
            return computation;
        }

        // start from n, and divide by primes until you get a prime
        computation.appendComputationalStep(new ComputationalStep(String.format("divide %d by primes until the remainder is prime", original), ""));

        int prime = 2;
        while (!isNaturalNumberPrime(n).getResult().getResultIsLogicallyTrue()) {
            computation.appendComputationalStep(new ComputationalStep(String.format("%d is not prime", n.getNumberAsInteger()), String.format("try %d|%d", prime, n.getNumberAsInteger())));

            // for each prime, collect # of times prime|n
            while (n.getNumberAsInteger() % prime == 0 && n.getNumberAsInteger() != prime) {
                factorization.addPrimeFactor(prime);
                try {
                    int prev = n.getNumberAsInteger();
                    n = new NaturalNumber(n.getNumberAsInteger() / prime);
                    computation.appendComputationalStep(new ComputationalStep(String.format("%d|%d", prime, prev), String.format("%d = %s\u22C5%d", prev, factorization.getMessage().split("=")[1].trim(), n.getNumberAsInteger())));
                } catch (NaturalNumberException ex) {
                    Logger.getLogger(PrimeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            prime = findNextPrime(prime);
        }

        // add remaining prime
        factorization.addPrimeFactor(n.getNumberAsInteger());
        computation.appendComputationalStep(new ComputationalStep("remainder is prime, stop", ""));
        computation.setResult(factorization);
        return computation;
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
