package org.wotif.core.api;

import io.vavr.control.Option;

import java.util.function.Function;
import java.util.function.Supplier;

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

    public InstructionsBlock<T, Void> then(CallBack callBack) {
        Instructions<T, Void> instructions = new Instructions<>(this, callBack);
        return new InstructionsBlock<>(instructions);
    }

    public <R> InstructionsBlock<T, R> then(Supplier<R> supplier) {
        Instructions<T, R> instructions = new Instructions<>(this, supplier);
        return new InstructionsBlock<>(instructions);
    }

    public <U> U map(Function<? super T, ? extends U> mapper) {
        Option<T> term = Option.of(this.term.value());
        return term.map(mapper).get();
    }

}
