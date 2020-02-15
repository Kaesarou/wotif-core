package org.wotif.core.api.condition.typed.iterable.arrays;

import org.wotif.core.api.condition.JoinEnum;
import org.wotif.core.api.condition.typed.iterable.AbstractIterableJoinCondition;
import org.wotif.core.api.condition.typed.iterable.IIterableCondition;

import java.util.List;

public class ShortArraysJoinCondition extends AbstractIterableJoinCondition<Short, short[]>
        implements IIterableCondition<Short, short[], List<short[]>> {

    public ShortArraysJoinCondition(JoinEnum joinType, short[]... terms) {
        super(joinType, terms);
    }

    @Override
    protected ShortArraysCondition getInstanceOfCondition(short[] term) {
        return new ShortArraysCondition(term);
    }

}
