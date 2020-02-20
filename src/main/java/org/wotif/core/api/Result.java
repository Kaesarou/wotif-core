package org.wotif.core.api;

import java.util.Objects;
import java.util.function.Function;

public class Result<T> implements Consumable<T>{

    private final Term<T> terms;

    private final boolean result;

    public boolean result() {
        return this.result;
    }

    public Term<T> terms() {
        return this.terms;
    }

    @Override
    public T get() {
        return this.terms.value();
    }

    public Result(Term<T> terms, boolean result) {
        this.terms = terms;
        this.result = result;
    }

    public InstructionsBlock<T, Void> then(CallBack callback) {
        Objects.requireNonNull(callback, "callback is null");
        Instructions<T, Void> instructions = new Instructions<>(this.terms, this, callback);
        return new InstructionsBlock<>(instructions);
    }

    public <R> InstructionsBlock<T, R> then(Function<T, R> function) {
        Objects.requireNonNull(function, "supplier is null");
        Instructions<T, R> instructions = new Instructions<>(this.terms, this, function);
        return new InstructionsBlock<>(instructions);
    }

}
