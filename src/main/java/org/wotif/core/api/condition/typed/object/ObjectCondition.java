package org.wotif.core.api.condition.typed.object;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.AbstractCondition;

public class ObjectCondition<TYPE> extends AbstractCondition<TYPE>
        implements IObjectCondition<TYPE> {

    private InternalObjectCondition<TYPE> internalObjectCondition;

    public ObjectCondition(TYPE term) {
        super(term);
        this.internalObjectCondition = new InternalObjectCondition<>(this.term);
    }

    @Override
    public CompletableResult hasNullProperties() {
        boolean result = this.internalObjectCondition.hasNullProperties();
        return new CompletableResult(result);
    }

    @Override
    public CompletableResult doesNotHasNullProperties() {
        boolean result = !this.internalObjectCondition.hasNullProperties();
        return new CompletableResult(result);
    }

    @Override
    public CompletableResult hasAllNullProperties() {
        boolean result = this.internalObjectCondition.hasAllNullProperties();
        return new CompletableResult(result);
    }

    @Override
    public CompletableResult hasNoNullProperties() {
        boolean result = this.internalObjectCondition.hasNoNullProperties();
        return new CompletableResult(result);
    }

    @Override
    public CompletableResult hasProperty(String name) {
        boolean result = this.internalObjectCondition.hasProperty(name);
        return new CompletableResult(result);
    }

    @Override
    public CompletableResult doesNotHasProperty(String name) {
        boolean result = !this.internalObjectCondition.hasProperty(name);
        return new CompletableResult(result);
    }

    @Override
    public CompletableResult hasPropertyWithValue(String propertyName, Object propertyValue) {
        boolean result = this.internalObjectCondition.hasPropertyWithValue(propertyName, propertyValue);
        return new CompletableResult(result);
    }

    @Override
    public CompletableResult doesNotHasPropertyWithValue(String propertyName, Object propertyValue) {
        boolean result = !this.internalObjectCondition.hasPropertyWithValue(propertyName, propertyValue);
        return new CompletableResult(result);
    }
}
