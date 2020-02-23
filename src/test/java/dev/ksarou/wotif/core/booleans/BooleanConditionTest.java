package dev.ksarou.wotif.core.booleans;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static dev.ksarou.wotif.core.Conditions.when;
import static dev.ksarou.wotif.core.Conditions.whenAllOf;

public class BooleanConditionTest {

    @Test
    public void returnsOneWithoutExecutions() {
        boolean variableToTest = true;
        Integer result = when(variableToTest).isTrue().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void returnNullWithoutExecutions() {
        boolean variableToTest = false;
        Integer result = when(variableToTest).isTrue().then(() -> 1).end();
        Assertions.assertThat(result).isNull();
    }

    @Test
    public void orElseReturnZeroWithoutExecutions() {
        boolean variableToTest = false;
        Integer result = when(variableToTest).isTrue()
                .then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void orElseReturnOneWithoutExecutions() {
        boolean variableToTest = true;
        Integer result = when(variableToTest).isTrue()
                .then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifIsFalseThenReturnOne() {
        boolean variableToTest = false;
        Integer result = when(variableToTest).isFalse()
                .then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifIsFalseThenReturnZero() {
        boolean variableToTest = false;
        Integer result = when(variableToTest).isFalse()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsEqualToTrueThenReturnOne() {
        boolean variableToTest = true;
        Integer result = when(variableToTest).isEqualTo(true)
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsEqualToTrueThenReturnZero() {
        boolean variableToTest = true;
        Integer result = when(variableToTest).isEqualTo(false)
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void ifVariableIsNotEqualToTrueThenReturnZero() {
        boolean variableToTest = true;
        Integer result = when(variableToTest).isDifferentFrom(false)
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsNullThenReturnOne() {
        Boolean variableToTest = null;
        Integer result = when(variableToTest).isNull()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsNotNullThenReturnOne() {
        boolean variableToTest = true;
        Integer result = when(variableToTest).isNotNull()
                .then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testTwoDifferentValuesWithIsTrueAndIsFalseThenReturnOne() {
        Integer result = when(true).isTrue()
                .and(when(false).isFalse())
                .then(() -> 1)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testDifferentValuesWithIsTrueIsFalseOrAllOfIsTrueThenReturnOne() {
        Integer result = when(false).isTrue()
                .and(when(true).isFalse())
                .or(whenAllOf(true, true).isTrue())
                .then(() -> 1).orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testDifferentValuesWithIsTrueIsFalseOrAllOfIsTrueThenReturnZero() {
        Integer result = when(false).isTrue()
                .and(when(false).isFalse())
                .or(whenAllOf(false, true).isTrue())
                .then(() -> 1).orElse(() -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfVariableIsTrueThanExecuteMethod() {
        Boolean variable = true;
        AtomicReference<Boolean> result = new AtomicReference<>(false);
        when(variable).isTrue().then(() -> result.set(true)).end();
        Assertions.assertThat(result.get()).isTrue();
    }

    @Test
    public void testIfVariableIsTrueThanDoNotExecuteMethod() {
        Boolean variable = false;
        AtomicReference<Boolean> result = new AtomicReference<>(null);
        when(variable).isTrue().then(() -> result.set(true)).orElse(() -> result.set(false)).end();
        Assertions.assertThat(result.get()).isFalse();
    }

}
