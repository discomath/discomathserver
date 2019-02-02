package ca.vapurrmaid.discretemathapplications.controllers;

import ca.vapurrmaid.discretemathapplications.domain.computation.Computation;
import ca.vapurrmaid.discretemathapplications.domain.computation.ComputationalResult;
import ca.vapurrmaid.discretemathapplications.domain.NaturalNumber;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
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

    private NaturalNumber prime;
//    private NaturalNumber composite;

    @Before
    public void setup() throws NaturalNumberException {
        JacksonTester.initFields(this, new ObjectMapper());
        prime = new NaturalNumber(2);
//        composite = new NaturalNumber(20);
    }

    @Test
    public void testPrimeTest() throws Exception {
        // given
        Computation c = new Computation();
        c.setResult(new ComputationalResult(Boolean.TRUE));

        given(primeService.isNaturalNumberPrime(prime))
                .willReturn(c);

        // when
        MockHttpServletResponse res = mvc.perform(
                get("/api/applications/prime-numbers/test")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("number", "" + prime.getNumberAsInteger())
        )
                .andReturn()
                .getResponse();

        // then
        assertThat(res.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(res.getContentAsString()).isEqualTo(json.write(c).getJson());
    }

}
