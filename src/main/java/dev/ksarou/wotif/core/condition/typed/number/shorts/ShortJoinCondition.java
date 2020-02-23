package dev.ksarou.wotif.core.condition.typed.number.shorts;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.number.AbstractNumberJoinCondition;

public class ShortJoinCondition extends AbstractNumberJoinCondition<Short, ShortCondition> {

    public ShortJoinCondition(JoinEnum joinType, Short... terms) {
        super(joinType, terms);
    }

    @Override
    protected ShortCondition getInstanceOfCondition(Short term) {
        return new ShortCondition(term);
    }

}
