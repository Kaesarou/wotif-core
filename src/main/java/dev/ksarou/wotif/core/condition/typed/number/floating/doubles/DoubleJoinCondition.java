package dev.ksarou.wotif.core.condition.typed.number.floating.doubles;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.number.floating.FloatingJoinCondition;
import dev.ksarou.wotif.core.condition.typed.number.floating.IFloatingCondition;

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
