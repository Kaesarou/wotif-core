package dev.ksarou.wotif.core.condition.typed.iterable.arrays;

import dev.ksarou.wotif.core.condition.typed.iterable.AbstractIterableCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IIterableCondition;

import java.util.ArrayList;
import java.util.List;

public class CharArraysCondition extends AbstractIterableCondition<Character, char[]>
        implements IIterableCondition<Character, char[], char[]> {

    public CharArraysCondition(char[] term) {
        super(term);
    }

    @Override
    protected Iterable<Character> iterable() {
        List<Character> chars = new ArrayList<>();
        for (char c : this.term.value()) {
            chars.add(c);
        }
        return chars;
    }

}
