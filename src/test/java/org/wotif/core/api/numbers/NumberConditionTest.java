package org.wotif.core.api.numbers;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.wotif.core.api.Conditions.checkIf;


public class NumberConditionTest {

    @Test
    public void testIfZeroIsPositiveThenReturnOne() {
        Integer result = checkIf(0).isPositive().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfValueIsPositiveThenReturnOne() {
        Integer result = checkIf(1).isPositive().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfValueIsPositiveThenReturnZero() {
        Integer result = checkIf(-1).isPositive().then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfValueIsNegativeThenReturnOne() {
        Integer result = checkIf(-1).isNegative().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfValueIsNegativeThenReturnZero() {
        Integer result = checkIf(1).isNegative().then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfZeroThenReturnOne() {
        Integer result = checkIf(0).isZero().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfNotZeroThenReturnOne() {
        Integer result = checkIf(1).isDifferentFromZero().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfNotZeroThenReturnZero() {
        Integer result = checkIf(0).isDifferentFromZero().then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsLessThenReturnOne() {
        Integer result = checkIf(5).isLessThen(10).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsLessThenReturnZero() {
        Integer result = checkIf(10).isLessThen(10).then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsEqualToThenReturnOne() {
        Integer result = checkIf(10).isEqualTo(10).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsDifferentFromThenReturnZero() {
        Integer result = checkIf(10).isDifferentFrom(10).then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsGreaterThenReturnOne() {
        Integer result = checkIf(10).isGreaterThen(5).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsBetween3And9ThenReturnOne() {
        Integer result = checkIf(5).isBetween(3, 9).then(() -> 1).end();
        Integer secondResult = checkIf(3).isBetween(3, 9).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
        Assertions.assertThat(secondResult).isEqualTo(1);
    }

    @Test
    public void testIfIsBetween3And9ThenReturnZero() {
        Integer result = checkIf(11).isBetween(3, 9).then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsNotBetween3And9ThenReturnOne() {
        Integer result = checkIf(11).isNotBetween(3, 9).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsNotBetween3And9ThenReturnZero() {
        Integer result = checkIf(4).isNotBetween(3, 9).then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsStrictlyBetween3And9ThenReturnOne() {
        Integer result = checkIf(5).isStrictlyBetween(3, 9).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsStrictlyBetween3And9ThenReturnZero() {
        Integer result = checkIf(3).isStrictlyBetween(3, 9).then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);

    }

    @Test
    public void testIfIsCloseThenReturnOne() {
        Integer result = checkIf(3.6).isCloseTo(4).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsCloseThenReturnZero() {
        Integer result = checkIf(3.4).isCloseTo(4).then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsNotCloseThenReturnOne() {
        Integer result = checkIf(3.4).isNotCloseTo(4).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsNotCloseThenReturnZero() {
        Integer result = checkIf(3.6).isNotCloseTo(4).then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfFloatIsNaNExpectedResult1() {
        AtomicReference<Integer> result = new AtomicReference<>(0);
        checkIf(2.0 % 0).isNaN().then(() -> result.set(1)).end();
        Assertions.assertThat(result.get()).isEqualTo(1);
    }

    @Test
    public void testIfFloatIsInfinitePositiveExpectedResult1() {
        AtomicReference<Integer> result = new AtomicReference<>(0);
        checkIf(Float.POSITIVE_INFINITY).isInfinite().then(() -> result.set(1)).end();
        Assertions.assertThat(result.get()).isEqualTo(1);
    }

    @Test
    public void testIfFloatIsInfiniteNegativeExpectedResult1() {
        AtomicReference<Integer> result = new AtomicReference<>(0);
        checkIf(Float.NEGATIVE_INFINITY).isInfinite().then(() -> result.set(1)).end();
        Assertions.assertThat(result.get()).isEqualTo(1);
    }

    @Test
    public void testIfFloatIsInfiniteExpectedResultNull() {
        AtomicReference<Integer> result = new AtomicReference<>(null);
        checkIf(Float.POSITIVE_INFINITY).isFinite().then(() -> result.set(1)).end();
        Assertions.assertThat(result.get()).isNull();
    }

}
