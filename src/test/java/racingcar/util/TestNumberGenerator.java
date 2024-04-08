package racingcar.util;

public class TestNumberGenerator implements NumberGenerator {
    private final int fixedValue;

    public TestNumberGenerator(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int generate(int startNumber, int endNumber) {
        return fixedValue;
    }
}
