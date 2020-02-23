package dev.ksarou.wotif.core.condition.typed.iterable.arrays;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.iterable.AbstractIterableJoinCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IIterableCondition;

import java.util.List;

public class BooleanArraysJoinCondition extends AbstractIterableJoinCondition<Boolean, boolean[]>
        implements IIterableCondition<Boolean, boolean[], List<boolean[]>> {

    public BooleanArraysJoinCondition(JoinEnum joinType, boolean[]... terms) {
        super(joinType, terms);
    }

    @Override
    protected BooleanArraysCondition getInstanceOfCondition(boolean[] term) {
        return new BooleanArraysCondition(term);
    }

}
