package org.wotif.core.api;

import io.vavr.control.Either;

import java.util.function.Function;

public class Instructions<T, R> {

    private final Term<T> term;

    private final Result<?> result;

    private Either<Function<? super T, ? extends R>, CallBack> action;

    public Instructions(Term<T> term, Result<?> result, Function<? super T, ? extends R> function) {
        this.term = term;
        this.result = result;
        this.action = Either.left(function);
    }

    public Instructions(Term<T> term, Result<?> result, CallBack callback) {
        this.term = term;
        this.result = result;
        this.action = Either.right(callback);
    }

    public Result<?> result() {
        return this.result;
    }

    public Term<T> term() {
        return this.term;
    }

    public R executeAction() {
        if (this.action.isLeft()) {
            return this.action.left().get().apply(this.term.value());
        }
        this.action.right().get().execute();
        return null;
    }

}
