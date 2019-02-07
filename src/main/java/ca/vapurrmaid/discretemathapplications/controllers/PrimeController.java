package ca.vapurrmaid.discretemathapplications.controllers;

import ca.vapurrmaid.discretemathapplications.domain.NaturalNumber;
import ca.vapurrmaid.discretemathapplications.error.NaturalNumberException;
import ca.vapurrmaid.discretemathapplications.services.PrimeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST Controller for {@link PrimeService}s.
 *
 * @author vapurrmaid
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/applications/prime-numbers")
public class PrimeController {

    @Autowired
    PrimeService primeService;

    @GetMapping(
            value = "/test",
            params = "number",
            produces = "application/json"
    )
    public ResponseEntity primeTest(@RequestParam("number") Integer number) {
        try {
            NaturalNumber n = new NaturalNumber(number);
            return new ResponseEntity<>(primeService.isNaturalNumberPrime(n), HttpStatus.OK);
        } catch (NaturalNumberException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(
            value = "/factors",
            params = "number",
            produces = "application/json"
    )
    public ResponseEntity primeFactorization(@RequestParam("number") Integer number) {
        try {
            NaturalNumber n = new NaturalNumber(number);
            return new ResponseEntity<>(primeService.primeFactorsOfNaturalNumber(n), HttpStatus.OK);
        } catch (NaturalNumberException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(
            value = "/gcf",
            params = {"n1", "n2", "n"},
            produces = "application/json"
    )
    public ResponseEntity GCF(@RequestParam("n1") Integer num1, @RequestParam("n2") Integer num2, @RequestParam("n") List<Integer> others) {
        try {
            if (others.size() > 8) {
                throw new Exception();
            }
            NaturalNumber n1 = new NaturalNumber(num1);
            NaturalNumber n2 = new NaturalNumber(num2);
            NaturalNumber[] nums = new NaturalNumber[others.size()];
            for (int i = 0; i < others.size(); i++) {
                nums[i] = new NaturalNumber(others.get(i));
            }
            return new ResponseEntity<>(primeService.computeGCFfromPrimeFactorization(n1, n2, nums), HttpStatus.OK);
        } catch (NaturalNumberException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return new ResponseEntity<>("Supplied " + others.size() + " 'n' parameters. Only excepts up to 8.", HttpStatus.BAD_REQUEST);
        }
    }

}
