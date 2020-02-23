package dev.ksarou.wotif.core.condition.typed.iterable;

import dev.ksarou.wotif.core.condition.JoinEnum;

import java.util.List;

public class IterableJoinCondition<T>
        extends AbstractIterableJoinCondition<T, Iterable<T>>
        implements IIterableCondition<T, Iterable<T>, List<Iterable<T>>> {

    @SafeVarargs
    public IterableJoinCondition(JoinEnum joinIype, Iterable<T>... terms) {
        super(joinIype, terms);
    }

    @Override
    public IterableCondition<T> getInstanceOfCondition(Iterable<T> term) {
        return new IterableCondition<>(term);
    }

}
