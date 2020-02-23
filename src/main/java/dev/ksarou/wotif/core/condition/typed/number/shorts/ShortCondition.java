package dev.ksarou.wotif.core.condition.typed.number.shorts;

import dev.ksarou.wotif.core.condition.typed.number.AbstractNumberCondition;

public class ShortCondition extends AbstractNumberCondition<Short> {

    public ShortCondition(Short term) {
        super(term);
    }

    @Override
    protected Short zero() {
        return 0;
    }

}
