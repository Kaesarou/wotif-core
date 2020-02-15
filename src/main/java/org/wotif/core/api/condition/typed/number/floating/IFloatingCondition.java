package org.wotif.core.api.condition.typed.number.floating;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.typed.number.INumberCondition;

public interface IFloatingCondition<F extends Number & Comparable<F>, R>
        extends INumberCondition<F, R> {

    CompletableResult<R> isCloseTo(Integer expected);

    CompletableResult<R> isNotCloseTo(Integer expected);

    CompletableResult<R> isNumber();

    CompletableResult<R> isNaN();

    CompletableResult<R> isInfinite();

    CompletableResult<R> isFinite();

}
