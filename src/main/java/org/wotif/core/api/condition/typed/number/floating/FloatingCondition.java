package org.wotif.core.api.condition.typed.number.floating;

import org.wotif.core.api.CompletableResult;
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
    public CompletableResult<F> isCloseTo(Integer expected) {
        long converted = Long.valueOf(expected);
        boolean value = round() == converted;
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<F> isNotCloseTo(Integer expected) {
        long converted = Long.valueOf(expected);
        boolean value = round() != converted;
        return new CompletableResult<>(term, value);
    }
}
