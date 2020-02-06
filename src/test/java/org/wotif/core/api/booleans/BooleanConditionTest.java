package org.wotif.core.api.booleans;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.wotif.core.api.Conditions.checkIf;
import static org.wotif.core.api.Conditions.checkIfAllOf;

public class BooleanConditionTest {

    @Test
    public void returnsOneWithoutExecutions() {
        boolean variableToTest = true;
        Integer result = checkIf(variableToTest).isTrue().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void returnNullWithoutExecutions() {
        boolean variableToTest = false;
        Integer result = checkIf(variableToTest).isTrue().then(() -> 1).end();
        Assertions.assertThat(result).isNull();
    }

    @Test
    public void orElseReturnZeroWithoutExecutions() {
        boolean variableToTest = false;
        Integer result = checkIf(variableToTest).isTrue()
                .then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void orElseReturnOneWithoutExecutions() {
        boolean variableToTest = true;
        Integer result = checkIf(variableToTest).isTrue()
                .then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifIsFalseThenReturnOne() {
        boolean variableToTest = false;
        Integer result = checkIf(variableToTest).isFalse()
                .then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifIsFalseThenReturnZero() {
        boolean variableToTest = false;
        Integer result = checkIf(variableToTest).isFalse()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsEqualToTrueThenReturnOne() {
        boolean variableToTest = true;
        Integer result = checkIf(variableToTest).isEqualTo(true)
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsEqualToTrueThenReturnZero() {
        boolean variableToTest = true;
        Integer result = checkIf(variableToTest).isEqualTo(false)
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void ifVariableIsNotEqualToTrueThenReturnZero() {
        boolean variableToTest = true;
        Integer result = checkIf(variableToTest).isDifferentFrom(false)
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsNullThenReturnOne() {
        Boolean variableToTest = null;
        Integer result = checkIf(variableToTest).isNull()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsNotNullThenReturnOne() {
        boolean variableToTest = true;
        Integer result = checkIf(variableToTest).isNotNull()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testTwoDifferentValuesWithIsTrueAndIsFalseThenReturnOne() {
        Integer result = checkIf(true).isTrue()
                .and(checkIf(false).isFalse())
                .then(() -> 1)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testDifferentValuesWithIsTrueIsFalseOrAllOfIsTrueThenReturnOne() {
        Integer result = checkIf(false).isTrue()
                .and(checkIf(true).isFalse())
                .or(checkIfAllOf(true, true).isTrue())
                .then(() -> 1).orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testDifferentValuesWithIsTrueIsFalseOrAllOfIsTrueThenReturnZero() {
        Integer result = checkIf(false).isTrue()
                .and(checkIf(false).isFalse())
                .or(checkIfAllOf(false, true).isTrue())
                .then(() -> 1).orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfVariableIsTrueThanExecuteMethod() {
        Boolean variable = true;
        AtomicReference<Boolean> result = new AtomicReference<>(false);
        checkIf(variable).isTrue().then(() -> result.set(true)).end();
        Assertions.assertThat(result.get()).isTrue();
    }

    @Test
    public void testIfVariableIsTrueThanDoNotExecuteMethod() {
        Boolean variable = false;
        AtomicReference<Boolean> result = new AtomicReference<>(null);
        checkIf(variable).isTrue().then(() -> result.set(true)).orElse(() -> result.set(false)).end();
        Assertions.assertThat(result.get()).isFalse();
    }

}
