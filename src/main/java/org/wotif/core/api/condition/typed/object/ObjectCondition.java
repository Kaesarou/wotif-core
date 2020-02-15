package org.wotif.core.api.condition.typed.object;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.AbstractCondition;

public class ObjectCondition<T> extends AbstractCondition<T>
        implements IObjectCondition<T, T> {

    private InternalObjectCondition<T> internalObjectCondition;

    public ObjectCondition(T term) {
        super(term);
        this.internalObjectCondition = new InternalObjectCondition<>(this.term);
    }

    @Override
    public CompletableResult<T> hasNullProperties() {
        boolean result = this.internalObjectCondition.hasNullProperties();
        return new CompletableResult<>(term, result);
    }

    @Override
    public CompletableResult<T> doesNotHasNullProperties() {
        boolean result = !this.internalObjectCondition.hasNullProperties();
        return new CompletableResult<>(term, result);
    }

    @Override
    public CompletableResult<T> hasAllNullProperties() {
        boolean result = this.internalObjectCondition.hasAllNullProperties();
        return new CompletableResult<>(term, result);
    }

    @Override
    public CompletableResult<T> hasNoNullProperties() {
        boolean result = this.internalObjectCondition.hasNoNullProperties();
        return new CompletableResult<>(term, result);
    }

    @Override
    public CompletableResult<T> hasProperty(String name) {
        boolean result = this.internalObjectCondition.hasProperty(name);
        return new CompletableResult<>(term, result);
    }

    @Override
    public CompletableResult<T> doesNotHasProperty(String name) {
        boolean result = !this.internalObjectCondition.hasProperty(name);
        return new CompletableResult<>(term, result);
    }

    @Override
    public CompletableResult<T> hasPropertyWithValue(String propertyName, Object propertyValue) {
        boolean result = this.internalObjectCondition.hasPropertyWithValue(propertyName, propertyValue);
        return new CompletableResult<>(term, result);
    }

    @Override
    public CompletableResult<T> doesNotHasPropertyWithValue(String propertyName, Object propertyValue) {
        boolean result = !this.internalObjectCondition.hasPropertyWithValue(propertyName, propertyValue);
        return new CompletableResult<>(term, result);
    }
}
