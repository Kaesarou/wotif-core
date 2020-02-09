package org.wotif.core.api.condition.typed.object;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.ICondition;

public interface IObjectCondition<TYPE> extends ICondition<TYPE> {

    CompletableResult hasNullProperties();

    CompletableResult doesNotHasNullProperties();

    CompletableResult hasAllNullProperties();

    CompletableResult hasNoNullProperties();

    CompletableResult hasProperty(String name);

    CompletableResult doesNotHasProperty(String name);

    CompletableResult hasPropertyWithValue(String propertyName, Object propertyValue);

    CompletableResult doesNotHasPropertyWithValue(String propertyName, Object propertyValue);

}
