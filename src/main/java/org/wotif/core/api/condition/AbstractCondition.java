package org.wotif.core.api.condition;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.Term;

public abstract class AbstractCondition<TYPE> implements ICondition<TYPE> {

    protected Term<TYPE> term;


    public AbstractCondition(TYPE term) {
        this.term = new Term<>(term);
    }

    @Override
    public CompletableResult isEqualTo(TYPE expected) {
        boolean value = this.term.value().equals(expected);
        return new CompletableResult(value);
    }

    @Override
    public CompletableResult isDifferentFrom(TYPE expected) {
        boolean value = !this.term.value().equals(expected);
        return new CompletableResult(value);
    }

    @Override
    public CompletableResult isNull() {
        boolean value = this.term.value() == null;
        return new CompletableResult(value);
    }

    @Override
    public CompletableResult isNotNull() {
        boolean value = this.term.value() != null;
        return new CompletableResult(value);
    }

    @Override
    public CompletableResult isInstanceOf(Class<?> className) {
        boolean value = className.isInstance(this.term.value());
        return new CompletableResult(value);
    }

    @Override
    public CompletableResult isNotInstanceOf(Class<?> className) {
        boolean value = !className.isInstance(this.term.value());
        return new CompletableResult(value);
    }

    @Override
    public CompletableResult hasSameClassAs(@NonNull Object other) {
        boolean value = other.getClass().equals(this.term.value().getClass());
        return new CompletableResult(value);
    }

    @Override
    public CompletableResult doesNotHasSameClassAs(@NonNull Object other) {
        boolean value = !other.getClass().equals(this.term.value().getClass());
        return new CompletableResult(value);
    }

    public CompletableResult hasSameHashCodeAs(@NonNull Object other) {
        boolean value = other.hashCode() == this.term.value().hashCode();
        return new CompletableResult(value);
    }

    public CompletableResult doesNotHasSameHashCodeAs(@NonNull Object other) {
        boolean value = other.hashCode() != this.term.value().hashCode();
        return new CompletableResult(value);
    }

    public CompletableResult hasToString(String expectedToString) {
        boolean value = this.term.value().toString().contentEquals(expectedToString);
        return new CompletableResult(value);
    }

    public CompletableResult doesNotHasToString(String expectedToString) {
        boolean value = !this.term.value().toString().contentEquals(expectedToString);
        return new CompletableResult(value);
    }

}
