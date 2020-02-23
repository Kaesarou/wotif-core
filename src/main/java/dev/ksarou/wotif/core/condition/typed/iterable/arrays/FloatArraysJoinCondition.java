package dev.ksarou.wotif.core.condition.typed.iterable.arrays;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.iterable.AbstractIterableJoinCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IIterableCondition;

import java.util.List;

public class FloatArraysJoinCondition extends AbstractIterableJoinCondition<Float, float[]>
        implements IIterableCondition<Float, float[], List<float[]>> {

    public FloatArraysJoinCondition(JoinEnum joinType, float[]... terms) {
        super(joinType, terms);
    }

    @Override
    protected FloatArraysCondition getInstanceOfCondition(float[] term) {
        return new FloatArraysCondition(term);
    }

}
