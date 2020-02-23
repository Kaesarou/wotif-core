package dev.ksarou.wotif.core.condition.typed.iterable.arrays;

import dev.ksarou.wotif.core.condition.typed.iterable.AbstractIterableCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IIterableCondition;

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
