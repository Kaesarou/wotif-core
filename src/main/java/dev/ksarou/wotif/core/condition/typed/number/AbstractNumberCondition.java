package dev.ksarou.wotif.core.condition.typed.number;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.typed.ComparableCondition;

public abstract class AbstractNumberCondition<N extends Number & Comparable<N>>
        extends ComparableCondition<N> implements INumberCondition<N, N> {

    protected AbstractNumberCondition(N term) {
        super(term);
    }

    protected abstract N zero();

    @Override
    public Completable<N> isZero() {
        int i = term.value().compareTo(zero());
        return new Completable<>(term, i == 0);
    }

    @Override
    public Completable<N> isDifferentFromZero() {
        int i = term.value().compareTo(zero());
        return new Completable<>(term, i != 0);
    }

    @Override
    public Completable<N> isPositive() {
        int i = term.value().compareTo(zero());
        return new Completable<>(term, i >= 0);
    }

    @Override
    public Completable<N> isNegative() {
        int i = term.value().compareTo(zero());
        return new Completable<>(term, i < 0);
    }

}
