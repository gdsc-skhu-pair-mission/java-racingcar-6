package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.TestNumberGenerator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoveDeciderTest {

    private MoveDecider moveDecider;

    @BeforeEach
    void setUp() {
        moveDecider = new MoveDecider(new TestNumberGenerator(4));
    }

    @Test
    void 랜덤_숫자가_이동_기준점_이상일_때_움직여야_함() {
        assertTrue(moveDecider.decideMove());
    }

    @Test
    void 랜덤_숫자가_이동_기준점_미만일_때_움직이지_않아야_함() {
        moveDecider = new MoveDecider(new TestNumberGenerator(3));
        assertFalse(moveDecider.decideMove());
    }
}
