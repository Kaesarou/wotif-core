package org.wotif.core.api;

import com.google.common.collect.ImmutableList;

import java.util.stream.Stream;

public class Completable<T> extends Result<T> {

    public Completable(Term<T> term, boolean value) {
        super(term, value);
    }

    public <R> Completable<?> and(Result<R> result) {
        boolean squashedResult = Stream.of(result.value(), this.value()).allMatch(r -> r);
        return new Completable<>(new Term<>(ImmutableList.of(result.term(), this.term())), squashedResult);
    }

    public <R> Completable<?> or(Result<R> result) {
        boolean squashedResult = Stream.of(result.value(), this.value()).anyMatch(r -> r);
        return new Completable<>(new Term<>(ImmutableList.of(result.value())), squashedResult);
    }

}
