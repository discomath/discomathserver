package ca.vapurrmaid.discretemathapplications.controllers;

import ca.vapurrmaid.discretemathapplications.domain.NaturalNumber;
import ca.vapurrmaid.discretemathapplications.error.NaturalNumberException;
import ca.vapurrmaid.discretemathapplications.services.PrimeService;
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

}
