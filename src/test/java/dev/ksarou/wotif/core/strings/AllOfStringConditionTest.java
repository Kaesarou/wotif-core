package dev.ksarou.wotif.core.strings;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static dev.ksarou.wotif.core.Conditions.whenAllOf;

public class AllOfStringConditionTest {

    @Test
    public void testAllOfWithContainsThenReturnOne() {
        Integer result = whenAllOf("test", "test", "test").contains("est")
                .then(() ->1)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAllOfWithContainsThenReturnZero() {
        Integer result = whenAllOf("test", "test", "none").contains("est")
                .then(() ->1)
                .orElse(() ->0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testAllOfWithEqualsThenReturnOne() {
        Integer result = whenAllOf("test", "test", "test").isEqualTo("test")
                .then(() ->1)
                .orElse(() ->0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAllOfWithEqualsThenReturnZero() {
        Integer result = whenAllOf("test", "test", "none").isEqualTo("test")
                .then(() ->1)
                .orElse(() ->0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testAllOfWithIsNullThenReturnOne() {
        String string = null;
        Integer result = whenAllOf(null, null, string).isNull()
                .then(() ->1)
                .orElse(() ->0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testAllOfWithIsNullThenReturnZero() {
        Integer result = whenAllOf("test", null, null).isNull()
                .then(() ->1)
                .orElse(() ->0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

}
