package org.wotif.core.api.strings;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.wotif.core.api.Conditions.when;
import static org.wotif.core.api.Conditions.whenAllOf;

public class StringConditionTest {

    @Test
    public void returnsOneWithoutExecutions() {
        String variableToTest = "string";
        Integer result = when(variableToTest).contains("ing").then(t -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void returnNullWithoutExecutions() {
        String variableToTest = "string";
        Integer result = when(variableToTest).contains("none").then(t -> 1).end();
        Assertions.assertThat(result).isNull();
    }

    @Test
    public void orElseReturnZeroWithoutExecutions() {
        String variableToTest = "string";
        Integer result = when(variableToTest).contains("none")
                .then(t -> 1)
                .orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void orElseReturnOneWithoutExecutions() {
        String variableToTest = "string";
        Integer result = when(variableToTest).contains("ing")
                .then(t -> 1)
                .orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsEqualToStringThenReturnOne() {
        String variableToTest = "string";
        Integer result = when(variableToTest).isEqualTo("string")
                .then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsEqualToStringThenReturnZero() {
        String variableToTest = "string";
        Integer result = when(variableToTest).isEqualTo("none")
                .then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void ifVariableIsNullThenReturnOne() {
        String variableToTest = null;
        Integer result = when(variableToTest).isNull()
                .then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void ifVariableIsNotNullThenReturnOne() {
        String variableToTest = "string";
        Integer result = when(variableToTest).isNotNull()
                .then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testTwoDifferentValuesWithIsEqualAndContainsThenReturnOne() {
        Integer result = when("string").isEqualTo("string")
                .and(when("none").contains("on"))
                .then(t -> 1)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testDifferentValuesWithIsEqualContainsOrAllOfContainsThenReturnOne() {
        Integer result = when("string").isEqualTo("string")
                .and(when("string").contains("none"))
                .or(whenAllOf("string", "string").contains("ing"))
                .then(t -> 1).orElse(t -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testDifferentValuesWithIsEqualContainsOrAllOfContainsThenReturnZero() {
        Integer result = when("string").isEqualTo("string")
                .and(when("string").contains("none"))
                .or(whenAllOf("none", "string").contains("ing"))
                .then(t -> 1).orElse(t -> 0)
                .end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfVariableContainsThanExecuteMethod() {
        String variable = "string";
        AtomicReference<Boolean> result = new AtomicReference<>(false);
        when(variable).contains("ing").then(() -> {
            result.set(true);
        }).end();
        Assertions.assertThat(result.get()).isTrue();
    }

    @Test
    public void testIfVariableContainsThanDoNotExecuteMethod() {
        String variable = "string";
        AtomicReference<Boolean> result = new AtomicReference<>(null);
        Integer conditionResult = when(variable).contains("none").then(t -> {
            result.set(true);
            return 1;
        })
                .orElse(t -> {
                    result.set(false);
                    return 0;
                }).end();
        Assertions.assertThat(result.get()).isFalse();
        Assertions.assertThat(conditionResult).isEqualTo(0);
    }

    @Test
    public void testIfVariableDoNotContainsThenReturnOne() {
        String variable = "string";
        Integer result = when(variable).notContains("none").then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfVariableIsEmptyThenReturnZero() {
        String variable = "string";
        Integer result = when(variable).isEmpty().then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfVariableIsNotEmptyThenReturnOne() {
        String variable = "string";
        Integer result = when(variable).isNotEmpty().then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
        Assertions.assertThat("r").isInstanceOf(String.class);
    }

    @Test
    public void testIfContainsIgnoringCaseThenReturnOne() {
        String variable = "string";
        Integer result = when(variable).containsIgnoringCase("ING")
                .then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfContainsIgnoringCaseThenReturnZero() {
        String variable = "string";
        Integer result = when(variable).containsIgnoringCase("none")
                .then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsEmptyThenReturnOne() {
        String variable = "";
        Integer result = when(variable).isEmpty().then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsNotEmptyThenReturnZero() {
        String variable = "";
        Integer result = when(variable).isNotEmpty().then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsBetweenThenReturnOne() {
        String variable = "string";
        Integer result = when(variable).isContainedInSubstring("startstringend", "start", "end")
                .then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsBetweenThenReturnZero() {
        String variable = "none";
        Integer result = when(variable).isContainedInSubstring("startstringend", "start", "end")
                .then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsBetweenIgnoringCaseThenReturnOne() {
        String variable = "strIng";
        Integer result = when(variable).isContainedInSubstringIgnoreCase("startstringend", "START", "END")
                .then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsNotBetweenThenReturnOne() {
        String variable = "string";
        Integer result = when(variable).isNotContainedInSubstring("string", "start", "end")
                .then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsNotBetweenIgnoringCaseThenReturnZero() {
        String variable = "strIng";
        Integer result = when(variable).isNotContainedInSubstringIgnoreCase("startstringend", "START", "END")
                .then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsEqualIgnoringCaseThenReturnOne() {
        String variable = "strIng";
        Integer result = when(variable).isEqualToIgnoringCase("string").then(t -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsDifferentFromThenReturnZero() {
        String variable = "strIng";
        Integer result = when(variable).isDifferentFromIgnoringCase("string").then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsBlankThenReturnOne() {
        String value = "   ";
        Integer result = when(value).isBlank().then(t -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsNotBlankThenReturnOne() {
        String value = "test";
        Integer result = when(value).isNotBlank().then(t -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsInstanceOfThenReturnOne() {
        String value = "test";
        Integer result = when(value).isInstanceOf(String.class).then(t -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsInstanceOfThenReturnZero() {
        String value = "test";
        Integer result = when(value).isInstanceOf(Integer.class)
                .then(t -> 1)
                .orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsNotInstanceOfThenReturnOne() {
        String value = "test";
        Integer result = when(value).isNotInstanceOf(Integer.class).then(t -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsNotInstanceOfThenReturnZero() {
        String value = "test";
        Integer result = when(value).isNotInstanceOf(String.class).then(t -> 1).orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfContainedInThenReturnOne() {
        String value = "test";
        Integer result = when(value).isContainedIn("abctestabc").then(t -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfContainedInThenReturnZero() {
        String value = "test";
        Integer result = when(value).isContainedIn("abcabc").then(t -> 1)
                .orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfContainedInIgnoreCaseThenReturnOne() {
        String value = "TEST";
        Integer result = when(value).isContainedInIgnoreCase("abctestabc").then(t -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfContainedInIgnoreCaseThenReturnZero() {
        String value = "test";
        Integer result = when(value).isContainedInIgnoreCase("abcabc").then(t -> 1)
                .orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfNotContainedInThenReturnOne() {
        String value = "test";
        Integer result = when(value).isNotContainedIn("abcabc").then(t -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfNotContainedInThenReturnZero() {
        String value = "test";
        Integer result = when(value).isNotContainedIn("abctestabc").then(t -> 1)
                .orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfNotContainedInIgnoreCaseThenReturnOne() {
        String value = "TEST";
        Integer result = when(value).isNotContainedInIgnoreCase("abcabc").then(t -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfNotContainedInIgnoreCaseThenReturnZero() {
        String value = "test";
        Integer result = when(value).isNotContainedInIgnoreCase("abcTESTabc").then(t -> 1)
                .orElse(t -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testOrElseTestWithExpectedReturn1() {
        Integer result = when("montest").isEqualTo("montest")
                .then(t -> 1).orElse(when("mo").contains("o"), t -> 2)
                .orElse(t -> 3).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testOrElseTestWithExpectedReturn2() {
        Integer result = when("montest").isEqualTo("test")
                .then(t -> 1).orElse(when("mo").contains("o"), t -> 2)
                .orElse(t -> 3).end();
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    public void testOrElseTestWithExpectedReturn3() {
        Integer result = when("montest").isEqualTo("test")
                .then(t -> 1).orElse(when("mo").contains("ing"), t -> 2)
                .orElse(t -> 3).end();
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    public void testOrElseWithCallbackThenReturn1() {
        AtomicReference<Integer> result = new AtomicReference<>(0);
        when("monTest").contains("ing").then(() -> result.set(1))
                .orElse(when("monTest").isEqualTo("monTest").and(when("A").isEmpty()), () -> result.set(2))
                .orElse(when("monTest").isEqualTo("monTest").and(when("A").isNotEmpty()), () -> result.set(3))
                .end();
        Assertions.assertThat(result.get()).isEqualTo(3);
    }

    @Test
    public void testOrElseWithCallbackThenReturn0() {
        AtomicReference<Integer> result = new AtomicReference<>(0);
        when("monTest").contains("ing").then(() -> result.set(1))
                .orElse(when("monTest").isEqualTo("monTest").and(when("A").isEmpty()), () -> result.set(2))
                .orElse(when("monTest").isEqualTo("monTest").and(when("").isNotEmpty()), () -> result.set(3))
                .end();
        Assertions.assertThat(result.get()).isEqualTo(0);
    }

    @Test
    public void testOrElseWithCallbackThenReturn2() {
        AtomicReference<Integer> result = new AtomicReference<>(0);
        when("monTest").contains("ing").then(() -> result.set(1))
                .orElse(when("monTest").isEqualTo("monTest").and(when("").isEmpty()), () -> result.set(2))
                .orElse(when("monTest").isEqualTo("monTest").and(when("").isNotEmpty()), () -> result.set(3))
                .end();
        Assertions.assertThat(result.get()).isEqualTo(2);
    }

    @Test
    public void testIfHasSameClassHasWithNullValue() {
        Integer result = when("montest").hasSameClassAs("null")
                .then(t -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

}
