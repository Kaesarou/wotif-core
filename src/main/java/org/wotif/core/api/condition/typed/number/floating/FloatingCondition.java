package org.wotif.core.api.condition.typed.number.floating;

import org.wotif.core.api.Completable;
import org.wotif.core.api.condition.typed.number.AbstractNumberCondition;

public abstract class FloatingCondition<F extends Number & Comparable<F>>
        extends AbstractNumberCondition<F> implements IFloatingCondition<F, F> {

    public FloatingCondition(F term) {
        super(term);
    }

    protected abstract long round();

    @Override
    protected abstract F zero();

    @Override
    public Completable<F> isCloseTo(Integer expected) {
        long converted = Long.valueOf(expected);
        boolean value = round() == converted;
        return new Completable<>(term, value);
    }

    @Override
    public Completable<F> isNotCloseTo(Integer expected) {
        long converted = Long.valueOf(expected);
        boolean value = round() != converted;
        return new Completable<>(term, value);
    }
}
