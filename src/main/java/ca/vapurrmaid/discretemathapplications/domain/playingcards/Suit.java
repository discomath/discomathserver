package ca.vapurrmaid.discretemathapplications.domain.playingcards;

import lombok.Getter;

/**
 * @author Vapurrmaid
 */
public enum Suit {
    CLUBS(Colour.BLACK),
    DIAMONDS(Colour.RED),
    HEARTS(Colour.RED),
    SPADES(Colour.BLACK);
    
    @Getter
    private final Colour colour;

    Suit(Colour colour) {
        this.colour = colour;
    }
}
