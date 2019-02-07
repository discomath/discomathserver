package ca.vapurrmaid.discretemathapplications.controllers;

import ca.vapurrmaid.discretemathapplications.domain.computation.Computation;
import ca.vapurrmaid.discretemathapplications.domain.NaturalNumber;
import ca.vapurrmaid.discretemathapplications.domain.computation.PrimeFactorizationResult;
import ca.vapurrmaid.discretemathapplications.error.NaturalNumberException;
import ca.vapurrmaid.discretemathapplications.services.PrimeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author vapurrmaid
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PrimeController.class)
public class PrimeControllerTest {

    @MockBean
    PrimeService primeService;

    @Autowired
    MockMvc mvc;

    private JacksonTester<Computation> json;

    private NaturalNumber three;

    @Before
    public void setup() throws NaturalNumberException {
        JacksonTester.initFields(this, new ObjectMapper());
        three = new NaturalNumber(3);
    }

    @Test
    public void testPrimeTest() throws Exception {
        // given
        Computation c = new Computation();
        PrimeFactorizationResult factors = new PrimeFactorizationResult(3);
        factors.addPrimeFactor(3);
        c.setResult(factors);

        given(primeService.isNaturalNumberPrime(three))
                .willReturn(c);

        // when
        MockHttpServletResponse res = mvc.perform(
                get("/api/applications/prime-numbers/test")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("number", "" + three.getNumberAsInteger())
        )
                .andReturn()
                .getResponse();

        // then
        assertThat(res.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(res.getContentAsString()).isEqualTo(json.write(c).getJson());
    }

    @Test
    public void GCFTest() throws Exception {
        // given
        Computation c = new Computation();
        given(primeService.computeGCFfromPrimeFactorization(three, three))
                .willReturn(c);

        // when - 2 params
        MockHttpServletResponse res = mvc.perform(
                get("/api/applications/prime-numbers/gcf")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("n1", "" + three.getNumberAsInteger())
                        .param("n2", "" + three.getNumberAsInteger())
                        .param("n", "")
        )
                .andReturn()
                .getResponse();

        // then
        assertThat(res.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(res.getContentAsString()).isEqualTo(json.write(c).getJson());

        // given - 3-8 params
        c = new Computation();
        given(primeService.computeGCFfromPrimeFactorization(three, three, three, three, three))
                .willReturn(c);
        // when
        res = mvc.perform(
                get("/api/applications/prime-numbers/gcf")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("n1", "" + three.getNumberAsInteger())
                        .param("n2", "" + three.getNumberAsInteger())
                        .param("n", "" + three.getNumberAsInteger())
                        .param("n", "" + three.getNumberAsInteger())
                        .param("n", "" + three.getNumberAsInteger())
        )
                .andReturn()
                .getResponse();

        // then
        assertThat(res.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(res.getContentAsString()).isEqualTo(json.write(c).getJson());

        // given >8 params
        res = mvc.perform(
                get("/api/applications/prime-numbers/gcf")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("n1", "" + three.getNumberAsInteger())
                        .param("n2", "" + three.getNumberAsInteger())
                        .param("n", "" + three.getNumberAsInteger())
                        .param("n", "" + three.getNumberAsInteger())
                        .param("n", "" + three.getNumberAsInteger())
                        .param("n", "" + three.getNumberAsInteger())
                        .param("n", "" + three.getNumberAsInteger())
                        .param("n", "" + three.getNumberAsInteger())
                        .param("n", "" + three.getNumberAsInteger())
                        .param("n", "" + three.getNumberAsInteger())
                        .param("n", "" + three.getNumberAsInteger())
        )
                .andReturn()
                .getResponse();

        // then
        assertThat(res.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        assertThat(res.getContentAsString()).isEqualTo("Supplied 9 'n' parameters. Only excepts up to 8.");
    }

}
