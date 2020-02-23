package dev.ksarou.wotif.core.condition.typed.time;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.typed.IComparableCondition;

public interface ITimeCondition<T extends Comparable<T>, R>
        extends IComparableCondition<T, R> {

    Completable<R> isAfter(String otherAsString);
    Completable<R> isAfter(T other);
    Completable<R> isAfterOrEqualTo(String otherAsString);
    Completable<R> isAfterOrEqualTo(T other);
    Completable<R> isBefore(String otherAsString);
    Completable<R> isBefore(T other);
    Completable<R> isBeforeOrEqualTo(String otherAsString);
    Completable<R> isBeforeOrEqualTo(T other);
}
