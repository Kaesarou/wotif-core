package org.wotif.core.api.condition.typed.iterable.arrays;

import org.wotif.core.api.condition.typed.iterable.AbstractIterableCondition;
import org.wotif.core.api.condition.typed.iterable.IIterableCondition;

import java.util.ArrayList;
import java.util.List;

public class FloatArraysCondition extends AbstractIterableCondition<Float, float[]>
        implements IIterableCondition<Float, float[], float[]> {

    public FloatArraysCondition(float[] term) {
        super(term);
    }

    @Override
    protected Iterable<Float> iterable() {
        List<Float> floats = new ArrayList<>();
        for (float f : this.term.value()) {
            floats.add(f);
        }
        return floats;
    }

}
