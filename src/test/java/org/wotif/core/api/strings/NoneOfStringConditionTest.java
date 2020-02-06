package org.wotif.core.api.strings;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.wotif.core.api.Conditions.checkIfNoneOf;

public class NoneOfStringConditionTest {

    @Test
    public void testNoneOfWithContainsThenReturnOne() {
        Integer result = checkIfNoneOf("none", "none", "none").contains("est")
                .then(() -> 1)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testNoneOfWithContainsThenReturnZero() {
        Integer result = checkIfNoneOf("test", "none", "none").contains("est")
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testNoneOfWithEqualsThenReturnOne() {
        Integer result = checkIfNoneOf("none", "none", "none").isEqualTo("test")
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testNoneOfWithEqualsThenReturnZero() {
        Integer result = checkIfNoneOf("test", "none", "none").isEqualTo("test")
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testNoneOfWithIsNullThenReturnOne() {
        Integer result = checkIfNoneOf("string", "string", "string").isNull()
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testNoneOfWithIsNullThenReturnZero() {
        Integer result = checkIfNoneOf(null, "string", "string").isNull()
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

}
