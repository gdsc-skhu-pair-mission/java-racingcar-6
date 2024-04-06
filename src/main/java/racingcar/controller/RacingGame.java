package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.Inputview;
import racingcar.view.Outputview;

import java.util.List;

public class RacingGame {
    private List<Car> cars;

    private Inputview inputview;

    private Outputview outputview;

    public RacingGame(Inputview inputview, Outputview outputview) {
        this.inputview = inputview;
        this.outputview = outputview;
    }


    public void StartGame() {
        outputview.StartMessage();
        cars = inputview.CarNameInput();
        outputview.CountMessage();
        inputview.countInput();

        outputview.ResultMessage();

    }

//    public void GameProcess() {
//        for (int i = 0; i < inputview.countInput(); i++) {
//            // 출력 메소드 인풋만큼 호출
//            // 값 누적
//            게임출력1회();
//        }
//
//    }

    public void 게임출력1회() {
        for (Car car : cars) {
            //  각 Car 객체를 이동시키는 로직 구현
            System.out.println(car);

            for (int i = 0; i < car.CarMove(); i++) {
                outputview.GoMessage();
            }
        }
    }

}
