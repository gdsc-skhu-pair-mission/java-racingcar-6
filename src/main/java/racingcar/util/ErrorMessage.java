package racingcar.util;

public enum ErrorMessage {
    INPUT_STRING_DUPLICATE("입력 값이 중복되었습니다."),
    INPUT_STRING_NOT_NULL("입력 값이 null이 될 수 없습니다."),
    INPUT_CAR_NAME_IS_INCORRECT("입력한 차 이름이 올바르지 않습니다."),
    INPUT_CAR_NAME_BLANK("차 이름은 공백이 될 수 없습니다."),
    INPUT_WRONG_ROUND_NUMBER("입력한 라운드 수가 올바르지 않습니다.");
    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

}
