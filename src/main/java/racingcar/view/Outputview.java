package racingcar.view;

import racingcar.model.Car;
import java.util.List;
import java.util.stream.Collectors;

public class Outputview {
    public void StartMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void CountMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void ResultMessage(){
        System.out.println("실행 결과");
    }

    public String GoMessage(){
        return "-";
    }

    // 우승자 출력
    public void PrintWinner(List<Car> winners){
       // String 객체에 Car객체를 , 단위로 나누어서 담음
        String stringWinners = winners.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + stringWinners );

    }
}
