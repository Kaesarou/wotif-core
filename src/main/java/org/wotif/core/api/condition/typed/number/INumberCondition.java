package org.wotif.core.api.condition.typed.number;

import org.wotif.core.api.Completable;
import org.wotif.core.api.condition.typed.IComparableCondition;

public interface INumberCondition<N extends Number & Comparable<N>, R> extends IComparableCondition<N, R> {

    Completable<R> isZero();

    Completable<R> isDifferentFromZero();

    Completable<R> isPositive();

    Completable<R> isNegative();

}
