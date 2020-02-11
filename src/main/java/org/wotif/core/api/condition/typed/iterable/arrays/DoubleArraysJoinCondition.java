package org.wotif.core.api.condition.typed.iterable.arrays;

import org.wotif.core.api.condition.JoinEnum;
import org.wotif.core.api.condition.typed.iterable.AbstractIterableJoinCondition;
import org.wotif.core.api.condition.typed.iterable.IIterableCondition;

public class DoubleArraysJoinCondition extends AbstractIterableJoinCondition<Double, double[]>
        implements IIterableCondition<Double, double[]> {

    public DoubleArraysJoinCondition(JoinEnum joinType, double[]... terms) {
        super(joinType, terms);
    }

    @Override
    protected DoubleArraysCondition getInstanceOfCondition(double[] term) {
        return new DoubleArraysCondition(term);
    }

}
