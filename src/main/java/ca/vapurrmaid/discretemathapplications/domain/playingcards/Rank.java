package ca.vapurrmaid.discretemathapplications.domain.playingcards;

import lombok.Getter;

/**
 * @author Vapurrmaid
 */
public enum Rank {

    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);
    
    @Getter
    private final int value;
    
    Rank(int value) {
        this.value = value;
    }

}
