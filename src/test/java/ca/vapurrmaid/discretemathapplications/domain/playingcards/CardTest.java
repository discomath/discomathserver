package ca.vapurrmaid.discretemathapplications.domain.playingcards;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {

    private Card tenOfClubs;
    private Card aceOfDiamonds;
    private Card queenOfSpades;
    private Card kingOfHearts;

    @Before
    public void setUp() {
        tenOfClubs = new Card(Suit.CLUBS, Rank.TEN);
        aceOfDiamonds = new Card(Suit.DIAMONDS, Rank.ACE);
        queenOfSpades = new Card(Suit.SPADES, Rank.QUEEN);
        kingOfHearts = new Card(Suit.HEARTS, Rank.KING);
    }

    @Test
    public void testGetSuit() {
        assertThat(tenOfClubs.getSuit()).isEqualTo(Suit.CLUBS);
        assertThat(aceOfDiamonds.getSuit()).isEqualTo(Suit.DIAMONDS);
        assertThat(queenOfSpades.getSuit()).isEqualTo(Suit.SPADES);
        assertThat(kingOfHearts.getSuit()).isEqualTo(Suit.HEARTS);
    }

    @Test
    public void testGetRank() {
        assertThat(tenOfClubs.getRank()).isEqualTo(Rank.TEN);
        assertThat(aceOfDiamonds.getRank()).isEqualTo(Rank.ACE);
        assertThat(queenOfSpades.getRank()).isEqualTo(Rank.QUEEN);
        assertThat(kingOfHearts.getRank()).isEqualTo(Rank.KING);
    }

}
