package ca.vapurrmaid.discretemathapplications.domain.playingcards;

import java.util.Arrays;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void testValues() {
        assertThat(Rank.values()).containsExactly(Rank.ACE,
                Rank.TWO,
                Rank.THREE,
                Rank.FOUR,
                Rank.FIVE,
                Rank.SIX,
                Rank.SEVEN,
                Rank.EIGHT,
                Rank.NINE,
                Rank.TEN,
                Rank.JACK,
                Rank.QUEEN,
                Rank.KING);
    }

    @Test
    public void testGetValue() {
        Rank[] sortedRanks = Rank.values();
        Arrays.sort(sortedRanks);
        
        int value = 1;
        for (Rank r : sortedRanks) {
            assertThat(r.getValue()).isEqualTo(value);
            value++;
        }

    }

}
