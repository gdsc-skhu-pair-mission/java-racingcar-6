package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.MoveDecider;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class RaceControllerTest {

    private RaceController raceController;
    private InputView inputView;
    private OutputView outputView;
    private MoveDecider moveDecider;
    private Cars cars;

    @BeforeEach
    void setUp() {
        inputView = mock(InputView.class);
        outputView = mock(OutputView.class);
        moveDecider = mock(MoveDecider.class);
        cars = mock(Cars.class);

        // 싱글톤 대체
        Mockito.mockStatic(Cars.class).when(Cars::getInstance).thenReturn(cars);
        Mockito.mockStatic(InputView.class).when(InputView::getInstance).thenReturn(inputView);
        Mockito.mockStatic(OutputView.class).when(OutputView::getInstance).thenReturn(outputView);

        raceController = new RaceController();
    }

    @Test
    void 게임_시작_테스트() {
        when(inputView.inputRacingCarName()).thenReturn(new String[]{"Car1", "Car2"});
        when(inputView.inputAttemptCount()).thenReturn(3);
        when(moveDecider.decideMove()).thenReturn(true);

        raceController.start();

        verify(inputView, times(1)).inputRacingCarName();
        verify(inputView, times(1)).inputAttemptCount();
        verify(cars, times(1)).addAllCar(anyList());
        verify(cars, times(3)).getCars();
    }
}
