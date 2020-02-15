package org.wotif.core.api.condition.typed.booleans;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.AbstractCondition;

public class BooleanCondition extends AbstractCondition<Boolean> implements IBooleanCondition<Boolean> {

    public BooleanCondition(Boolean term) {
        super(term);
    }

    @Override
    public CompletableResult<Boolean> isTrue() {
        boolean value = this.term.value();
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<Boolean> isFalse() {
        boolean value = !this.term.value();
        return new CompletableResult<>(term, value);
    }

}
