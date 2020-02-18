package org.wotif.core.api.condition.typed.number.floating;

import org.wotif.core.api.Completable;
import org.wotif.core.api.condition.typed.number.INumberCondition;

public interface IFloatingCondition<F extends Number & Comparable<F>, R>
        extends INumberCondition<F, R> {

    Completable<R> isCloseTo(Integer expected);

    Completable<R> isNotCloseTo(Integer expected);

    Completable<R> isNumber();

    Completable<R> isNaN();

    Completable<R> isInfinite();

    Completable<R> isFinite();

}
