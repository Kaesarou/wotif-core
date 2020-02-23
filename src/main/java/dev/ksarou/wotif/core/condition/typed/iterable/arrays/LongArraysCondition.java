package dev.ksarou.wotif.core.condition.typed.iterable.arrays;

import dev.ksarou.wotif.core.condition.typed.iterable.AbstractIterableCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IIterableCondition;

import java.util.ArrayList;
import java.util.List;

public class LongArraysCondition extends AbstractIterableCondition<Long, long[]>
        implements IIterableCondition<Long, long[], long[]> {

    public LongArraysCondition(long[] term) {
        super(term);
    }

    @Override
    protected Iterable<Long> iterable() {
        List<Long> longs = new ArrayList<>();
        for (long l : this.term.value()) {
            longs.add(l);
        }
        return longs;
    }

}
