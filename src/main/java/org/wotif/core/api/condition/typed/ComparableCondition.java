package org.wotif.core.api.condition.typed;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.AbstractCondition;

public abstract class ComparableCondition<T extends Comparable<T>>
        extends AbstractCondition<T> implements IComparableCondition<T, T> {

    public ComparableCondition(T term) {
        super(term);
    }

    @Override
    public CompletableResult<T> isLessThen(T termToCompare) {
        int i = term.value().compareTo(termToCompare);
        return new CompletableResult<>(term, i < 0);
    }

    @Override
    public CompletableResult<T> isGreaterThen(T termToCompare) {
        int i = term.value().compareTo(termToCompare);
        return new CompletableResult<>(term, i > 0);
    }

    @Override
    public CompletableResult<T> isEqualTo(T expected) {
        int i = term.value().compareTo(expected);
        return new CompletableResult<>(term, i == 0);
    }

    @Override
    public CompletableResult<T> isDifferentFrom(T expected) {
        int i = term.value().compareTo(expected);
        return new CompletableResult<>(term, i != 0);
    }

    @Override
    public CompletableResult<T> isBetween(T start, T end) {
        int i = term.value().compareTo(start);
        int j = term.value().compareTo(end);
        return new CompletableResult<>(term, i >= 0 && j <= 0);
    }

    @Override
    public CompletableResult<T> isNotBetween(T start, T end) {
        int i = term.value().compareTo(start);
        int j = term.value().compareTo(end);
        return new CompletableResult<>(term, i < 0 || j > 0);
    }

    @Override
    public CompletableResult<T> isStrictlyBetween(T start, T end) {
        int i = term.value().compareTo(start);
        int j = term.value().compareTo(end);
        return new CompletableResult<>(term, i > 0 && j < 0);
    }

}
