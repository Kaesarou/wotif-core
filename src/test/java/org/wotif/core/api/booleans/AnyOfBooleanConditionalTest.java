package org.wotif.core.api.booleans;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.wotif.core.api.Conditions.checkIfAnyOf;

public class AnyOfBooleanConditionalTest {

    @Test
    public void ifAnyOfThisBooleansIsTrueReturnOne() {
        Integer result = checkIfAnyOf(false, true, false, false).isTrue().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifAnyOfThisBooleansIsTrueReturnOneExpectedZero() {
        Integer result = checkIfAnyOf(false, false, false, false).isTrue()
                .then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void orElseReturnZeroWithoutExecutionsExpectedOne() {
        Integer result = checkIfAnyOf(false, false, true, false).isTrue()
                .then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifIsFalseThenReturnOne() {
        Integer result = checkIfAnyOf(true, true, false).isFalse()
                .then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifIsFalseThenReturnOneElseZeroExpectedOne() {
        Integer result = checkIfAnyOf(true, true, false).isFalse()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsEqualToTrueThenReturnOne() {
        Integer result = checkIfAnyOf(false, false, true).isEqualTo(true)
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsEqualToTrueThenReturnZero() {
        Integer result = checkIfAnyOf(true, true, true).isEqualTo(false)
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void ifVariableIsNotEqualToTrueThenReturnZero() {
        Integer result = checkIfAnyOf(false, false, true).isDifferentFrom(false)
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsNullThenReturnOne() {
        Integer result = checkIfAnyOf(null, false, false).isNull()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsNotNullThenReturnOne() {
        Integer result = checkIfAnyOf(null, null, true).isNotNull()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

}
