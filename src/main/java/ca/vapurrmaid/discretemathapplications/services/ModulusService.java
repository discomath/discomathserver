package ca.vapurrmaid.discretemathapplications.services;

import ca.vapurrmaid.discretemathapplications.domain.checksum.AirlineTicket;
import ca.vapurrmaid.discretemathapplications.domain.computation.Computation;

/**
 * Services related to Modular Arithmetic of Integers.
 *
 * @author vapurrmaid
 */
public interface ModulusService {

    /**
     * Computes the checksum for an airline ticket.
     *
     * @param ticket - An Airline Ticket containing a ten digit number with a
     * checksum.
     * @return A {@link Computation} object demonstrating airline ticket
     * checksum calculation
     */
    Computation computeAirlineTicketCheckSum(AirlineTicket ticket);

}
