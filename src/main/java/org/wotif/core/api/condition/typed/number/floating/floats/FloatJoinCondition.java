package org.wotif.core.api.condition.typed.number.floating.floats;

import org.wotif.core.api.condition.JoinEnum;
import org.wotif.core.api.condition.typed.number.floating.FloatingJoinCondition;
import org.wotif.core.api.condition.typed.number.floating.IFloatingCondition;

import java.util.List;

public class FloatJoinCondition extends FloatingJoinCondition<Float>
        implements IFloatingCondition<Float, List<Float>> {

    public FloatJoinCondition(JoinEnum joinType, Float... terms) {
        super(joinType, terms);
    }

    @Override
    protected FloatCondition getInstanceOfCondition(Float term) {
        return new FloatCondition(term);
    }

}
