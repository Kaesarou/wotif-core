package org.wotif.core.api.booleans;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.wotif.core.api.Conditions.whenAnyOf;

public class AnyOfBooleanConditionalTest {

    @Test
    public void ifAnyOfThisBooleansIsTrueReturnOne() {
        Integer result = whenAnyOf(false, true, false, false).isTrue().then(t ->1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifAnyOfThisBooleansIsTrueReturnOneExpectedZero() {
        Integer result = whenAnyOf(false, false, false, false).isTrue()
                .then(t ->1)
                .orElse(t ->0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void orElseReturnZeroWithoutExecutionsExpectedOne() {
        Integer result = whenAnyOf(false, false, true, false).isTrue()
                .then(t ->1)
                .orElse(t ->0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifIsFalseThenReturnOne() {
        Integer result = whenAnyOf(true, true, false).isFalse()
                .then(t ->1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifIsFalseThenReturnOneElseZeroExpectedOne() {
        Integer result = whenAnyOf(true, true, false).isFalse()
                .then(t ->1).orElse(t ->0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsEqualToTrueThenReturnOne() {
        Integer result = whenAnyOf(false, false, true).isEqualTo(true)
                .then(t ->1).orElse(t ->0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsEqualToTrueThenReturnZero() {
        Integer result = whenAnyOf(true, true, true).isEqualTo(false)
                .then(t ->1).orElse(t ->0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void ifVariableIsNotEqualToTrueThenReturnZero() {
        Integer result = whenAnyOf(false, false, true).isDifferentFrom(false)
                .then(t ->1).orElse(t ->0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsNullThenReturnOne() {
        Integer result = whenAnyOf(null, false, false).isNull()
                .then(t ->1).orElse(t ->0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsNotNullThenReturnOne() {
        Integer result = whenAnyOf(null, null, true).isNotNull()
                .then(t ->1).orElse(t ->0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

}
