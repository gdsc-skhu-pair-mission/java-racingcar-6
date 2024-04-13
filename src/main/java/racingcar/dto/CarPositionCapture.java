package racingcar.dto;

import java.util.List;

public record CarPositionCapture(
        List<String> carNames,
        List<Integer> positions
) {
}
