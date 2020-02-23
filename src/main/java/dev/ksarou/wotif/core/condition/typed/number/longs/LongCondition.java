package dev.ksarou.wotif.core.condition.typed.number.longs;

import dev.ksarou.wotif.core.condition.typed.number.AbstractNumberCondition;

public class LongCondition extends AbstractNumberCondition<Long> {

    public LongCondition(Long term) {
        super(term);
    }

    @Override
    protected Long zero() {
        return 0L;
    }

}
