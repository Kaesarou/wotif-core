package org.wotif.core.api.condition.typed.number.floating.floats;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.typed.number.floating.FloatingCondition;
import org.wotif.core.api.condition.typed.number.floating.IFloatingCondition;

public class FloatCondition extends FloatingCondition<Float> implements IFloatingCondition<Float, Float> {

    public FloatCondition(Float term) {
        super(term);
    }

    @Override
    protected Float zero() {
        return (float) 0;
    }

    @Override
    public long round() {
        return Math.round(this.term.value());
    }

    @Override
    public CompletableResult<Float> isNumber() {
        return new CompletableResult<>(term, !this.term.value().isNaN());
    }

    @Override
    public CompletableResult<Float> isNaN() {
        return new CompletableResult<>(term, this.term.value().isNaN());
    }

    @Override
    public CompletableResult<Float> isInfinite() {
        return new CompletableResult<>(term, this.term.value().isInfinite());
    }

    @Override
    public CompletableResult<Float> isFinite() {
        return new CompletableResult<>(term, !this.term.value().isInfinite());
    }

}
