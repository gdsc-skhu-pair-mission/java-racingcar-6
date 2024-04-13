package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.controller.RandomNumber;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ModelTest {
    private Car car1;
    private Car car2;

    @Test
    void 자동차_객체_생성() {
        assertThat(car1).isNotNull();
        assertThat(car2).isNotNull();
    }

    @Test
    void 랜덤_숫자_생성() {
        int generatedNumber = RandomNumber.generateRandomNumber();
        assertThat(generatedNumber).isBetween(0,9);
    }

}

