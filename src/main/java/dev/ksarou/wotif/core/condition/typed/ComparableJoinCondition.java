package dev.ksarou.wotif.core.condition.typed;

import dev.ksarou.wotif.core.condition.AbstractJoinCondition;
import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.Completable;

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
