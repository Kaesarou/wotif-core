package dev.ksarou.wotif.core.condition.typed.number.bytes;

import dev.ksarou.wotif.core.condition.typed.number.AbstractNumberCondition;

public class ByteCondition extends AbstractNumberCondition<Byte> {

    public ByteCondition(Byte term) {
        super(term);
    }

    @Override
    protected Byte zero() {
        return 0;
    }

}
