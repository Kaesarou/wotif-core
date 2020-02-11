package org.wotif.core.api.condition.typed.object;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.AbstractJoinCondition;
import org.wotif.core.api.condition.JoinEnum;

public class ObjectJoinCondition<TYPE> extends AbstractJoinCondition<TYPE, ObjectCondition<TYPE>>
        implements IObjectCondition<TYPE> {

    @SafeVarargs
    public ObjectJoinCondition(JoinEnum joinType, TYPE... terms) {
        super(joinType, terms);
    }

    @Override
    protected ObjectCondition<TYPE> getInstanceOfCondition(TYPE term) {
        return new ObjectCondition<>(term);
    }

    @Override
    public CompletableResult hasNullProperties() {
        return this.functionToApply.apply(ObjectCondition::hasNullProperties);
    }

    @Override
    public CompletableResult doesNotHasNullProperties() {
        return this.functionToApply.apply(ObjectCondition::doesNotHasNullProperties);
    }

    @Override
    public CompletableResult hasAllNullProperties() {
        return this.functionToApply.apply(ObjectCondition::hasAllNullProperties);
    }

    @Override
    public CompletableResult hasNoNullProperties() {
        return this.functionToApply.apply(ObjectCondition::hasNoNullProperties);
    }

    @Override
    public CompletableResult hasProperty(String name) {
        return this.functionToApply.apply(o -> o.hasProperty(name));
    }

    @Override
    public CompletableResult doesNotHasProperty(String name) {
        return this.functionToApply.apply(o -> o.doesNotHasProperty(name));
    }

    @Override
    public CompletableResult hasPropertyWithValue(String propertyName, Object propertyValue) {
        return this.functionToApply.apply(o -> o.hasPropertyWithValue(propertyName, propertyValue));
    }

    @Override
    public CompletableResult doesNotHasPropertyWithValue(String propertyName, Object propertyValue) {
        return this.functionToApply.apply(o -> o.doesNotHasPropertyWithValue(propertyName, propertyValue));
    }

}
