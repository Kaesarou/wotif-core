package org.wotif.core.api.condition.typed.number.floating.doubles;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.typed.number.floating.FloatingCondition;
import org.wotif.core.api.condition.typed.number.floating.IFloatingCondition;

public class DoubleCondition extends FloatingCondition<Double> implements IFloatingCondition<Double, Double> {

    public DoubleCondition(Double term) {
        super(term);
    }

    @Override
    protected Double zero() {
        return (double) 0;
    }

    @Override
    public long round() {
        return Math.round(this.term.value());
    }

    @Override
    public CompletableResult<Double> isNumber() {
        return new CompletableResult<>(term, !this.term.value().isNaN());
    }

    @Override
    public CompletableResult<Double> isNaN() {
        return new CompletableResult<>(term, this.term.value().isNaN());
    }

    @Override
    public CompletableResult<Double> isInfinite() {
        return new CompletableResult<>(term, this.term.value().isInfinite());
    }

    @Override
    public CompletableResult<Double> isFinite() {
        return new CompletableResult<>(term, !this.term.value().isInfinite());
    }
}
