package dev.ksarou.wotif.core.condition.typed.iterable.arrays;

import dev.ksarou.wotif.core.condition.typed.iterable.AbstractIterableCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IIterableCondition;

import java.util.ArrayList;
import java.util.List;

public class BooleanArraysCondition extends AbstractIterableCondition<Boolean, boolean[]>
        implements IIterableCondition<Boolean, boolean[], boolean[]> {

    public BooleanArraysCondition(boolean[] term) {
        super(term);
    }

    @Override
    protected Iterable<Boolean> iterable() {
        List<Boolean> booleans = new ArrayList<>();
        for (boolean b : this.term.value()) {
            booleans.add(b);
        }
        return booleans;
    }

}
