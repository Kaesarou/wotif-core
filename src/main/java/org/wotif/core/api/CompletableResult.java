package org.wotif.core.api;

import com.google.common.collect.ImmutableList;
import org.wotif.core.api.condition.JoinEnum;
import org.wotif.core.api.condition.typed.booleans.BooleanJoinCondition;

import java.util.List;
import java.util.stream.Stream;

public class CompletableResult<T> extends Result<T> {

    public CompletableResult(Term<T> term, boolean value) {
        super(term, value);
    }

    public <R> CompletableResult<?> and(Result<R> result) {
        boolean b = Stream.of(result.value(), this.value()).allMatch(r -> r);
        return new CompletableResult<>(new Term<>(ImmutableList.of(result.term(),this.term())), b);
        //return new BooleanJoinCondition(JoinEnum.ALLOF, result.value(), this.value()).isTrue();
    }

    public <R> CompletableResult<?> or(Result<R> result) {
        boolean b = Stream.of(result.value(), this.value()).anyMatch(r -> r);
        return new CompletableResult<>(new Term<>(ImmutableList.of(result.value(),this.value())), b);
        //return new BooleanJoinCondition(JoinEnum.ANYOF, result.value(), this.value()).isTrue();
    }

}
