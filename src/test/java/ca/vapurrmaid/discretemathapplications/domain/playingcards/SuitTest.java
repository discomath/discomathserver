package ca.vapurrmaid.discretemathapplications.domain.playingcards;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SuitTest {

    @Test
    public void testValues() {
        assertThat(Suit.values()).containsExactly(Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES);
    }

    @Test
    public void testGetColour() {
        assertThat(Suit.CLUBS.getColour()).isEqualTo(Colour.BLACK);
        assertThat(Suit.DIAMONDS.getColour()).isEqualTo(Colour.RED);
        assertThat(Suit.HEARTS.getColour()).isEqualTo(Colour.RED);
        assertThat(Suit.SPADES.getColour()).isEqualTo(Colour.BLACK);
    }

}
