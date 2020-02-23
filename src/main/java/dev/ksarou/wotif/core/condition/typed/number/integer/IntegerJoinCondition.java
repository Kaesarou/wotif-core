package dev.ksarou.wotif.core.condition.typed.number.integer;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.number.AbstractNumberJoinCondition;

public class IntegerJoinCondition extends AbstractNumberJoinCondition<Integer, IntegerCondition> {

    public IntegerJoinCondition(JoinEnum joinType, Integer... terms) {
        super(joinType, terms);
    }

    @Override
    protected IntegerCondition getInstanceOfCondition(Integer term) {
        return new IntegerCondition(term);
    }

}
