package org.wotif.core.api.strings;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.wotif.core.api.Conditions.checkIfAnyOf;

public class AnyOfStringConditionalTest {

    @Test
    public void testAnyOfWithContainsThenReturnOne() {
        Integer result = checkIfAnyOf("test", "none", "none").contains("est")
                .then(() -> 1)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAnyOfWithContainsThenReturnZero() {
        Integer result = checkIfAnyOf("none", "none", "none").contains("est")
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testAnyOfWithEqualsThenReturnOne() {
        Integer result = checkIfAnyOf("test", "none", "none").isEqualTo("test")
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAnyOfWithEqualsThenReturnZero() {
        Integer result = checkIfAnyOf("none", "none", "none").isEqualTo("test")
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testAnyOfWithIsNullThenReturnOne() {
        Integer result = checkIfAnyOf(null, "string", "string").isNull()
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAnyOfWithIsNullThenReturnZero() {
        Integer result = checkIfAnyOf("string", "string", "string").isNull()
                .then(() -> 1)
                .orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

}
