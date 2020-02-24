/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.iterable;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.AbstractCondition;

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
    public final Completable<I> contains(T... values) {
        boolean result = this.internalIterables.contains(Arrays.asList(values));
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> contains(Iterable<T> values) {
        boolean result = this.internalIterables.contains(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    public final Completable<I> doesNotContains(T... values) {
        boolean result = !this.internalIterables.contains(Arrays.asList(values));
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> doesNotContains(Iterable<T> values) {
        boolean result = !this.internalIterables.contains(values);
        return new Completable<>(term, result);
    }


    @Override
    @SafeVarargs
    public final Completable<I> containsAnyOf(T... values) {
        boolean result = this.internalIterables.containsAnyOf(Arrays.asList(values));
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> containsAnyOf(Iterable<T> values) {
        boolean result = this.internalIterables.containsAnyOf(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    public final Completable<I> containsOnly(T... values) {
        boolean result = this.internalIterables.containsOnly(Arrays.asList(values));
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> containsOnly(Iterable<T> values) {
        boolean result = this.internalIterables.containsOnly(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    public final Completable<I> doesNotContainsOnly(T... values) {
        boolean result = !this.internalIterables.containsOnly(Arrays.asList(values));
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> doesNotContainsOnly(Iterable<T> values) {
        boolean result = !this.internalIterables.containsOnly(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    public final Completable<I> containsOnlyOnce(T... values) {
        boolean result = this.internalIterables.containsOnlyOnce(Arrays.asList(values));
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> containsOnlyOnce(Iterable<T> values) {
        boolean result = this.internalIterables.containsOnly(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    public final Completable<I> containsMoreThanOnce(T... values) {
        boolean result = this.internalIterables.containsMoreThanOnce(Arrays.asList(values));
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> containsMoreThanOnce(Iterable<T> values) {
        boolean result = this.internalIterables.containsMoreThanOnce(values);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> startsWith(T value) {
        boolean result = this.internalIterables.startsWith(value);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> doesNotStartsWith(T value) {
        boolean result = !this.internalIterables.startsWith(value);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> endsWith(T value) {
        boolean result = this.internalIterables.endsWith(value);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> doesNotEndsWith(T value) {
        boolean result = !this.internalIterables.endsWith(value);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    public final Completable<I> isSubsetOf(T... values) {
        boolean result = this.internalIterables.isSubsetOf(Arrays.asList(values));
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> isSubsetOf(Iterable<T> values) {
        boolean result = this.internalIterables.isSubsetOf(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    public final Completable<I> isNotSubsetOf(T... values) {
        boolean result = !this.internalIterables.isSubsetOf(Arrays.asList(values));
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> isNotSubsetOf(Iterable<T> values) {
        boolean result = !this.internalIterables.isSubsetOf(values);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> isEmpty() {
        boolean result = this.internalIterables.isEmpty();
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> isNotEmpty() {
        boolean result = this.internalIterables.isEmpty();
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> doesNotHasAnyElementsOfTypes(Class<?>... values) {
        boolean result = !this.internalIterables.hasAnyElementsOfTypes(Arrays.asList(values));
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> doesNotHasAnyElementsOfTypes(Iterable<Class<?>> values) {
        boolean result = !this.internalIterables.hasAnyElementsOfTypes(values);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> hasAnyElementsOfTypes(Class<?>... values) {
        boolean result = this.internalIterables.hasAnyElementsOfTypes(Arrays.asList(values));
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> hasAnyElementsOfTypes(Iterable<Class<?>> values) {
        boolean result = this.internalIterables.hasAnyElementsOfTypes(values);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> doesNotContainsNull() {
        boolean result = !this.internalIterables.containsNull();
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> containsNull() {
        boolean result = this.internalIterables.containsNull();
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> containsOnlyNull() {
        boolean result = this.internalIterables.containsOnlyNull();
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> doesNotContainsOnlyNull() {
        boolean result = !this.internalIterables.containsOnlyNull();
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> hasDuplicate() {
        boolean result = this.internalIterables.hasDuplicate();
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> doesNotHasDuplicate() {
        boolean result = !this.internalIterables.hasDuplicate();
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> anyMatch(Predicate<? super T> predicate) {
        boolean result = this.internalIterables.anyMatch(predicate);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> allMatch(Predicate<? super T> predicate) {
        boolean result = this.internalIterables.allMatch(predicate);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> noneMatch(Predicate<? super T> predicate) {
        boolean result = this.internalIterables.noneMatch(predicate);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> hasSameSizeAs(T[] value) {
        boolean result = this.internalIterables.hasSameSizeAs(Arrays.asList(value));
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> hasSize(long size) {
        boolean result = this.internalIterables.hasSize(size);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> hasSizeBetween(long start, long end) {
        boolean result = this.internalIterables.hasSizeBetween(start, end);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> hasSizeGreaterThan(long size) {
        boolean result = this.internalIterables.hasSizeGreaterThan(size);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> hasSizeGreaterThanOrEqualTo(long size) {
        boolean result = this.internalIterables.hasSizeGreaterThanOrEqualTo(size);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> hasSizeLessThan(long size) {
        boolean result = this.internalIterables.hasSizeLessThan(size);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> hasSizeLessThanOrEqualTo(long size) {
        boolean result = this.internalIterables.hasSizeLessThanOrEqualTo(size);
        return new Completable<>(term, result);
    }

    @Override
    public final Completable<I> hasSizeDifferentFrom(long size) {
        boolean result = !this.internalIterables.hasSize(size);
        return new Completable<>(term, result);
    }

}
