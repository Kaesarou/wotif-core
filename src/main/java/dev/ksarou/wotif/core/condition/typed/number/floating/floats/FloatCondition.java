package dev.ksarou.wotif.core.condition.typed.number.floating.floats;

import dev.ksarou.wotif.core.condition.typed.number.floating.IFloatingCondition;
import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.typed.number.floating.FloatingCondition;

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
    public Completable<Float> isNumber() {
        return new Completable<>(term, !this.term.value().isNaN());
    }

    @Override
    public Completable<Float> isNaN() {
        return new Completable<>(term, this.term.value().isNaN());
    }

    @Override
    public Completable<Float> isInfinite() {
        return new Completable<>(term, this.term.value().isInfinite());
    }

    @Override
    public Completable<Float> isFinite() {
        return new Completable<>(term, !this.term.value().isInfinite());
    }

}
