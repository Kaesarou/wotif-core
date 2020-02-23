package dev.ksarou.wotif.core.condition.typed.iterable.arrays;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.iterable.AbstractIterableJoinCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IIterableCondition;

import java.util.List;

public class ByteArraysJoinCondition extends AbstractIterableJoinCondition<Byte, byte[]>
        implements IIterableCondition<Byte, byte[], List<byte[]>> {

    public ByteArraysJoinCondition(JoinEnum joinType, byte[]... terms) {
        super(joinType, terms);
    }

    @Override
    protected ByteArraysCondition getInstanceOfCondition(byte[] term) {
        return new ByteArraysCondition(term);
    }

}
