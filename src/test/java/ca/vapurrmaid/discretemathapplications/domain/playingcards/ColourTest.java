package ca.vapurrmaid.discretemathapplications.domain.playingcards;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ColourTest {

    @Test
    public void testValues() {
        assertThat(Colour.values()).containsExactly(Colour.BLACK, Colour.RED);
    }

}
