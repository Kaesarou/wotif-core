package dev.ksarou.wotif.core.condition.typed.number.integer;

import dev.ksarou.wotif.core.condition.typed.number.AbstractNumberCondition;

public class IntegerCondition extends AbstractNumberCondition<Integer> {

    public IntegerCondition(Integer term) {
        super(term);
    }

    @Override
    protected Integer zero() {
        return 0;
    }

}
