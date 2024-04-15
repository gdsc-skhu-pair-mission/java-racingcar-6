package racingcar.view;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import racingcar.view.Outputview;

public class OutputviewTest {
    @Test
    public void testRenderForward() {
        Outputview output = new Outputview();
        assertEquals("-", output.renderForward());
    }
}