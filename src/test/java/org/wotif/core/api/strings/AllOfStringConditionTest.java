package org.wotif.core.api.strings;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.wotif.core.api.Conditions.checkIfAllOf;

public class AllOfStringConditionTest {

    @Test
    public void testAllOfWithContainsThenReturnOne() {
        Integer result = checkIfAllOf("test", "test", "test").contains("est")
                .then(() -> 1)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAllOfWithContainsThenReturnZero() {
        Integer result = checkIfAllOf("test", "test", "none").contains("est")
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testAllOfWithEqualsThenReturnOne() {
        Integer result = checkIfAllOf("test", "test", "test").isEqualTo("test")
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAllOfWithEqualsThenReturnZero() {
        Integer result = checkIfAllOf("test", "test", "none").isEqualTo("test")
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testAllOfWithIsNullThenReturnOne() {
        String string = null;
        Integer result = checkIfAllOf(null, null, string).isNull()
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAllOfWithIsNullThenReturnZero() {
        Integer result = checkIfAllOf("test", null, null).isNull()
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

}
