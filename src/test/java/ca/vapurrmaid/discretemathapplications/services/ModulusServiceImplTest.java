package ca.vapurrmaid.discretemathapplications.services;

import ca.vapurrmaid.discretemathapplications.domain.checksum.AirlineTicket;
import ca.vapurrmaid.discretemathapplications.domain.computation.Computation;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author vapurrmaid
 */
public class ModulusServiceImplTest {

    private ModulusServiceImpl modulusService;

    @Before
    public void setup() {
        modulusService = new ModulusServiceImpl();
    }

    @Test
    public void testComputeAirlineTicketCheckSum() {
        AirlineTicket at = new AirlineTicket(0000000000, 0);
        Computation result = modulusService.computeAirlineTicketCheckSum(at);

        assertThat(result)
                .as("Computation has no null properties")
                .isNotNull()
                .hasNoNullFieldsOrProperties();
    }

}
