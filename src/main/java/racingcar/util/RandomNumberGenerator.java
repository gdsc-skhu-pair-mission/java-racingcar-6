package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    public static int generateRandomNumber(int minBound, int maxBound) {
        return Randoms.pickNumberInRange(minBound, maxBound);
    }

}
