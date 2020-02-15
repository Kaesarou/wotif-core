package org.wotif.core.api.condition;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.Term;

public abstract class AbstractCondition<T> implements ICondition<T, T> {

    protected Term<T> term;


    public AbstractCondition(T term) {
        this.term = new Term<>(term);
    }

    @Override
    public CompletableResult<T> isEqualTo(T expected) {
        boolean value = this.term.value().equals(expected);
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<T> isDifferentFrom(T expected) {
        boolean value = !this.term.value().equals(expected);
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<T> isNull() {
        boolean value = this.term.value() == null;
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<T> isNotNull() {
        boolean value = this.term.value() != null;
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<T> isInstanceOf(Class<?> className) {
        boolean value = className.isInstance(this.term.value());
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<T> isNotInstanceOf(Class<?> className) {
        boolean value = !className.isInstance(this.term.value());
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<T> hasSameClassAs(@NonNull Object other) {
        boolean value = other.getClass().equals(this.term.value().getClass());
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<T> doesNotHasSameClassAs(@NonNull Object other) {
        boolean value = !other.getClass().equals(this.term.value().getClass());
        return new CompletableResult<>(term, value);
    }

    public CompletableResult<T> hasSameHashCodeAs(@NonNull Object other) {
        boolean value = other.hashCode() == this.term.value().hashCode();
        return new CompletableResult<>(term, value);
    }

    public CompletableResult<T> doesNotHasSameHashCodeAs(@NonNull Object other) {
        boolean value = other.hashCode() != this.term.value().hashCode();
        return new CompletableResult<>(term, value);
    }

    public CompletableResult<T> hasToString(String expectedToString) {
        boolean value = this.term.value().toString().contentEquals(expectedToString);
        return new CompletableResult<>(term, value);
    }

    public CompletableResult<T> doesNotHasToString(String expectedToString) {
        boolean value = !this.term.value().toString().contentEquals(expectedToString);
        return new CompletableResult<>(term, value);
    }

}
