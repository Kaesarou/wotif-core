/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.Term;
import org.checkerframework.checker.nullness.qual.NonNull;

public abstract class AbstractCondition<T> implements ICondition<T, T> {

    protected Term<T> term;
    
    public AbstractCondition(T term) {
        this.term = new Term<>(term);
    }

    @Override
    public Completable<T> isEqualTo(T expected) {
        boolean value = this.term.value().equals(expected);
        return new Completable<>(term, value);
    }

    @Override
    public Completable<T> isDifferentFrom(T expected) {
        boolean value = !this.term.value().equals(expected);
        return new Completable<>(term, value);
    }

    @Override
    public Completable<T> isNull() {
        boolean value = this.term.value() == null;
        return new Completable<>(term, value);
    }

    @Override
    public Completable<T> isNotNull() {
        boolean value = this.term.value() != null;
        return new Completable<>(term, value);
    }

    @Override
    public Completable<T> isInstanceOf(Class<?> className) {
        boolean value = className.isInstance(this.term.value());
        return new Completable<>(term, value);
    }

    @Override
    public Completable<T> isNotInstanceOf(Class<?> className) {
        boolean value = !className.isInstance(this.term.value());
        return new Completable<>(term, value);
    }

    @Override
    public Completable<T> hasSameClassAs(@NonNull Object other) {
        boolean value = other.getClass().equals(this.term.value().getClass());
        return new Completable<>(term, value);
    }

    @Override
    public Completable<T> doesNotHasSameClassAs(@NonNull Object other) {
        boolean value = !other.getClass().equals(this.term.value().getClass());
        return new Completable<>(term, value);
    }

    public Completable<T> hasSameHashCodeAs(@NonNull Object other) {
        boolean value = other.hashCode() == this.term.value().hashCode();
        return new Completable<>(term, value);
    }

    public Completable<T> doesNotHasSameHashCodeAs(@NonNull Object other) {
        boolean value = other.hashCode() != this.term.value().hashCode();
        return new Completable<>(term, value);
    }

    public Completable<T> hasToString(String expectedToString) {
        boolean value = this.term.value().toString().contentEquals(expectedToString);
        return new Completable<>(term, value);
    }

    public Completable<T> doesNotHasToString(String expectedToString) {
        boolean value = !this.term.value().toString().contentEquals(expectedToString);
        return new Completable<>(term, value);
    }

}
