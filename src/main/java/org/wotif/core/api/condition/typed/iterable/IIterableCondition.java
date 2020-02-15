package org.wotif.core.api.condition.typed.iterable;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.ICondition;

import java.util.function.Predicate;

public interface IIterableCondition<T,I, R> extends ICondition<I, R> {

    CompletableResult<R> contains(T... values);

    CompletableResult<R> doesNotContains(T... values);

    CompletableResult<R> contains(Iterable<T> values);

    CompletableResult<R> doesNotContains(Iterable<T> values);

    CompletableResult<R> containsAnyOf(T... values);

    CompletableResult<R> containsAnyOf(Iterable<T> values);

    CompletableResult<R> containsOnly(T... values);

    CompletableResult<R> containsOnly(Iterable<T> values);

    CompletableResult<R> doesNotContainsOnly(T... values);

    CompletableResult<R> doesNotContainsOnly(Iterable<T> values);

    CompletableResult<R> containsOnlyOnce(T... values);

    CompletableResult<R> containsOnlyOnce(Iterable<T> values);

    CompletableResult<R> containsMoreThanOnce(T... values);

    CompletableResult<R> containsMoreThanOnce(Iterable<T> values);

    CompletableResult<R> startsWith(T value);

    CompletableResult<R> doesNotStartsWith(T value);

    CompletableResult<R> endsWith(T value);

    CompletableResult<R> doesNotEndsWith(T value);

    CompletableResult<R> isSubsetOf(T... values);

    CompletableResult<R> isSubsetOf(Iterable<T> values);

    CompletableResult<R> isNotSubsetOf(T... values);

    CompletableResult<R> isNotSubsetOf(Iterable<T> values);

    CompletableResult<R> isEmpty();

    CompletableResult<R> isNotEmpty();

    CompletableResult<R> doesNotHasAnyElementsOfTypes(Class<?>... values);

    CompletableResult<R> doesNotHasAnyElementsOfTypes(Iterable<Class<?>> values);

    CompletableResult<R> hasAnyElementsOfTypes(Class<?>... values);

    CompletableResult<R> hasAnyElementsOfTypes(Iterable<Class<?>> values);

    CompletableResult<R> doesNotContainsNull();

    CompletableResult<R> containsNull();

    CompletableResult<R> containsOnlyNull();

    CompletableResult<R> doesNotContainsOnlyNull();

    CompletableResult<R> hasDuplicate();

    CompletableResult<R> doesNotHasDuplicate();

    CompletableResult<R> anyMatch(Predicate<? super T> predicate);

    CompletableResult<R> allMatch(Predicate<? super T> predicate);

    CompletableResult<R> noneMatch(Predicate<? super T> predicate);

    CompletableResult<R> hasSameSizeAs(T[] value);

    CompletableResult<R> hasSize(long size);

    CompletableResult<R> hasSizeBetween(long start, long end);

    CompletableResult<R> hasSizeGreaterThan(long size);

    CompletableResult<R> hasSizeGreaterThanOrEqualTo(long size);

    CompletableResult<R> hasSizeLessThan(long size);

    CompletableResult<R> hasSizeLessThanOrEqualTo(long size);

    CompletableResult<R> hasSizeDifferentFrom(long size);

}
