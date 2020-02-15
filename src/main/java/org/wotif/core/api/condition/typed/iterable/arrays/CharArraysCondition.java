package org.wotif.core.api.condition.typed.iterable.arrays;

import org.wotif.core.api.condition.typed.iterable.AbstractIterableCondition;
import org.wotif.core.api.condition.typed.iterable.IIterableCondition;

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
