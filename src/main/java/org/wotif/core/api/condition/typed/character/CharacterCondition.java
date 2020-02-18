package org.wotif.core.api.condition.typed.character;

import org.wotif.core.api.Completable;
import org.wotif.core.api.condition.typed.ComparableCondition;

public class CharacterCondition extends ComparableCondition<Character> implements ICharacterCondition<Character> {

    public CharacterCondition(Character term) {
        super(term);
    }

    @Override
    public Completable<Character> isUpperCase() {
        boolean upperCase = Character.isUpperCase(this.term.value());
        return new Completable<>(term, upperCase);
    }

    @Override
    public Completable<Character> isLowerCase() {
        boolean upperCase = Character.isLowerCase(this.term.value());
        return new Completable<>(term, upperCase);
    }

}
