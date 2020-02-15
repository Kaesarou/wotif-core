package org.wotif.core.api.condition.typed.iterable.arrays;

import org.wotif.core.api.condition.typed.iterable.AbstractIterableCondition;
import org.wotif.core.api.condition.typed.iterable.IIterableCondition;

import java.util.Arrays;

public class ArraysCondition<T> extends AbstractIterableCondition<T, T[]>
        implements IIterableCondition<T, T[], T[]> {

    public ArraysCondition(T[] term) {
        super(term);
    }

    @Override
    protected Iterable<T> iterable() {
        return Arrays.asList(this.term.value());
    }

}
