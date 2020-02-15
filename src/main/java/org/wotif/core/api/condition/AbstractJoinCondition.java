package org.wotif.core.api.condition;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.Term;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractJoinCondition<T, C extends AbstractCondition<T>> implements ICondition<T, List<T>> {

    Term<List<T>> term;

    protected List<C> conditions;

    protected Function<Function<? super C, CompletableResult<T>>, CompletableResult<List<T>>> functionToApply;

    @SafeVarargs
    protected AbstractJoinCondition(JoinEnum joinType, T... terms) {
        this.term = new Term<>(Arrays.asList(terms));
        this.conditions = Arrays.stream(terms).map(this::getInstanceOfCondition).collect(Collectors.toList());
        if (joinType.equals(JoinEnum.ALLOF))
            this.functionToApply = this::allOf;
        else if (joinType.equals(JoinEnum.ANYOF))
            this.functionToApply = this::anyOf;
        else if (joinType.equals(JoinEnum.NONEOF))
            this.functionToApply = this::noneOf;
    }

    protected abstract C getInstanceOfCondition(T term);

    private CompletableResult<List<T>> allOf(Function<? super C, CompletableResult<T>> method) {
        boolean value = conditions.stream().allMatch((c) -> method.apply(c).value());
        return new CompletableResult<>(term, value);
    }

    private CompletableResult<List<T>> anyOf(Function<? super C, CompletableResult<T>> method) {
        boolean value = conditions.stream().anyMatch((c) -> method.apply(c).value());
        return new CompletableResult<>(term, value);
    }

    private CompletableResult<List<T>> noneOf(Function<? super C, CompletableResult<T>> method) {
        boolean value = conditions.stream().noneMatch((c) -> method.apply(c).value());
        return new CompletableResult<>(term, value);
    }

    @Override
    public CompletableResult<List<T>> isEqualTo(T expected) {
        return this.functionToApply.apply(b -> b.isEqualTo(expected));
    }

    @Override
    public CompletableResult<List<T>> isDifferentFrom(T expected) {
        return this.functionToApply.apply(b -> b.isDifferentFrom(expected));
    }

    @Override
    public CompletableResult<List<T>> isNull() {
        return this.functionToApply.apply(AbstractCondition::isNull);
    }

    @Override
    public CompletableResult<List<T>> isNotNull() {
        return this.functionToApply.apply(AbstractCondition::isNotNull);
    }

    @Override
    public CompletableResult<List<T>> isInstanceOf(Class<?> className) {
        return this.functionToApply.apply(b -> b.isInstanceOf(className));
    }

    @Override
    public CompletableResult<List<T>> isNotInstanceOf(Class<?> className) {
        return this.functionToApply.apply(b -> b.isNotInstanceOf(className));
    }

    @Override
    public CompletableResult<List<T>> hasSameClassAs(@NonNull Object other) {
        return this.functionToApply.apply(b -> b.hasSameClassAs(other));
    }

    @Override
    public CompletableResult<List<T>> doesNotHasSameClassAs(@NonNull Object other) {
        return this.functionToApply.apply(b -> b.doesNotHasSameClassAs(other));
    }

    @Override
    public CompletableResult<List<T>> hasSameHashCodeAs(@NonNull Object other) {
        return this.functionToApply.apply(b -> b.hasSameHashCodeAs(other));
    }

    @Override
    public CompletableResult<List<T>> doesNotHasSameHashCodeAs(@NonNull Object other) {
        return this.functionToApply.apply(b -> b.doesNotHasSameHashCodeAs(other));
    }

    @Override
    public CompletableResult<List<T>> hasToString(String expectedToString) {
        return this.functionToApply.apply(b -> b.hasToString(expectedToString));
    }

    @Override
    public CompletableResult<List<T>> doesNotHasToString(String expectedToString) {
        return this.functionToApply.apply(b -> b.doesNotHasToString(expectedToString));
    }

}
