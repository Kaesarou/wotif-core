package dev.ksarou.wotif.core.condition.typed.number.floating;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.typed.number.INumberCondition;

public interface IFloatingCondition<F extends Number & Comparable<F>, R>
        extends INumberCondition<F, R> {

    Completable<R> isCloseTo(Integer expected);

    Completable<R> isNotCloseTo(Integer expected);

    Completable<R> isNumber();

    Completable<R> isNaN();

    Completable<R> isInfinite();

    Completable<R> isFinite();

}
