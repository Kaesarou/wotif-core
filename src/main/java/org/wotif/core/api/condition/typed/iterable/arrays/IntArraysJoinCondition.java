package org.wotif.core.api.condition.typed.iterable.arrays;

import org.wotif.core.api.condition.JoinEnum;
import org.wotif.core.api.condition.typed.iterable.AbstractIterableJoinCondition;
import org.wotif.core.api.condition.typed.iterable.IIterableCondition;

public class IntArraysJoinCondition extends AbstractIterableJoinCondition<Integer, int[]>
        implements IIterableCondition<Integer, int[]> {

    public IntArraysJoinCondition(JoinEnum joinType, int[]... terms) {
        super(joinType, terms);
    }

    @Override
    protected IntArraysCondition getInstanceOfCondition(int[] term) {
        return new IntArraysCondition(term);
    }

}
