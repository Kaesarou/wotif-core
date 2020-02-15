package org.wotif.core.api.condition.typed.character;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.JoinEnum;
import org.wotif.core.api.condition.typed.ComparableJoinCondition;

import java.util.List;

public class CharacterJoinCondition
        extends ComparableJoinCondition<Character, CharacterCondition>
        implements ICharacterCondition<List<Character>> {

    public CharacterJoinCondition(JoinEnum joinType, Character... terms) {
        super(joinType, terms);
    }

    @Override
    protected CharacterCondition getInstanceOfCondition(Character term) {
        return new CharacterCondition(term);
    }

    @Override
    public CompletableResult<List<Character>> isUpperCase() {
        return this.functionToApply.apply(CharacterCondition::isUpperCase);
    }

    @Override
    public CompletableResult<List<Character>> isLowerCase() {
        return this.functionToApply.apply(CharacterCondition::isLowerCase);
    }

}
