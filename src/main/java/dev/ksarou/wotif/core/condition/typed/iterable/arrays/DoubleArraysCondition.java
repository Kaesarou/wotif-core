package dev.ksarou.wotif.core.condition.typed.iterable.arrays;

import dev.ksarou.wotif.core.condition.typed.iterable.AbstractIterableCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IIterableCondition;

import java.util.ArrayList;
import java.util.List;

public class DoubleArraysCondition extends AbstractIterableCondition<Double, double[]>
        implements IIterableCondition<Double, double[], double[]> {

    public DoubleArraysCondition(double[] term) {
        super(term);
    }

    @Override
    protected Iterable<Double> iterable() {
        List<Double> doubles = new ArrayList<>();
        for (double d : this.term.value()) {
            doubles.add(d);
        }
        return doubles;
    }

}
