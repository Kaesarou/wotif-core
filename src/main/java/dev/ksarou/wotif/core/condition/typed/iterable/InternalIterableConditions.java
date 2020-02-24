/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.iterable;

import dev.ksarou.wotif.core.Term;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class InternalIterableConditions<T> {

    private final Term<Iterable<T>> terms;

    InternalIterableConditions(Iterable<T> term) {
        this.terms = new Term<>(term);
    }

    private Stream<T> stream() {
        return stream(this.terms.value());
    }

    private <S> Stream<S> stream(Iterable<S> values) {
        return StreamSupport.stream(values.spliterator(), false);
    }

    private boolean isIn(T value, Stream<T> container) {
        return container.anyMatch(e -> e.equals(value));
    }

    private boolean isIn(Class<?> value) {
        return stream().anyMatch(value::isInstance);
    }

    boolean contains(Iterable<T> values) {
        return stream(values).allMatch(e -> this.isIn(e, stream()));
    }

    boolean containsAnyOf(Iterable<T> values) {
        return stream(values).anyMatch(e -> this.isIn(e, stream()));
    }

    boolean containsOnly(Iterable<T> values) {
        return this.contains(values) && stream(values).count() == stream().count();
    }

    boolean containsOnlyOnce(Iterable<T> values) {
        return stream(values)
                .allMatch(e -> stream().filter(l -> l.equals(e)).count() == 1);
    }

    boolean containsMoreThanOnce(Iterable<T> values) {
        return stream(values)
                .allMatch(e -> stream().filter(l -> l.equals(e)).count() > 1);
    }

    boolean startsWith(T value) {
        return stream().collect(Collectors.toList()).get(0).equals(value);
    }

    boolean endsWith(T value) {
        List<T> collect = stream().collect(Collectors.toList());
        return collect.get(collect.size() - 1).equals(value);
    }

    boolean isSubsetOf(Iterable<T> values) {
        return stream().allMatch(e -> this.isIn(e, stream(values)));
    }

    boolean isEmpty() {
        return stream().count() == 0;
    }

    boolean hasAnyElementsOfTypes(Iterable<Class<?>> values) {
        return stream(values).anyMatch(this::isIn);
    }

    boolean containsNull() {
        return stream().anyMatch(Objects::isNull);
    }

    boolean containsOnlyNull() {
        return stream().allMatch(Objects::isNull);
    }

    boolean hasDuplicate() {
        return !stream().allMatch(new HashSet<>()::add);
    }

    boolean anyMatch(Predicate<? super T> predicate) {
        return stream().anyMatch(predicate);
    }

    boolean allMatch(Predicate<? super T> predicate) {
        return stream().anyMatch(predicate);
    }

    boolean noneMatch(Predicate<? super T> predicate) {
        return stream().anyMatch(predicate);
    }

    boolean hasSize(long value) {
        return stream().count() == value;
    }

    boolean hasSameSizeAs(Iterable<T> values) {
        return hasSize(stream(values).count());
    }

    boolean hasSizeBetween(long start, long end) {
        return stream().count() >= start && stream().count() <= end;
    }

    boolean hasSizeGreaterThan(long size) {
        return stream().count() > size;
    }

    boolean hasSizeGreaterThanOrEqualTo(long size) {
        return stream().count() >= size;
    }

    boolean hasSizeLessThan(long size) {
        return stream().count() < size;
    }

    boolean hasSizeLessThanOrEqualTo(long size) {
        return stream().count() <= size;
    }

}
