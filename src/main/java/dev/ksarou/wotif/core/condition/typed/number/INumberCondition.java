package dev.ksarou.wotif.core.condition.typed.number;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.typed.IComparableCondition;

public interface INumberCondition<N extends Number & Comparable<N>, R> extends IComparableCondition<N, R> {

    Completable<R> isZero();

    Completable<R> isDifferentFromZero();

    Completable<R> isPositive();

    Completable<R> isNegative();

}
