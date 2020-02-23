package dev.ksarou.wotif.core.condition.typed.number.longs;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.number.AbstractNumberJoinCondition;

public class LongJoinCondition extends AbstractNumberJoinCondition<Long, LongCondition> {

    public LongJoinCondition(JoinEnum joinType, Long... terms) {
        super(joinType, terms);
    }

    @Override
    protected LongCondition getInstanceOfCondition(Long term) {
        return new LongCondition(term);
    }

}
