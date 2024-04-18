package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ViewTest {
    private InputView inputView;

    @BeforeEach
    void 변수_초기화() {
        inputView = new InputView();
    }

    @Test
    void 자동차_이름_성공한_경우() {
        String input = "pobi,poro,kero";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<String> result = inputView.getCarNameList();

        assertThat(result).isEqualTo(Arrays.asList("pobi", "poro", "kero"));
    }

    @Test
    void 자동차_이름_공백_포함() {
        String input = "pobi,po ro, kero";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<String> result = inputView.getCarNameList();

        assertThat(result).isEqualTo(Arrays.asList("pobi", "po ro", " kero"));
    }

    @Test
    void 자동차_이름_특수문자_포함() {
        String input = "pobi,po!ro,kero*";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<String> result = inputView.getCarNameList();

        assertThat(result).isEqualTo(Arrays.asList("pobi", "po!ro", "kero*"));
    }
}