package org.wotif.core.api.condition.typed.booleans;

import org.wotif.core.api.Completable;
import org.wotif.core.api.condition.ICondition;

public interface IBooleanCondition<R> extends ICondition<Boolean, R> {

    Completable<R> isTrue();

    Completable<R> isFalse();

}
