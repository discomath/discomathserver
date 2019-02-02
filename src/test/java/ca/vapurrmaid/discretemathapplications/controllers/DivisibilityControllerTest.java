package ca.vapurrmaid.discretemathapplications.controllers;

import ca.vapurrmaid.discretemathapplications.domain.computation.Computation;
import ca.vapurrmaid.discretemathapplications.domain.NaturalNumber;
import ca.vapurrmaid.discretemathapplications.error.NaturalNumberException;
import ca.vapurrmaid.discretemathapplications.services.DivisibilityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
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
@WebMvcTest(DivisibilityController.class)
public class DivisibilityControllerTest {

    @MockBean
    DivisibilityService divisibilityService;

    @Autowired
    MockMvc mvc;

    private JacksonTester<Computation> json;

    @Before
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void testDivisibilityTest() throws NaturalNumberException, Exception {
        // given
        Computation c = new Computation();
        NaturalNumber n = new NaturalNumber(2);

        given(divisibilityService.isNumberDivisibleByTwo(n))
                .willReturn(c);
        given(divisibilityService.isNumberDivisibleByThree(n))
                .willReturn(c);
        given(divisibilityService.isNumberDivisibleByFour(n))
                .willReturn(c);
        given(divisibilityService.isNumberDivisibleByFive(n))
                .willReturn(c);
        given(divisibilityService.isNumberDivisibleBySix(n))
                .willReturn(c);
        given(divisibilityService.isNumberDivisibleByEight(n))
                .willReturn(c);
        given(divisibilityService.isNumberDivisibleByNine(n))
                .willReturn(c);
        given(divisibilityService.isNumberDivisibleByTen(n))
                .willReturn(c);
        given(divisibilityService.isNumberDivisibleByTwelve(n))
                .willReturn(c);

        for (int i = 2; i <= 12; i++) {
            if (i == 7 || i == 11) {
                continue;
            }
            testDivisibilityTest(Integer.toString(i), "2", c);
        }

    }

    private void testDivisibilityTest(String divisor, String number, Computation c) throws Exception {
        // when
        MockHttpServletResponse res = mvc.perform(
                get("/api/applications/divisibility/" + divisor)
                        .accept(MediaType.APPLICATION_JSON)
                        .param("number", number)
        )
                .andReturn()
                .getResponse();

        // then
        assertThat(res.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(res.getContentAsString()).isEqualTo(json.write(c).getJson());
    }

}
