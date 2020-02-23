package dev.ksarou.wotif.core.condition.typed.number.bytes;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.number.AbstractNumberJoinCondition;

public class ByteJoinCondition extends AbstractNumberJoinCondition<Byte, ByteCondition> {

    public ByteJoinCondition(JoinEnum joinType, Byte... terms) {
        super(joinType, terms);
    }

    @Override
    protected ByteCondition getInstanceOfCondition(Byte term) {
        return new ByteCondition(term);
    }

}
