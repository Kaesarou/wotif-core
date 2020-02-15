package org.wotif.core.api.condition.typed.number.floating.doubles;

import org.wotif.core.api.condition.JoinEnum;
import org.wotif.core.api.condition.typed.number.floating.FloatingJoinCondition;
import org.wotif.core.api.condition.typed.number.floating.IFloatingCondition;

import java.util.List;

public class DoubleJoinCondition extends FloatingJoinCondition<Double>
        implements IFloatingCondition<Double, List<Double>> {

    public DoubleJoinCondition(JoinEnum joinType, Double... terms) {
        super(joinType, terms);
    }

    @Override
    protected DoubleCondition getInstanceOfCondition(Double term) {
        return new DoubleCondition(term);
    }

}
