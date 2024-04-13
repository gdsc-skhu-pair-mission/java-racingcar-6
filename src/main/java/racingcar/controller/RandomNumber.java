package racingcar.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {
    private static final int MIN = 0;
    private static final int MAX = 9;

    public static int generateRandomNumber() {
        return pickNumberInRange(MIN, MAX);
    }
}
