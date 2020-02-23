package dev.ksarou.wotif.core.condition.typed.iterable;

import dev.ksarou.wotif.core.condition.ICondition;
import dev.ksarou.wotif.core.Completable;

import java.util.function.Predicate;

public interface IIterableCondition<T,I, R> extends ICondition<I, R> {

    Completable<R> contains(T... values);

    Completable<R> doesNotContains(T... values);

    Completable<R> contains(Iterable<T> values);

    Completable<R> doesNotContains(Iterable<T> values);

    Completable<R> containsAnyOf(T... values);

    Completable<R> containsAnyOf(Iterable<T> values);

    Completable<R> containsOnly(T... values);

    Completable<R> containsOnly(Iterable<T> values);

    Completable<R> doesNotContainsOnly(T... values);

    Completable<R> doesNotContainsOnly(Iterable<T> values);

    Completable<R> containsOnlyOnce(T... values);

    Completable<R> containsOnlyOnce(Iterable<T> values);

    Completable<R> containsMoreThanOnce(T... values);

    Completable<R> containsMoreThanOnce(Iterable<T> values);

    Completable<R> startsWith(T value);

    Completable<R> doesNotStartsWith(T value);

    Completable<R> endsWith(T value);

    Completable<R> doesNotEndsWith(T value);

    Completable<R> isSubsetOf(T... values);

    Completable<R> isSubsetOf(Iterable<T> values);

    Completable<R> isNotSubsetOf(T... values);

    Completable<R> isNotSubsetOf(Iterable<T> values);

    Completable<R> isEmpty();

    Completable<R> isNotEmpty();

    Completable<R> doesNotHasAnyElementsOfTypes(Class<?>... values);

    Completable<R> doesNotHasAnyElementsOfTypes(Iterable<Class<?>> values);

    Completable<R> hasAnyElementsOfTypes(Class<?>... values);

    Completable<R> hasAnyElementsOfTypes(Iterable<Class<?>> values);

    Completable<R> doesNotContainsNull();

    Completable<R> containsNull();

    Completable<R> containsOnlyNull();

    Completable<R> doesNotContainsOnlyNull();

    Completable<R> hasDuplicate();

    Completable<R> doesNotHasDuplicate();

    Completable<R> anyMatch(Predicate<? super T> predicate);

    Completable<R> allMatch(Predicate<? super T> predicate);

    Completable<R> noneMatch(Predicate<? super T> predicate);

    Completable<R> hasSameSizeAs(T[] value);

    Completable<R> hasSize(long size);

    Completable<R> hasSizeBetween(long start, long end);

    Completable<R> hasSizeGreaterThan(long size);

    Completable<R> hasSizeGreaterThanOrEqualTo(long size);

    Completable<R> hasSizeLessThan(long size);

    Completable<R> hasSizeLessThanOrEqualTo(long size);

    Completable<R> hasSizeDifferentFrom(long size);

}
