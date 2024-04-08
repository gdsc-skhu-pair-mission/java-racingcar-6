package racingcar.exception;

public enum ErrorMessage {

    DUPLICATED_CAR_NAME("자동차 이름이 중복될 수 없습니다."),
    NOT_ALLOW_BLANK("자동차 이름에 공백이 들어갈 수 없습니다."),
    NOT_ALLOW_EMPTY("입력 값이 비어있을수 없습니다."),
    INVALID_NAME_LENGTH("자동차의 이름은 5자 이하여야합니다."),
    NOT_NUMERIC("시도 횟수 입력은 숫자여야 합니다."),
    ONLY_NATURAL_NUMBER("시도 횟수는 음수 혹은 0일 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}