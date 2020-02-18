package org.wotif.core.api.condition.typed.number.floating;

import org.wotif.core.api.Completable;
import org.wotif.core.api.condition.JoinEnum;
import org.wotif.core.api.condition.typed.number.AbstractNumberJoinCondition;

import java.util.List;

public abstract class FloatingJoinCondition<F extends Number & Comparable<F>>
        extends AbstractNumberJoinCondition<F, FloatingCondition<F>>
        implements IFloatingCondition<F, List<F>> {

    @SafeVarargs
    public FloatingJoinCondition(JoinEnum joinType, F... terms) {
        super(joinType, terms);
    }

    @Override
    public Completable<List<F>> isCloseTo(Integer expected) {
        return this.functionToApply.apply(n -> n.isCloseTo(expected));
    }

    @Override
    public Completable<List<F>> isNotCloseTo(Integer expected) {
        return this.functionToApply.apply(n -> n.isNotCloseTo(expected));
    }

    @Override
    public Completable<List<F>> isNumber() {
        return this.functionToApply.apply(IFloatingCondition::isNumber);
    }

    @Override
    public Completable<List<F>> isNaN() {
        return this.functionToApply.apply(IFloatingCondition::isNaN);
    }

    @Override
    public Completable<List<F>> isInfinite() {
        return this.functionToApply.apply(IFloatingCondition::isInfinite);
    }

    @Override
    public Completable<List<F>> isFinite() {
        return this.functionToApply.apply(IFloatingCondition::isFinite);
    }

}
