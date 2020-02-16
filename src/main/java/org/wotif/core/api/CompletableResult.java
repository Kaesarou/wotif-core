package org.wotif.core.api;

import com.google.common.collect.ImmutableList;

import java.util.stream.Stream;

public class CompletableResult<T> extends Result<T> {

    public CompletableResult(Term<T> term, boolean value) {
        super(term, value);
    }

    public <R> CompletableResult<?> and(Result<R> result) {
        boolean squashedResult = Stream.of(result.value(), this.value()).allMatch(r -> r);
        return new CompletableResult<>(new Term<>(ImmutableList.of(result.term(), this.term())), squashedResult);
    }

    public <R> CompletableResult<?> or(Result<R> result) {
        boolean squashedResult = Stream.of(result.value(), this.value()).anyMatch(r -> r);
        return new CompletableResult<>(new Term<>(ImmutableList.of(result.value(), this.value())), squashedResult);
    }

}
