package racingcar.validate;

public class CarNameValidate {

    public static void validateCarName(String[] carNames){

        for (String carName : carNames) {
            if(carName.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5글자 이하로 만들어 주세요.");
            }
            if(carName.length() < 1){
                throw new IllegalArgumentException("자동차 이름은 1글자 이상으로 만들어 주세요.");
            }
        }
    }
}
