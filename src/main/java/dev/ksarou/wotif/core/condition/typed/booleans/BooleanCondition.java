package dev.ksarou.wotif.core.condition.typed.booleans;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.AbstractCondition;

public class BooleanCondition extends AbstractCondition<Boolean> implements IBooleanCondition<Boolean> {

    public BooleanCondition(Boolean term) {
        super(term);
    }

    @Override
    public Completable<Boolean> isTrue() {
        boolean value = this.term.value();
        return new Completable<>(term, value);
    }

    @Override
    public Completable<Boolean> isFalse() {
        boolean value = !this.term.value();
        return new Completable<>(term, value);
    }

}
