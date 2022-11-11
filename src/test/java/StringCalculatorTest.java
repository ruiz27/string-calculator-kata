import katas.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @BeforeEach
    void setUp() {

    }

    @Test
    void givenEmptyStringWhenAddThenReturnZero() {
        //given
        StringCalculator stringCalculator = this.stringCalculator;
        //when
        Integer actual = stringCalculator.add("");
        //then
        assertThat(actual).isZero();
    }

    @Test
    void givenStringWithNumberWhenAddThenReturnNumber() {
        //given
        StringCalculator stringCalculator = new StringCalculator();
        //when
        Integer actual = stringCalculator.add("4");
        //then
        assertThat(actual).isEqualTo(4);
    }


}