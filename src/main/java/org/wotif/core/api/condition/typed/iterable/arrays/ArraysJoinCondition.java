package org.wotif.core.api.condition.typed.iterable.arrays;

import org.wotif.core.api.condition.JoinEnum;
import org.wotif.core.api.condition.typed.iterable.AbstractIterableJoinCondition;
import org.wotif.core.api.condition.typed.iterable.IIterableCondition;

import java.util.List;

public class ArraysJoinCondition<T>
        extends AbstractIterableJoinCondition<T, T[]>
        implements IIterableCondition<T, T[], List<T[]>> {

    @SafeVarargs
    public ArraysJoinCondition(JoinEnum joinType, T[]... terms) {
        super(joinType, terms);
    }

    @Override
    protected ArraysCondition<T> getInstanceOfCondition(T[] term) {
        return new ArraysCondition<>(term);
    }

}
