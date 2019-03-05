package ca.vapurrmaid.discretemathapplications.domain.playingcards;

import lombok.Getter;

/**
 * @author Vapurrmaid
 */
@Getter
public class Card {

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

}
