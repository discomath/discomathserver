package ca.vapurrmaid.discretemathapplications.domain.computation;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GCFResultTest {

    private ComputationalResult twoSame;
    private ComputationalResult manySame;

    private ComputationalResult twoDifferentWithCommonFactor;
    private ComputationalResult manyDifferentWithCommonFactor;

    private ComputationalResult twoNoCommon;
    private ComputationalResult manyNoCommon;

    @Before
    public void setUp() {
        twoSame = new GCFResult(new int[]{2, 2}, 2);
        manySame = new GCFResult(new int[]{3, 3, 3, 3}, 3);
        twoDifferentWithCommonFactor = new GCFResult(new int[]{3, 9}, 3);
        manyDifferentWithCommonFactor = new GCFResult(new int[]{3, 6, 9, 12}, 3);
        twoNoCommon = new GCFResult(new int[]{5, 7}, 1);
        manyNoCommon = new GCFResult(new int[]{3, 5, 7, 11}, 1);
    }

    @Test
    public void testGetMessage() {
        assertThat(twoSame.getMessage()).isEqualTo("\u2234 GCF(2,2) = 2");
        assertThat(manySame.getMessage()).isEqualTo("\u2234 GCF(3,3,3,3) = 3");
        assertThat(twoDifferentWithCommonFactor.getMessage()).isEqualTo("\u2234 GCF(3,9) = 3");
        assertThat(manyDifferentWithCommonFactor.getMessage()).isEqualTo("\u2234 GCF(3,6,9,12) = 3");
        assertThat(twoNoCommon.getMessage()).isEqualTo("\u2234 GCF(5,7) = 1");
        assertThat(manyNoCommon.getMessage()).isEqualTo("\u2234 GCF(3,5,7,11) = 1");
    }

    @Test
    public void testResultIsLogicallyTrue() {
        assertThat(twoSame.getResultIsLogicallyTrue()).isTrue();
        assertThat(manySame.getResultIsLogicallyTrue()).isTrue();
        assertThat(twoDifferentWithCommonFactor.getResultIsLogicallyTrue()).isTrue();
        assertThat(manyDifferentWithCommonFactor.getResultIsLogicallyTrue()).isTrue();
        assertThat(twoNoCommon.getResultIsLogicallyTrue()).isTrue();
        assertThat(manyNoCommon.getResultIsLogicallyTrue()).isTrue();
    }

}
