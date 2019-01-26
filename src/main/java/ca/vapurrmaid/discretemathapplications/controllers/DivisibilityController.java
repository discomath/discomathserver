package ca.vapurrmaid.discretemathapplications.controllers;

import ca.vapurrmaid.discretemathapplications.domain.Computation.Computation;
import ca.vapurrmaid.discretemathapplications.domain.NaturalNumber;
import ca.vapurrmaid.discretemathapplications.services.DivisibilityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST Controller for {@link DivisibilityService}s.
 *
 * @author vapurrmaid
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/applications/divisibility")
public final class DivisibilityController {

    @Autowired
    private final DivisibilityServiceImpl divisibilityService;

    @RequestMapping(
            value = "/{multiple}",
            method = RequestMethod.GET,
            params = "number",
            produces = "application/json"
    )
    public ResponseEntity divisibilityTest(@PathVariable("multiple") Integer multiple, @RequestParam("number") Integer number) {
        try {
            NaturalNumber n = new NaturalNumber(number);
            return new ResponseEntity<>(divisibilityService.isNumberDivisibleByTwo(n), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getCause().getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
