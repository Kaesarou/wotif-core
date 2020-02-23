package dev.ksarou.wotif.core.condition.typed;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.ICondition;

public interface IComparableCondition<T extends Comparable<T>, R>
        extends ICondition<T, R> {

    Completable<R> isLessThen(T termToCompare);

    Completable<R> isGreaterThen(T termToCompare);

    Completable<R> isBetween(T start, T end);

    Completable<R> isNotBetween(T start, T end);

    Completable<R> isStrictlyBetween(T start, T end);

    @Override
    Completable<R> isEqualTo(T expected);

    @Override
    Completable<R> isDifferentFrom(T expected);

}
