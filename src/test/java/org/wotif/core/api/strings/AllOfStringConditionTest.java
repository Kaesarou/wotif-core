package org.wotif.core.api.strings;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.wotif.core.api.Conditions.whenAllOf;

public class AllOfStringConditionTest {

    @Test
    public void testAllOfWithContainsThenReturnOne() {
        Integer result = whenAllOf("test", "test", "test").contains("est")
                .then(t ->1)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAllOfWithContainsThenReturnZero() {
        Integer result = whenAllOf("test", "test", "none").contains("est")
                .then(t ->1)
                .orElse(t ->0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testAllOfWithEqualsThenReturnOne() {
        Integer result = whenAllOf("test", "test", "test").isEqualTo("test")
                .then(t ->1)
                .orElse(t ->0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAllOfWithEqualsThenReturnZero() {
        Integer result = whenAllOf("test", "test", "none").isEqualTo("test")
                .then(t ->1)
                .orElse(t ->0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testAllOfWithIsNullThenReturnOne() {
        String string = null;
        Integer result = whenAllOf(null, null, string).isNull()
                .then(t ->1)
                .orElse(t ->0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAllOfWithIsNullThenReturnZero() {
        Integer result = whenAllOf("test", null, null).isNull()
                .then(t ->1)
                .orElse(t ->0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

}
