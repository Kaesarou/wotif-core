package org.wotif.core.api.condition.typed.object;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.ICondition;

public interface IObjectCondition<T, R> extends ICondition<T, R> {

    CompletableResult<R> hasNullProperties();

    CompletableResult<R> doesNotHasNullProperties();

    CompletableResult<R> hasAllNullProperties();

    CompletableResult<R> hasNoNullProperties();

    CompletableResult<R> hasProperty(String name);

    CompletableResult<R> doesNotHasProperty(String name);

    CompletableResult<R> hasPropertyWithValue(String propertyName, Object propertyValue);

    CompletableResult<R> doesNotHasPropertyWithValue(String propertyName, Object propertyValue);

}
