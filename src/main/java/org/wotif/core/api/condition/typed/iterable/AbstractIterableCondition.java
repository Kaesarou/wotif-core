package org.wotif.core.api.condition.typed.iterable;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.AbstractCondition;

import java.util.Arrays;
import java.util.function.Predicate;

public abstract class AbstractIterableCondition<T, I> extends AbstractCondition<I>
        implements IIterableCondition<T, I, I> {

    protected InternalIterableConditions<T> internalIterables;

    abstract protected Iterable<T> iterable();

    public AbstractIterableCondition(I term) {
        super(term);
        this.internalIterables = new InternalIterableConditions<>(iterable());
    }

    @Override
    @SafeVarargs
    public final CompletableResult<I> contains(T... values) {
        boolean result = this.internalIterables.contains(Arrays.asList(values));
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> contains(Iterable<T> values) {
        boolean result = this.internalIterables.contains(values);
        return new CompletableResult<>(term, result);
    }

    @Override
    @SafeVarargs
    public final CompletableResult<I> doesNotContains(T... values) {
        boolean result = !this.internalIterables.contains(Arrays.asList(values));
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> doesNotContains(Iterable<T> values) {
        boolean result = !this.internalIterables.contains(values);
        return new CompletableResult<>(term, result);
    }


    @Override
    @SafeVarargs
    public final CompletableResult<I> containsAnyOf(T... values) {
        boolean result = this.internalIterables.containsAnyOf(Arrays.asList(values));
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> containsAnyOf(Iterable<T> values) {
        boolean result = this.internalIterables.containsAnyOf(values);
        return new CompletableResult<>(term, result);
    }

    @Override
    @SafeVarargs
    public final CompletableResult<I> containsOnly(T... values) {
        boolean result = this.internalIterables.containsOnly(Arrays.asList(values));
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> containsOnly(Iterable<T> values) {
        boolean result = this.internalIterables.containsOnly(values);
        return new CompletableResult<>(term, result);
    }

    @Override
    @SafeVarargs
    public final CompletableResult<I> doesNotContainsOnly(T... values) {
        boolean result = !this.internalIterables.containsOnly(Arrays.asList(values));
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> doesNotContainsOnly(Iterable<T> values) {
        boolean result = !this.internalIterables.containsOnly(values);
        return new CompletableResult<>(term, result);
    }

    @Override
    @SafeVarargs
    public final CompletableResult<I> containsOnlyOnce(T... values) {
        boolean result = this.internalIterables.containsOnlyOnce(Arrays.asList(values));
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> containsOnlyOnce(Iterable<T> values) {
        boolean result = this.internalIterables.containsOnly(values);
        return new CompletableResult<>(term, result);
    }

    @Override
    @SafeVarargs
    public final CompletableResult<I> containsMoreThanOnce(T... values) {
        boolean result = this.internalIterables.containsMoreThanOnce(Arrays.asList(values));
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> containsMoreThanOnce(Iterable<T> values) {
        boolean result = this.internalIterables.containsMoreThanOnce(values);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> startsWith(T value) {
        boolean result = this.internalIterables.startsWith(value);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> doesNotStartsWith(T value) {
        boolean result = !this.internalIterables.startsWith(value);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> endsWith(T value) {
        boolean result = this.internalIterables.endsWith(value);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> doesNotEndsWith(T value) {
        boolean result = !this.internalIterables.endsWith(value);
        return new CompletableResult<>(term, result);
    }

    @Override
    @SafeVarargs
    public final CompletableResult<I> isSubsetOf(T... values) {
        boolean result = this.internalIterables.isSubsetOf(Arrays.asList(values));
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> isSubsetOf(Iterable<T> values) {
        boolean result = this.internalIterables.isSubsetOf(values);
        return new CompletableResult<>(term, result);
    }

    @Override
    @SafeVarargs
    public final CompletableResult<I> isNotSubsetOf(T... values) {
        boolean result = !this.internalIterables.isSubsetOf(Arrays.asList(values));
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> isNotSubsetOf(Iterable<T> values) {
        boolean result = !this.internalIterables.isSubsetOf(values);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> isEmpty() {
        boolean result = this.internalIterables.isEmpty();
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> isNotEmpty() {
        boolean result = this.internalIterables.isEmpty();
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> doesNotHasAnyElementsOfTypes(Class<?>... values) {
        boolean result = !this.internalIterables.hasAnyElementsOfTypes(Arrays.asList(values));
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> doesNotHasAnyElementsOfTypes(Iterable<Class<?>> values) {
        boolean result = !this.internalIterables.hasAnyElementsOfTypes(values);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> hasAnyElementsOfTypes(Class<?>... values) {
        boolean result = this.internalIterables.hasAnyElementsOfTypes(Arrays.asList(values));
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> hasAnyElementsOfTypes(Iterable<Class<?>> values) {
        boolean result = this.internalIterables.hasAnyElementsOfTypes(values);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> doesNotContainsNull() {
        boolean result = !this.internalIterables.containsNull();
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> containsNull() {
        boolean result = this.internalIterables.containsNull();
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> containsOnlyNull() {
        boolean result = this.internalIterables.containsOnlyNull();
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> doesNotContainsOnlyNull() {
        boolean result = !this.internalIterables.containsOnlyNull();
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> hasDuplicate() {
        boolean result = this.internalIterables.hasDuplicate();
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> doesNotHasDuplicate() {
        boolean result = !this.internalIterables.hasDuplicate();
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> anyMatch(Predicate<? super T> predicate) {
        boolean result = this.internalIterables.anyMatch(predicate);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> allMatch(Predicate<? super T> predicate) {
        boolean result = this.internalIterables.allMatch(predicate);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> noneMatch(Predicate<? super T> predicate) {
        boolean result = this.internalIterables.noneMatch(predicate);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> hasSameSizeAs(T[] value) {
        boolean result = this.internalIterables.hasSameSizeAs(Arrays.asList(value));
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> hasSize(long size) {
        boolean result = this.internalIterables.hasSize(size);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> hasSizeBetween(long start, long end) {
        boolean result = this.internalIterables.hasSizeBetween(start, end);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> hasSizeGreaterThan(long size) {
        boolean result = this.internalIterables.hasSizeGreaterThan(size);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> hasSizeGreaterThanOrEqualTo(long size) {
        boolean result = this.internalIterables.hasSizeGreaterThanOrEqualTo(size);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> hasSizeLessThan(long size) {
        boolean result = this.internalIterables.hasSizeLessThan(size);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> hasSizeLessThanOrEqualTo(long size) {
        boolean result = this.internalIterables.hasSizeLessThanOrEqualTo(size);
        return new CompletableResult<>(term, result);
    }

    @Override
    public final CompletableResult<I> hasSizeDifferentFrom(long size) {
        boolean result = !this.internalIterables.hasSize(size);
        return new CompletableResult<>(term, result);
    }

}
