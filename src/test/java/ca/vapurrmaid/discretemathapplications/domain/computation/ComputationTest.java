package ca.vapurrmaid.discretemathapplications.domain.computation;

import java.util.stream.IntStream;
import org.junit.Test;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * @author vapurrmaid
 */
public class ComputationTest {

    private Computation computation;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        computation = new Computation();
    }

    @Test
    public void testAppendComputationalStep() {
        assert (computation.getComputationalSteps().isEmpty());
        computation.appendComputationalStep(new ComputationalStep("", ""));
        assertEquals(1, computation.getComputationalSteps().size());
    }

    @Test
    public void testGetComputationalSteps() {
        IntStream.range(0, 10).forEach((int i) -> {
            computation.appendComputationalStep(new ComputationalStep("" + i, "" + i));
        });
        assertThat(computation.getComputationalSteps()).size().isEqualTo(10);
    }

    @Test
    public void testGetAndSetResult() {
//        computation.setResult(new ComputationalResult(true));
//        assertThat(computation.getResult()).isEqualTo(new ComputationalResult(true));
    }

}
