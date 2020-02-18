package org.wotif.core.api;

import java.util.Objects;
import java.util.function.Function;

public class Result<T> {

    private final Term<T> term;

    private final boolean value;

    public boolean value() {
        return this.value;
    }

    public Term<T> term() {
        return this.term;
    }

    public Result(Term<T> term, boolean value) {
        this.term = term;
        this.value = value;
    }

    public InstructionsBlock<T, Void> then(CallBack callback) {
        Objects.requireNonNull(callback, "callback is null");
        Instructions<T, Void> instructions = new Instructions<>(this.term, this, callback);
        return new InstructionsBlock<>(instructions);
    }

    public <R> InstructionsBlock<T, R> then(Function<T, R> function) {
        Objects.requireNonNull(function, "supplier is null");
        Instructions<T, R> instructions = new Instructions<>(this.term, this, function);
        return new InstructionsBlock<>(instructions);
    }

}
