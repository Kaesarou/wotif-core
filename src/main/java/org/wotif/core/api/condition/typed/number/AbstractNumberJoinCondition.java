package org.wotif.core.api.condition.typed.number;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.JoinEnum;
import org.wotif.core.api.condition.typed.ComparableJoinCondition;

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
    public CompletableResult<List<N>> isZero() {
        return this.functionToApply.apply(AbstractNumberCondition::isZero);
    }

    @Override
    public CompletableResult<List<N>> isDifferentFromZero() {
        return this.functionToApply.apply(AbstractNumberCondition::isDifferentFromZero);
    }

    @Override
    public CompletableResult<List<N>> isPositive() {
        return this.functionToApply.apply(AbstractNumberCondition::isPositive);
    }

    @Override
    public CompletableResult<List<N>> isNegative() {
        return this.functionToApply.apply(AbstractNumberCondition::isNegative);
    }

}
