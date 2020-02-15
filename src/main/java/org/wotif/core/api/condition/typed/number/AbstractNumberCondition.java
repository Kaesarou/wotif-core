package org.wotif.core.api.condition.typed.number;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.typed.ComparableCondition;

public abstract class AbstractNumberCondition<N extends Number & Comparable<N>>
        extends ComparableCondition<N> implements INumberCondition<N, N> {

    protected AbstractNumberCondition(N term) {
        super(term);
    }

    protected abstract N zero();

    @Override
    public CompletableResult<N> isZero() {
        int i = term.value().compareTo(zero());
        return new CompletableResult<>(term, i == 0);
    }

    @Override
    public CompletableResult<N> isDifferentFromZero() {
        int i = term.value().compareTo(zero());
        return new CompletableResult<>(term, i != 0);
    }

    @Override
    public CompletableResult<N> isPositive() {
        int i = term.value().compareTo(zero());
        return new CompletableResult<>(term, i >= 0);
    }

    @Override
    public CompletableResult<N> isNegative() {
        int i = term.value().compareTo(zero());
        return new CompletableResult<>(term, i < 0);
    }

}
