package org.wotif.core.api.condition.typed.object;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.AbstractJoinCondition;
import org.wotif.core.api.condition.JoinEnum;

import java.util.List;

public class ObjectJoinCondition<T> extends AbstractJoinCondition<T, ObjectCondition<T>>
        implements IObjectCondition<T, List<T>> {

    @SafeVarargs
    public ObjectJoinCondition(JoinEnum joinType, T... terms) {
        super(joinType, terms);
    }

    @Override
    protected ObjectCondition<T> getInstanceOfCondition(T term) {
        return new ObjectCondition<>(term);
    }

    @Override
    public CompletableResult<List<T>> hasNullProperties() {
        return this.functionToApply.apply(ObjectCondition::hasNullProperties);
    }

    @Override
    public CompletableResult<List<T>> doesNotHasNullProperties() {
        return this.functionToApply.apply(ObjectCondition::doesNotHasNullProperties);
    }

    @Override
    public CompletableResult<List<T>> hasAllNullProperties() {
        return this.functionToApply.apply(ObjectCondition::hasAllNullProperties);
    }

    @Override
    public CompletableResult<List<T>> hasNoNullProperties() {
        return this.functionToApply.apply(ObjectCondition::hasNoNullProperties);
    }

    @Override
    public CompletableResult<List<T>> hasProperty(String name) {
        return this.functionToApply.apply(o -> o.hasProperty(name));
    }

    @Override
    public CompletableResult<List<T>> doesNotHasProperty(String name) {
        return this.functionToApply.apply(o -> o.doesNotHasProperty(name));
    }

    @Override
    public CompletableResult<List<T>> hasPropertyWithValue(String propertyName, Object propertyValue) {
        return this.functionToApply.apply(o -> o.hasPropertyWithValue(propertyName, propertyValue));
    }

    @Override
    public CompletableResult<List<T>> doesNotHasPropertyWithValue(String propertyName, Object propertyValue) {
        return this.functionToApply.apply(o -> o.doesNotHasPropertyWithValue(propertyName, propertyValue));
    }

}
