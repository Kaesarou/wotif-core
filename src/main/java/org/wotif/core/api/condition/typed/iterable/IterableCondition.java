package org.wotif.core.api.condition.typed.iterable;

public class IterableCondition<T> extends AbstractIterableCondition<T, Iterable<T>>
        implements IIterableCondition<T, Iterable<T>, Iterable<T>> {

    public IterableCondition(Iterable<T> term) {
        super(term);
    }

    @Override
    protected Iterable<T> iterable() {
        return this.term.value();
    }

}
