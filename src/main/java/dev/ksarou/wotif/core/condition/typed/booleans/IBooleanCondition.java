package dev.ksarou.wotif.core.condition.typed.booleans;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.ICondition;

public interface IBooleanCondition<R> extends ICondition<Boolean, R> {

    Completable<R> isTrue();

    Completable<R> isFalse();

}
