package ca.vapurrmaid.discretemathapplications.services;

import ca.vapurrmaid.discretemathapplications.domain.checksum.AirlineTicket;
import ca.vapurrmaid.discretemathapplications.domain.computation.Computation;
import org.springframework.stereotype.Service;

/**
 * @author vapurrmaid
 */
@Service
public class ModulusServiceImpl implements ModulusService {

    @Override
    public Computation computeAirlineTicketCheckSum(AirlineTicket ticket) {
        Computation computation = new Computation();
        return computation;
    }

}
