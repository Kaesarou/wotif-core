package dev.ksarou.wotif.core.condition.typed.iterable.arrays;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.iterable.AbstractIterableJoinCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IIterableCondition;

import java.util.List;

public class LongArraysJoinCondition extends AbstractIterableJoinCondition<Long, long[]>
        implements IIterableCondition<Long, long[], List<long[]>> {

    public LongArraysJoinCondition(JoinEnum joinType, long[]... terms) {
        super(joinType, terms);
    }

    @Override
    protected LongArraysCondition getInstanceOfCondition(long[] term) {
        return new LongArraysCondition(term);
    }

}
