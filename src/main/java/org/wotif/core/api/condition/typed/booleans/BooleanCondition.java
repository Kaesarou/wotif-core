package org.wotif.core.api.condition.typed.booleans;

import org.wotif.core.api.Completable;
import org.wotif.core.api.condition.AbstractCondition;

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
