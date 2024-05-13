package racingcar.dto;

public class CarNameDto {
    private String name;

    public CarNameDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CarNameDto of(String name) {
        return new CarNameDto(name);
    }
}
