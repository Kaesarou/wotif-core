package org.wotif.core.api.condition.typed;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.ICondition;

public interface IComparableCondition<T extends Comparable<T>, R>
        extends ICondition<T, R> {

    CompletableResult<R> isLessThen(T termToCompare);

    CompletableResult<R> isGreaterThen(T termToCompare);

    CompletableResult<R> isBetween(T start, T end);

    CompletableResult<R> isNotBetween(T start, T end);

    CompletableResult<R> isStrictlyBetween(T start, T end);

    @Override
    CompletableResult<R> isEqualTo(T expected);

    @Override
    CompletableResult<R> isDifferentFrom(T expected);

}
