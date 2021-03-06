package dev.ksarou.wotif.core.booleans;

import dev.ksarou.wotif.core.Conditions;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class NoneOfBooleanConditionTest {

    @Test
    public void testNoneOfWithIsTrueThenReturnOne() {
        Integer result = Conditions.whenNoneOf(false, false, false).isTrue()
                .then(() ->1)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testNoneOfWithIsTrueThenReturnZero() {
        Integer result = Conditions.whenNoneOf(true, false, false).isTrue()
                .then(() ->1)
                .orElse(() ->0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testNoneOfWithIsFalseThenReturnOne() {
        Integer result = Conditions.whenNoneOf(true, true, true).isFalse()
                .then(() ->1)
                .orElse(() ->0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testNoneOfWithIsFalseThenReturnZero() {
        Integer result = Conditions.whenNoneOf(true, true, false).isFalse()
                .then(() ->1)
                .orElse(() ->0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

}
