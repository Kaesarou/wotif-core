package org.wotif.core.api.condition;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.wotif.core.api.Completable;
import org.wotif.core.api.Term;

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
