package org.wotif.core.api.condition.typed.booleans;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.ICondition;

public interface IBooleanCondition<R> extends ICondition<Boolean, R> {

    CompletableResult<R> isTrue();

    CompletableResult<R> isFalse();

}
