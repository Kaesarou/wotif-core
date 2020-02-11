package org.wotif.core.api.condition.typed.iterable;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.AbstractJoinCondition;
import org.wotif.core.api.condition.JoinEnum;

import java.util.function.Predicate;

public abstract class AbstractIterableJoinCondition<ITERABLE_TYPE, ITERABLE>
        extends AbstractJoinCondition<ITERABLE, AbstractIterableCondition<ITERABLE_TYPE, ITERABLE>>
        implements IIterableCondition<ITERABLE_TYPE, ITERABLE> {

    @SafeVarargs
    public AbstractIterableJoinCondition(JoinEnum joinType, ITERABLE... terms) {
        super(joinType, terms);
    }

    @Override
    @SafeVarargs
    public final CompletableResult contains(ITERABLE_TYPE... values) {
        return this.functionToApply.apply(a -> a.contains(values));
    }

    @Override
    @SafeVarargs
    public final CompletableResult doesNotContains(ITERABLE_TYPE... values) {
        return this.functionToApply.apply(a -> a.doesNotContains(values));
    }

    @Override
    public final CompletableResult contains(Iterable<ITERABLE_TYPE> values) {
        return this.functionToApply.apply(a -> a.contains(values));
    }

    @Override
    public final CompletableResult doesNotContains(Iterable<ITERABLE_TYPE> values) {
        return this.functionToApply.apply(a -> a.doesNotContains(values));
    }

    @Override
    @SafeVarargs
    public final CompletableResult containsAnyOf(ITERABLE_TYPE... values) {
        return this.functionToApply.apply(a -> a.containsAnyOf(values));
    }

    @Override
    public final CompletableResult containsAnyOf(Iterable<ITERABLE_TYPE> values) {
        return this.functionToApply.apply(a -> a.containsAnyOf(values));
    }

    @Override
    @SafeVarargs
    public final CompletableResult containsOnly(ITERABLE_TYPE... values) {
        return this.functionToApply.apply(a -> a.containsOnly(values));
    }

    @Override
    public final CompletableResult containsOnly(Iterable<ITERABLE_TYPE> values) {
        return this.functionToApply.apply(a -> a.containsOnly(values));
    }

    @Override
    @SafeVarargs
    public final CompletableResult doesNotContainsOnly(ITERABLE_TYPE... values) {
        return this.functionToApply.apply(a -> a.doesNotContainsOnly(values));
    }

    @Override
    public final CompletableResult doesNotContainsOnly(Iterable<ITERABLE_TYPE> values) {
        return this.functionToApply.apply(a -> a.doesNotContainsOnly(values));
    }

    @Override
    @SafeVarargs
    public final CompletableResult containsOnlyOnce(ITERABLE_TYPE... values) {
        return this.functionToApply.apply(a -> a.containsOnlyOnce(values));
    }

    @Override
    public final CompletableResult containsOnlyOnce(Iterable<ITERABLE_TYPE> values) {
        return this.functionToApply.apply(a -> a.containsOnlyOnce(values));
    }

    @Override
    @SafeVarargs
    public final CompletableResult containsMoreThanOnce(ITERABLE_TYPE... values) {
        return this.functionToApply.apply(a -> a.containsMoreThanOnce(values));
    }

    @Override
    public final CompletableResult containsMoreThanOnce(Iterable<ITERABLE_TYPE> values) {
        return this.functionToApply.apply(a -> a.containsMoreThanOnce(values));
    }

    @Override
    public final CompletableResult startsWith(ITERABLE_TYPE value) {
        return this.functionToApply.apply(a -> a.startsWith(value));
    }

    @Override
    public final CompletableResult doesNotStartsWith(ITERABLE_TYPE value) {
        return this.functionToApply.apply(a -> a.doesNotStartsWith(value));
    }

    @Override
    public final CompletableResult endsWith(ITERABLE_TYPE value) {
        return this.functionToApply.apply(a -> a.endsWith(value));
    }

    @Override
    public final CompletableResult doesNotEndsWith(ITERABLE_TYPE value) {
        return this.functionToApply.apply(a -> a.doesNotEndsWith(value));
    }

    @Override
    @SafeVarargs
    public final CompletableResult isSubsetOf(ITERABLE_TYPE... values) {
        return this.functionToApply.apply(a -> a.isSubsetOf(values));
    }

    @Override
    public final CompletableResult isSubsetOf(Iterable<ITERABLE_TYPE> values) {
        return this.functionToApply.apply(a -> a.isSubsetOf(values));
    }

    @Override
    @SafeVarargs
    public final CompletableResult isNotSubsetOf(ITERABLE_TYPE... values) {
        return this.functionToApply.apply(a -> a.isNotSubsetOf(values));
    }

    @Override
    public final CompletableResult isNotSubsetOf(Iterable<ITERABLE_TYPE> values) {
        return this.functionToApply.apply(a -> a.isNotSubsetOf(values));
    }

    @Override
    public final CompletableResult isEmpty() {
        return this.functionToApply.apply(AbstractIterableCondition::isEmpty);
    }

    @Override
    public final CompletableResult isNotEmpty() {
        return this.functionToApply.apply(AbstractIterableCondition::isNotEmpty);
    }

    @Override
    public final CompletableResult doesNotHasAnyElementsOfTypes(Class<?>... values) {
        return this.functionToApply.apply(a -> a.doesNotHasAnyElementsOfTypes(values));
    }

    @Override
    public final CompletableResult doesNotHasAnyElementsOfTypes(Iterable<Class<?>> values) {
        return this.functionToApply.apply(a -> a.doesNotHasAnyElementsOfTypes(values));
    }

    @Override
    public final CompletableResult hasAnyElementsOfTypes(Class<?>... values) {
        return this.functionToApply.apply(a -> a.hasAnyElementsOfTypes(values));
    }

    @Override
    public final CompletableResult hasAnyElementsOfTypes(Iterable<Class<?>> values) {
        return this.functionToApply.apply(a -> a.hasAnyElementsOfTypes(values));
    }

    @Override
    public final CompletableResult doesNotContainsNull() {
        return this.functionToApply.apply(AbstractIterableCondition::doesNotContainsNull);
    }

    @Override
    public final CompletableResult containsNull() {
        return this.functionToApply.apply(AbstractIterableCondition::containsNull);
    }

    @Override
    public final CompletableResult containsOnlyNull() {
        return this.functionToApply.apply(AbstractIterableCondition::containsOnlyNull);
    }

    @Override
    public final CompletableResult doesNotContainsOnlyNull() {
        return this.functionToApply.apply(AbstractIterableCondition::doesNotContainsOnlyNull);
    }

    @Override
    public final CompletableResult hasDuplicate() {
        return this.functionToApply.apply(AbstractIterableCondition::hasDuplicate);
    }

    @Override
    public final CompletableResult doesNotHasDuplicate() {
        return this.functionToApply.apply(AbstractIterableCondition::doesNotHasDuplicate);
    }

    @Override
    public final CompletableResult anyMatch(Predicate<? super ITERABLE_TYPE> predicate) {
        return this.functionToApply.apply(a -> a.anyMatch(predicate));
    }

    @Override
    public final CompletableResult allMatch(Predicate<? super ITERABLE_TYPE> predicate) {
        return this.functionToApply.apply(a -> a.allMatch(predicate));
    }

    @Override
    public final CompletableResult noneMatch(Predicate<? super ITERABLE_TYPE> predicate) {
        return this.functionToApply.apply(a -> a.noneMatch(predicate));

    }

    @Override
    public final CompletableResult hasSameSizeAs(ITERABLE_TYPE[] value) {
        return this.functionToApply.apply(a -> a.hasSameSizeAs(value));
    }

    @Override
    public final CompletableResult hasSize(long size) {
        return this.functionToApply.apply(a -> a.hasSize(size));
    }

    @Override
    public final CompletableResult hasSizeBetween(long start, long end) {
        return this.functionToApply.apply(a -> a.hasSizeBetween(start, end));
    }

    @Override
    public final CompletableResult hasSizeGreaterThan(long size) {
        return this.functionToApply.apply(a -> a.hasSizeGreaterThan(size));
    }

    @Override
    public final CompletableResult hasSizeGreaterThanOrEqualTo(long size) {
        return this.functionToApply.apply(a -> a.hasSizeGreaterThanOrEqualTo(size));
    }

    @Override
    public final CompletableResult hasSizeLessThan(long size) {
        return this.functionToApply.apply(a -> a.hasSizeLessThan(size));
    }

    @Override
    public final CompletableResult hasSizeLessThanOrEqualTo(long size) {
        return this.functionToApply.apply(a -> a.hasSizeLessThanOrEqualTo(size));
    }

    @Override
    public final CompletableResult hasSizeDifferentFrom(long size) {
        return this.functionToApply.apply(a -> a.hasSizeDifferentFrom(size));
    }

}
