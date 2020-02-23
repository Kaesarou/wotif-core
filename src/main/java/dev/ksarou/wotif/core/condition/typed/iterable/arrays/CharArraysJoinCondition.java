package dev.ksarou.wotif.core.condition.typed.iterable.arrays;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.iterable.AbstractIterableJoinCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IIterableCondition;

import java.util.List;

public class CharArraysJoinCondition extends AbstractIterableJoinCondition<Character, char[]>
        implements IIterableCondition<Character, char[], List<char[]>> {

    public CharArraysJoinCondition(JoinEnum joinType, char[]... terms) {
        super(joinType, terms);
    }

    @Override
    protected CharArraysCondition getInstanceOfCondition(char[] term) {
        return new CharArraysCondition(term);
    }

}
