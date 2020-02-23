package dev.ksarou.wotif.core.condition.typed.character;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.typed.IComparableCondition;

public interface ICharacterCondition<R> extends IComparableCondition<Character, R> {

    Completable<R> isUpperCase();

    Completable<R> isLowerCase();

}
