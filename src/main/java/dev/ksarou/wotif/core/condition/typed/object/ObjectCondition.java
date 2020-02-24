/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.object;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.AbstractCondition;

public class ObjectCondition<T> extends AbstractCondition<T>
        implements IObjectCondition<T, T> {

    private InternalObjectCondition<T> internalObjectCondition;

    public ObjectCondition(T term) {
        super(term);
        this.internalObjectCondition = new InternalObjectCondition<>(this.term);
    }

    @Override
    public Completable<T> hasNullProperties() {
        boolean result = this.internalObjectCondition.hasNullProperties();
        return new Completable<>(term, result);
    }

    @Override
    public Completable<T> doesNotHasNullProperties() {
        boolean result = !this.internalObjectCondition.hasNullProperties();
        return new Completable<>(term, result);
    }

    @Override
    public Completable<T> hasAllNullProperties() {
        boolean result = this.internalObjectCondition.hasAllNullProperties();
        return new Completable<>(term, result);
    }

    @Override
    public Completable<T> hasNoNullProperties() {
        boolean result = this.internalObjectCondition.hasNoNullProperties();
        return new Completable<>(term, result);
    }

    @Override
    public Completable<T> hasProperty(String name) {
        boolean result = this.internalObjectCondition.hasProperty(name);
        return new Completable<>(term, result);
    }

    @Override
    public Completable<T> doesNotHasProperty(String name) {
        boolean result = !this.internalObjectCondition.hasProperty(name);
        return new Completable<>(term, result);
    }

    @Override
    public Completable<T> hasPropertyWithValue(String propertyName, Object propertyValue) {
        boolean result = this.internalObjectCondition.hasPropertyWithValue(propertyName, propertyValue);
        return new Completable<>(term, result);
    }

    @Override
    public Completable<T> doesNotHasPropertyWithValue(String propertyName, Object propertyValue) {
        boolean result = !this.internalObjectCondition.hasPropertyWithValue(propertyName, propertyValue);
        return new Completable<>(term, result);
    }
}
