package dev.ksarou.wotif.core.numbers;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static dev.ksarou.wotif.core.Conditions.when;


public class NumberConditionTest {

    @Test
    public void testIfZeroIsPositiveThenReturnOne() {
        Integer result = when(0).isPositive().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfValueIsPositiveThenReturnOne() {
        Integer result = when(1).isPositive().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfValueIsPositiveThenReturnZero() {
        Integer result = when(-1).isPositive().then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfValueIsNegativeThenReturnOne() {
        Integer result = when(-1).isNegative().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfValueIsNegativeThenReturnZero() {
        Integer result = when(1).isNegative().then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfZeroThenReturnOne() {
        Integer result = when(0).isZero().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfNotZeroThenReturnOne() {
        Integer result = when(1).isDifferentFromZero().then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfNotZeroThenReturnZero() {
        Integer result = when(0).isDifferentFromZero().then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsLessThenReturnOne() {
        Integer result = when(5).isLessThen(10).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsLessThenReturnZero() {
        Integer result = when(10).isLessThen(10).then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsEqualToThenReturnOne() {
        Integer result = when(10).isEqualTo(10).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsDifferentFromThenReturnZero() {
        Integer result = when(10).isDifferentFrom(10).then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsGreaterThenReturnOne() {
        Integer result = when(10).isGreaterThen(5).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsBetween3And9ThenReturnOne() {
        Integer result = when(5).isBetween(3, 9).then(() -> 1).end();
        Integer secondResult = when(3).isBetween(3, 9).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
        Assertions.assertThat(secondResult).isEqualTo(1);
    }

    @Test
    public void testIfIsBetween3And9ThenReturnZero() {
        Integer result = when(11).isBetween(3, 9).then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsNotBetween3And9ThenReturnOne() {
        Integer result = when(11).isNotBetween(3, 9).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsNotBetween3And9ThenReturnZero() {
        Integer result = when(4).isNotBetween(3, 9).then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsStrictlyBetween3And9ThenReturnOne() {
        Integer result = when(5).isStrictlyBetween(3, 9).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsStrictlyBetween3And9ThenReturnZero() {
        Integer result = when(3).isStrictlyBetween(3, 9).then(() -> 1).orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);

    }

    @Test
    public void testIfIsCloseThenReturnOne() {
        Integer result = when(3.6).isCloseTo(4).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsCloseThenReturnZero() {
        Integer result = when(3.4).isCloseTo(4).then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfIsNotCloseThenReturnOne() {
        Integer result = when(3.4).isNotCloseTo(4).then(() -> 1).end();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void testIfIsNotCloseThenReturnZero() {
        Integer result = when(3.6).isNotCloseTo(4).then(() -> 1)
                .orElse(() -> 0).end();
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void testIfFloatIsNaNExpectedResult1() {
        AtomicReference<Integer> result = new AtomicReference<>(0);
        when(2.0 % 0).isNaN().then(() -> result.set(1)).end();
        Assertions.assertThat(result.get()).isEqualTo(1);
    }

    @Test
    public void testIfFloatIsInfinitePositiveExpectedResult1() {
        AtomicReference<Integer> result = new AtomicReference<>(0);
        when(Float.POSITIVE_INFINITY).isInfinite().then(() -> result.set(1)).end();
        Assertions.assertThat(result.get()).isEqualTo(1);
    }

    @Test
    public void testIfFloatIsInfiniteNegativeExpectedResult1() {
        AtomicReference<Integer> result = new AtomicReference<>(0);
        when(Float.NEGATIVE_INFINITY).isInfinite().then(() -> result.set(1)).end();
        Assertions.assertThat(result.get()).isEqualTo(1);
    }

    @Test
    public void testIfFloatIsInfiniteExpectedResultNull() {
        AtomicReference<Integer> result = new AtomicReference<>(null);
        when(Float.POSITIVE_INFINITY).isFinite().then(() -> result.set(1)).end();
        Assertions.assertThat(result.get()).isNull();
    }

}
