package org.wotif.core.api.condition.typed.character;

import org.wotif.core.api.Completable;
import org.wotif.core.api.condition.typed.IComparableCondition;

public interface ICharacterCondition<R> extends IComparableCondition<Character, R> {

    Completable<R> isUpperCase();

    Completable<R> isLowerCase();

}
