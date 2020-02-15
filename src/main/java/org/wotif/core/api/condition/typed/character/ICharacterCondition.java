package org.wotif.core.api.condition.typed.character;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.typed.IComparableCondition;

public interface ICharacterCondition<R> extends IComparableCondition<Character, R> {

    CompletableResult<R> isUpperCase();

    CompletableResult<R> isLowerCase();

}
