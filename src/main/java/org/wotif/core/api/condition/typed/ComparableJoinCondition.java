package org.wotif.core.api.condition.typed;

import org.wotif.core.api.Completable;
import org.wotif.core.api.condition.AbstractJoinCondition;
import org.wotif.core.api.condition.JoinEnum;

import java.util.List;

public abstract class ComparableJoinCondition<T extends Comparable<T>, C extends ComparableCondition<T>>
        extends AbstractJoinCondition<T, C>
        implements IComparableCondition<T, List<T>> {

    @SafeVarargs
    public ComparableJoinCondition(JoinEnum joinType, T... terms) {
        super(joinType, terms);
    }

    @Override
    protected abstract C getInstanceOfCondition(T term);

    @Override
    public Completable<List<T>> isLessThen(T termToCompare) {
        return this.functionToApply.apply(n -> n.isLessThen(termToCompare));
    }

    @Override
    public Completable<List<T>> isGreaterThen(T termToCompare) {
        return this.functionToApply.apply(n -> n.isGreaterThen(termToCompare));
    }

    @Override
    public Completable<List<T>> isEqualTo(T expected) {
        return this.functionToApply.apply(n -> n.isEqualTo(expected));
    }

    @Override
    public Completable<List<T>> isDifferentFrom(T expected) {
        return this.functionToApply.apply(n -> n.isDifferentFrom(expected));
    }

    @Override
    public Completable<List<T>> isBetween(T start, T end) {
        return this.functionToApply.apply(n -> n.isBetween(start, end));
    }

    @Override
    public Completable<List<T>> isNotBetween(T start, T end) {
        return this.functionToApply.apply(n -> n.isNotBetween(start, end));
    }

    @Override
    public Completable<List<T>> isStrictlyBetween(T start, T end) {
        return this.functionToApply.apply(n -> n.isStrictlyBetween(start, end));
    }

}
