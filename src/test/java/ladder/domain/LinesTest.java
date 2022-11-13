package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Collectors;
import ladder.TestLinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinesTest {

    @Test
    @DisplayName("0 이하의 값을 할당하는 경우 Lines 객체를 생성하는데 실패한다.")
    void create_with_negative_value() {
        assertThatThrownBy(() -> new Lines(0, -2)).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("0보다 큰 값만 입력 가능합니다.");
    }

    @Test
    @DisplayName("draw 메소드는 line들을 연결해준다.")
    void draw() {
        Lines lines = new Lines(5, 5);
        lines.draw(new TestLinkStrategy());

        lines.getValue().forEach(line -> {
            assertThat(line.getAllIsLinked()).isEqualTo(List.of(true, false, true, false, false));
        });
    }

    @Test
    @DisplayName("move 메소드는 입력한 시작 위치가 사다리를 따라 연결된 끝 위치를 반환한다.")
    void move() {
        Lines lines = new Lines(5, 5);
        lines.draw(new TestLinkStrategy());

        assertThat(lines.move(0)).isOne();
    }
}
