package org.wotif.core.api.booleans;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.wotif.core.api.Conditions.checkIfAllOf;

public class AllOfBooleanConditionTest {

    @Test
    public void testAllOfWithIsTrueThenReturnOne() {
        Integer result = checkIfAllOf(true, true, true).isTrue()
                .then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAllOfWithIsTrueThenReturnZero() {
        Integer result = checkIfAllOf(true, true, false).isTrue()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testAllOfWithIsFalseThenReturnOne() {
        Integer result = checkIfAllOf(false, false, false).isFalse()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAllOfWithIsFalseThenReturnZero() {
        Integer result = checkIfAllOf(true, false, false).isFalse()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

}
