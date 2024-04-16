package racingcar;

import racingcar.controller.RacingGame;
import racingcar.view.Inputview;
import racingcar.view.Outputview;

public class Application {
    public static void main(String[] args) {
        // InputView와 OutputView 인스턴스 생성
        Inputview inputview = new Inputview();
        Outputview outputview = new Outputview();

        // RacingGame 인스턴스화 시 InputView와 OutputView 객체 전달
        RacingGame racingGame = new RacingGame(inputview, outputview);

        // 게임 시작
        racingGame.startGame();
        // 게임 진행
        racingGame.carMoving();
        // 우승자 판별
        racingGame.winner();

    }
}
