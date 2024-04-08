package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generate(int startNumber, int endNumber) {
        return Randoms.pickNumberInRange(startNumber, endNumber);
    }
}
