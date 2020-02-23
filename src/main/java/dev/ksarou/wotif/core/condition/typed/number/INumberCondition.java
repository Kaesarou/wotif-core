package dev.ksarou.wotif.core.condition.typed.number;

import dev.ksarou.wotif.core.condition.typed.IComparableCondition;
import dev.ksarou.wotif.core.Completable;

public interface INumberCondition<N extends Number & Comparable<N>, R> extends IComparableCondition<N, R> {

    Completable<R> isZero();

    Completable<R> isDifferentFromZero();

    Completable<R> isPositive();

    Completable<R> isNegative();

}
