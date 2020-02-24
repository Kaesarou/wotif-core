/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.iterable;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.AbstractJoinCondition;
import dev.ksarou.wotif.core.condition.JoinEnum;

import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractIterableJoinCondition<T, I>
        extends AbstractJoinCondition<I, AbstractIterableCondition<T, I>>
        implements IIterableCondition<T, I, List<I>> {

    @SafeVarargs
    public AbstractIterableJoinCondition(JoinEnum joinType, I... terms) {
        super(joinType, terms);
    }

    @Override
    @SafeVarargs
    public final Completable<List<I>> contains(T... values) {
        return this.functionToApply.apply(a -> a.contains(values));
    }

    @Override
    @SafeVarargs
    public final Completable<List<I>> doesNotContains(T... values) {
        return this.functionToApply.apply(a -> a.doesNotContains(values));
    }

    @Override
    public final Completable<List<I>> contains(Iterable<T> values) {
        return this.functionToApply.apply(a -> a.contains(values));
    }

    @Override
    public final Completable<List<I>> doesNotContains(Iterable<T> values) {
        return this.functionToApply.apply(a -> a.doesNotContains(values));
    }

    @Override
    @SafeVarargs
    public final Completable<List<I>> containsAnyOf(T... values) {
        return this.functionToApply.apply(a -> a.containsAnyOf(values));
    }

    @Override
    public final Completable<List<I>> containsAnyOf(Iterable<T> values) {
        return this.functionToApply.apply(a -> a.containsAnyOf(values));
    }

    @Override
    @SafeVarargs
    public final Completable<List<I>> containsOnly(T... values) {
        return this.functionToApply.apply(a -> a.containsOnly(values));
    }

    @Override
    public final Completable<List<I>> containsOnly(Iterable<T> values) {
        return this.functionToApply.apply(a -> a.containsOnly(values));
    }

    @Override
    @SafeVarargs
    public final Completable<List<I>> doesNotContainsOnly(T... values) {
        return this.functionToApply.apply(a -> a.doesNotContainsOnly(values));
    }

    @Override
    public final Completable<List<I>> doesNotContainsOnly(Iterable<T> values) {
        return this.functionToApply.apply(a -> a.doesNotContainsOnly(values));
    }

    @Override
    @SafeVarargs
    public final Completable<List<I>> containsOnlyOnce(T... values) {
        return this.functionToApply.apply(a -> a.containsOnlyOnce(values));
    }

    @Override
    public final Completable<List<I>> containsOnlyOnce(Iterable<T> values) {
        return this.functionToApply.apply(a -> a.containsOnlyOnce(values));
    }

    @Override
    @SafeVarargs
    public final Completable<List<I>> containsMoreThanOnce(T... values) {
        return this.functionToApply.apply(a -> a.containsMoreThanOnce(values));
    }

    @Override
    public final Completable<List<I>> containsMoreThanOnce(Iterable<T> values) {
        return this.functionToApply.apply(a -> a.containsMoreThanOnce(values));
    }

    @Override
    public final Completable<List<I>> startsWith(T value) {
        return this.functionToApply.apply(a -> a.startsWith(value));
    }

    @Override
    public final Completable<List<I>> doesNotStartsWith(T value) {
        return this.functionToApply.apply(a -> a.doesNotStartsWith(value));
    }

    @Override
    public final Completable<List<I>> endsWith(T value) {
        return this.functionToApply.apply(a -> a.endsWith(value));
    }

    @Override
    public final Completable<List<I>> doesNotEndsWith(T value) {
        return this.functionToApply.apply(a -> a.doesNotEndsWith(value));
    }

    @Override
    @SafeVarargs
    public final Completable<List<I>> isSubsetOf(T... values) {
        return this.functionToApply.apply(a -> a.isSubsetOf(values));
    }

    @Override
    public final Completable<List<I>> isSubsetOf(Iterable<T> values) {
        return this.functionToApply.apply(a -> a.isSubsetOf(values));
    }

    @Override
    @SafeVarargs
    public final Completable<List<I>> isNotSubsetOf(T... values) {
        return this.functionToApply.apply(a -> a.isNotSubsetOf(values));
    }

    @Override
    public final Completable<List<I>> isNotSubsetOf(Iterable<T> values) {
        return this.functionToApply.apply(a -> a.isNotSubsetOf(values));
    }

    @Override
    public final Completable<List<I>> isEmpty() {
        return this.functionToApply.apply(AbstractIterableCondition::isEmpty);
    }

    @Override
    public final Completable<List<I>> isNotEmpty() {
        return this.functionToApply.apply(AbstractIterableCondition::isNotEmpty);
    }

    @Override
    public final Completable<List<I>> doesNotHasAnyElementsOfTypes(Class<?>... values) {
        return this.functionToApply.apply(a -> a.doesNotHasAnyElementsOfTypes(values));
    }

    @Override
    public final Completable<List<I>> doesNotHasAnyElementsOfTypes(Iterable<Class<?>> values) {
        return this.functionToApply.apply(a -> a.doesNotHasAnyElementsOfTypes(values));
    }

    @Override
    public final Completable<List<I>> hasAnyElementsOfTypes(Class<?>... values) {
        return this.functionToApply.apply(a -> a.hasAnyElementsOfTypes(values));
    }

    @Override
    public final Completable<List<I>> hasAnyElementsOfTypes(Iterable<Class<?>> values) {
        return this.functionToApply.apply(a -> a.hasAnyElementsOfTypes(values));
    }

    @Override
    public final Completable<List<I>> doesNotContainsNull() {
        return this.functionToApply.apply(AbstractIterableCondition::doesNotContainsNull);
    }

    @Override
    public final Completable<List<I>> containsNull() {
        return this.functionToApply.apply(AbstractIterableCondition::containsNull);
    }

    @Override
    public final Completable<List<I>> containsOnlyNull() {
        return this.functionToApply.apply(AbstractIterableCondition::containsOnlyNull);
    }

    @Override
    public final Completable<List<I>> doesNotContainsOnlyNull() {
        return this.functionToApply.apply(AbstractIterableCondition::doesNotContainsOnlyNull);
    }

    @Override
    public final Completable<List<I>> hasDuplicate() {
        return this.functionToApply.apply(AbstractIterableCondition::hasDuplicate);
    }

    @Override
    public final Completable<List<I>> doesNotHasDuplicate() {
        return this.functionToApply.apply(AbstractIterableCondition::doesNotHasDuplicate);
    }

    @Override
    public final Completable<List<I>> anyMatch(Predicate<? super T> predicate) {
        return this.functionToApply.apply(a -> a.anyMatch(predicate));
    }

    @Override
    public final Completable<List<I>> allMatch(Predicate<? super T> predicate) {
        return this.functionToApply.apply(a -> a.allMatch(predicate));
    }

    @Override
    public final Completable<List<I>> noneMatch(Predicate<? super T> predicate) {
        return this.functionToApply.apply(a -> a.noneMatch(predicate));

    }

    @Override
    public final Completable<List<I>> hasSameSizeAs(T[] value) {
        return this.functionToApply.apply(a -> a.hasSameSizeAs(value));
    }

    @Override
    public final Completable<List<I>> hasSize(long size) {
        return this.functionToApply.apply(a -> a.hasSize(size));
    }

    @Override
    public final Completable<List<I>> hasSizeBetween(long start, long end) {
        return this.functionToApply.apply(a -> a.hasSizeBetween(start, end));
    }

    @Override
    public final Completable<List<I>> hasSizeGreaterThan(long size) {
        return this.functionToApply.apply(a -> a.hasSizeGreaterThan(size));
    }

    @Override
    public final Completable<List<I>> hasSizeGreaterThanOrEqualTo(long size) {
        return this.functionToApply.apply(a -> a.hasSizeGreaterThanOrEqualTo(size));
    }

    @Override
    public final Completable<List<I>> hasSizeLessThan(long size) {
        return this.functionToApply.apply(a -> a.hasSizeLessThan(size));
    }

    @Override
    public final Completable<List<I>> hasSizeLessThanOrEqualTo(long size) {
        return this.functionToApply.apply(a -> a.hasSizeLessThanOrEqualTo(size));
    }

    @Override
    public final Completable<List<I>> hasSizeDifferentFrom(long size) {
        return this.functionToApply.apply(a -> a.hasSizeDifferentFrom(size));
    }

}
