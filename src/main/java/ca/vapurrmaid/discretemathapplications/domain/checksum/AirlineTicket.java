package ca.vapurrmaid.discretemathapplications.domain.checksum;

import lombok.Getter;
import lombok.Setter;

/**
 * @author vapurrmaid
 */
public final class AirlineTicket {

    public static final int MAIN_NUMBER_LENGTH = 10;
    public static final int CHECKSUM_MODULUS = 7;

    @Getter
    @Setter
    private int mainPart;

    @Getter
    @Setter
    private int checksum;

    public AirlineTicket(int mainPart) {
        this.mainPart = mainPart;
    }

    public AirlineTicket(int mainPart, int checksum) {
        this.mainPart = mainPart;
        this.checksum = checksum;
    }
}
