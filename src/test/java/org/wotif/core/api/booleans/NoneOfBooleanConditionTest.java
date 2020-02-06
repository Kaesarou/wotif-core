package org.wotif.core.api.booleans;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.wotif.core.api.Conditions.checkIfNoneOf;

public class NoneOfBooleanConditionTest {

    @Test
    public void testNoneOfWithIsTrueThenReturnOne() {
        Integer result = checkIfNoneOf(false, false, false).isTrue()
                .then(() -> 1)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testNoneOfWithIsTrueThenReturnZero() {
        Integer result = checkIfNoneOf(true, false, false).isTrue()
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testNoneOfWithIsFalseThenReturnOne() {
        Integer result = checkIfNoneOf(true, true, true).isFalse()
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testNoneOfWithIsFalseThenReturnZero() {
        Integer result = checkIfNoneOf(true, true, false).isFalse()
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

}
