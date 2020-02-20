package org.wotif.core.api.condition;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.wotif.core.api.Completable;
import org.wotif.core.api.Term;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractJoinCondition<T, C extends AbstractCondition<T>> implements ICondition<T, List<T>> {

    Term<List<T>> term;

    protected List<C> conditions;

    protected Function<Function<? super C, Completable<T>>, Completable<List<T>>> functionToApply;

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

    private Completable<List<T>> allOf(Function<? super C, Completable<T>> method) {
        boolean value = conditions.stream().allMatch((c) -> method.apply(c).result());
        return new Completable<>(term, value);
    }

    private Completable<List<T>> anyOf(Function<? super C, Completable<T>> method) {
        boolean value = conditions.stream().anyMatch((c) -> method.apply(c).result());
        return new Completable<>(term, value);
    }

    private Completable<List<T>> noneOf(Function<? super C, Completable<T>> method) {
        boolean value = conditions.stream().noneMatch((c) -> method.apply(c).result());
        return new Completable<>(term, value);
    }

    @Override
    public Completable<List<T>> isEqualTo(T expected) {
        return this.functionToApply.apply(b -> b.isEqualTo(expected));
    }

    @Override
    public Completable<List<T>> isDifferentFrom(T expected) {
        return this.functionToApply.apply(b -> b.isDifferentFrom(expected));
    }

    @Override
    public Completable<List<T>> isNull() {
        return this.functionToApply.apply(AbstractCondition::isNull);
    }

    @Override
    public Completable<List<T>> isNotNull() {
        return this.functionToApply.apply(AbstractCondition::isNotNull);
    }

    @Override
    public Completable<List<T>> isInstanceOf(Class<?> className) {
        return this.functionToApply.apply(b -> b.isInstanceOf(className));
    }

    @Override
    public Completable<List<T>> isNotInstanceOf(Class<?> className) {
        return this.functionToApply.apply(b -> b.isNotInstanceOf(className));
    }

    @Override
    public Completable<List<T>> hasSameClassAs(@NonNull Object other) {
        return this.functionToApply.apply(b -> b.hasSameClassAs(other));
    }

    @Override
    public Completable<List<T>> doesNotHasSameClassAs(@NonNull Object other) {
        return this.functionToApply.apply(b -> b.doesNotHasSameClassAs(other));
    }

    @Override
    public Completable<List<T>> hasSameHashCodeAs(@NonNull Object other) {
        return this.functionToApply.apply(b -> b.hasSameHashCodeAs(other));
    }

    @Override
    public Completable<List<T>> doesNotHasSameHashCodeAs(@NonNull Object other) {
        return this.functionToApply.apply(b -> b.doesNotHasSameHashCodeAs(other));
    }

    @Override
    public Completable<List<T>> hasToString(String expectedToString) {
        return this.functionToApply.apply(b -> b.hasToString(expectedToString));
    }

    @Override
    public Completable<List<T>> doesNotHasToString(String expectedToString) {
        return this.functionToApply.apply(b -> b.doesNotHasToString(expectedToString));
    }

}
