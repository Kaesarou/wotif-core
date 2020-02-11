package org.wotif.core.api.condition.typed.iterable;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.AbstractCondition;

import java.util.Arrays;
import java.util.function.Predicate;

public abstract class AbstractIterableCondition<ITERABLE_TYPE, ITERABLE> extends AbstractCondition<ITERABLE>
        implements IIterableCondition<ITERABLE_TYPE, ITERABLE> {

    InternalIterableConditions<ITERABLE_TYPE> internalIterables;

    abstract protected Iterable<ITERABLE_TYPE> iterable();

    public AbstractIterableCondition(ITERABLE term) {
        super(term);
        this.internalIterables = new InternalIterableConditions<>(iterable());
    }

    @Override
    @SafeVarargs
    public final CompletableResult contains(ITERABLE_TYPE... values) {
        boolean result = this.internalIterables.contains(Arrays.asList(values));
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult contains(Iterable<ITERABLE_TYPE> values) {
        boolean result = this.internalIterables.contains(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    public final CompletableResult doesNotContains(ITERABLE_TYPE... values) {
        boolean result = !this.internalIterables.contains(Arrays.asList(values));
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult doesNotContains(Iterable<ITERABLE_TYPE> values) {
        boolean result = !this.internalIterables.contains(values);
        return new CompletableResult(result);
    }


    @Override
    @SafeVarargs
    public final CompletableResult containsAnyOf(ITERABLE_TYPE... values) {
        boolean result = this.internalIterables.containsAnyOf(Arrays.asList(values));
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult containsAnyOf(Iterable<ITERABLE_TYPE> values) {
        boolean result = this.internalIterables.containsAnyOf(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    public final CompletableResult containsOnly(ITERABLE_TYPE... values) {
        boolean result = this.internalIterables.containsOnly(Arrays.asList(values));
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult containsOnly(Iterable<ITERABLE_TYPE> values) {
        boolean result = this.internalIterables.containsOnly(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    public final CompletableResult doesNotContainsOnly(ITERABLE_TYPE... values) {
        boolean result = !this.internalIterables.containsOnly(Arrays.asList(values));
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult doesNotContainsOnly(Iterable<ITERABLE_TYPE> values) {
        boolean result = !this.internalIterables.containsOnly(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    public final CompletableResult containsOnlyOnce(ITERABLE_TYPE... values) {
        boolean result = this.internalIterables.containsOnlyOnce(Arrays.asList(values));
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult containsOnlyOnce(Iterable<ITERABLE_TYPE> values) {
        boolean result = this.internalIterables.containsOnly(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    public final CompletableResult containsMoreThanOnce(ITERABLE_TYPE... values) {
        boolean result = this.internalIterables.containsMoreThanOnce(Arrays.asList(values));
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult containsMoreThanOnce(Iterable<ITERABLE_TYPE> values) {
        boolean result = this.internalIterables.containsMoreThanOnce(values);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult startsWith(ITERABLE_TYPE value) {
        boolean result = this.internalIterables.startsWith(value);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult doesNotStartsWith(ITERABLE_TYPE value) {
        boolean result = !this.internalIterables.startsWith(value);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult endsWith(ITERABLE_TYPE value) {
        boolean result = this.internalIterables.endsWith(value);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult doesNotEndsWith(ITERABLE_TYPE value) {
        boolean result = !this.internalIterables.endsWith(value);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    public final CompletableResult isSubsetOf(ITERABLE_TYPE... values) {
        boolean result = this.internalIterables.isSubsetOf(Arrays.asList(values));
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult isSubsetOf(Iterable<ITERABLE_TYPE> values) {
        boolean result = this.internalIterables.isSubsetOf(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    public final CompletableResult isNotSubsetOf(ITERABLE_TYPE... values) {
        boolean result = !this.internalIterables.isSubsetOf(Arrays.asList(values));
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult isNotSubsetOf(Iterable<ITERABLE_TYPE> values) {
        boolean result = !this.internalIterables.isSubsetOf(values);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult isEmpty() {
        boolean result = this.internalIterables.isEmpty();
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult isNotEmpty() {
        boolean result = this.internalIterables.isEmpty();
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult doesNotHasAnyElementsOfTypes(Class<?>... values) {
        boolean result = !this.internalIterables.hasAnyElementsOfTypes(Arrays.asList(values));
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult doesNotHasAnyElementsOfTypes(Iterable<Class<?>> values) {
        boolean result = !this.internalIterables.hasAnyElementsOfTypes(values);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult hasAnyElementsOfTypes(Class<?>... values) {
        boolean result = this.internalIterables.hasAnyElementsOfTypes(Arrays.asList(values));
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult hasAnyElementsOfTypes(Iterable<Class<?>> values) {
        boolean result = this.internalIterables.hasAnyElementsOfTypes(values);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult doesNotContainsNull() {
        boolean result = !this.internalIterables.containsNull();
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult containsNull() {
        boolean result = this.internalIterables.containsNull();
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult containsOnlyNull() {
        boolean result = this.internalIterables.containsOnlyNull();
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult doesNotContainsOnlyNull() {
        boolean result = !this.internalIterables.containsOnlyNull();
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult hasDuplicate() {
        boolean result = this.internalIterables.hasDuplicate();
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult doesNotHasDuplicate() {
        boolean result = !this.internalIterables.hasDuplicate();
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult anyMatch(Predicate<? super ITERABLE_TYPE> predicate) {
        boolean result = this.internalIterables.anyMatch(predicate);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult allMatch(Predicate<? super ITERABLE_TYPE> predicate) {
        boolean result = this.internalIterables.allMatch(predicate);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult noneMatch(Predicate<? super ITERABLE_TYPE> predicate) {
        boolean result = this.internalIterables.noneMatch(predicate);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult hasSameSizeAs(ITERABLE_TYPE[] value) {
        boolean result = this.internalIterables.hasSameSizeAs(Arrays.asList(value));
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult hasSize(long size) {
        boolean result = this.internalIterables.hasSize(size);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult hasSizeBetween(long start, long end) {
        boolean result = this.internalIterables.hasSizeBetween(start, end);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult hasSizeGreaterThan(long size) {
        boolean result = this.internalIterables.hasSizeGreaterThan(size);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult hasSizeGreaterThanOrEqualTo(long size) {
        boolean result = this.internalIterables.hasSizeGreaterThanOrEqualTo(size);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult hasSizeLessThan(long size) {
        boolean result = this.internalIterables.hasSizeLessThan(size);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult hasSizeLessThanOrEqualTo(long size) {
        boolean result = this.internalIterables.hasSizeLessThanOrEqualTo(size);
        return new CompletableResult(result);
    }

    @Override
    public final CompletableResult hasSizeDifferentFrom(long size) {
        boolean result = !this.internalIterables.hasSize(size);
        return new CompletableResult(result);
    }

}
