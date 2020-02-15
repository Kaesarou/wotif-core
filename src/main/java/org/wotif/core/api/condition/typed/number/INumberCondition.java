package org.wotif.core.api.condition.typed.number;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.typed.IComparableCondition;

public interface INumberCondition<N extends Number & Comparable<N>, R> extends IComparableCondition<N, R> {

    CompletableResult<R> isZero();

    CompletableResult<R> isDifferentFromZero();

    CompletableResult<R> isPositive();

    CompletableResult<R> isNegative();

}
