package org.wotif.core.api.condition.typed.character;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.typed.ComparableCondition;

public class CharacterCondition extends ComparableCondition<Character> implements ICharacterCondition<Character> {

    public CharacterCondition(Character term) {
        super(term);
    }

    @Override
    public CompletableResult<Character> isUpperCase() {
        boolean upperCase = Character.isUpperCase(this.term.value());
        return new CompletableResult<>(term, upperCase);
    }

    @Override
    public CompletableResult<Character> isLowerCase() {
        boolean upperCase = Character.isLowerCase(this.term.value());
        return new CompletableResult<>(term, upperCase);
    }

}
