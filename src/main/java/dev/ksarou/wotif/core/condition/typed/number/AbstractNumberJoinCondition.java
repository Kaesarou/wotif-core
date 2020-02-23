package dev.ksarou.wotif.core.condition.typed.number;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.ComparableJoinCondition;
import dev.ksarou.wotif.core.Completable;

import java.util.List;

public abstract class AbstractNumberJoinCondition<N extends Number & Comparable<N>, C extends AbstractNumberCondition<N>>
        extends ComparableJoinCondition<N, C> implements INumberCondition<N, List<N>> {

    @SafeVarargs
    public AbstractNumberJoinCondition(JoinEnum joinType, N... terms) {
        super(joinType, terms);
    }

    @Override
    protected abstract C getInstanceOfCondition(N term);

    @Override
    public Completable<List<N>> isZero() {
        return this.functionToApply.apply(AbstractNumberCondition::isZero);
    }

    @Override
    public Completable<List<N>> isDifferentFromZero() {
        return this.functionToApply.apply(AbstractNumberCondition::isDifferentFromZero);
    }

    @Override
    public Completable<List<N>> isPositive() {
        return this.functionToApply.apply(AbstractNumberCondition::isPositive);
    }

    @Override
    public Completable<List<N>> isNegative() {
        return this.functionToApply.apply(AbstractNumberCondition::isNegative);
    }

}
