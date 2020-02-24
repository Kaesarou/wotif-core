/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.character;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.ComparableJoinCondition;

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
    public Completable<List<Character>> isUpperCase() {
        return this.functionToApply.apply(CharacterCondition::isUpperCase);
    }

    @Override
    public Completable<List<Character>> isLowerCase() {
        return this.functionToApply.apply(CharacterCondition::isLowerCase);
    }

}
