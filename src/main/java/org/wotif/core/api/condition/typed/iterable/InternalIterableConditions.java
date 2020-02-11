package org.wotif.core.api.condition.typed.iterable;

import org.wotif.core.api.Term;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class InternalIterableConditions<TYPE> {

    private final Term<Iterable<TYPE>> terms;

    InternalIterableConditions(Iterable<TYPE> term) {
        this.terms = new Term<>(term);
    }

    private Stream<TYPE> stream() {
        return stream(this.terms.value());
    }

    private <T> Stream<T> stream(Iterable<T> values) {
        return StreamSupport.stream(values.spliterator(), false);
    }

    private boolean isIn(TYPE value, Stream<TYPE> container) {
        return container.anyMatch(e -> e.equals(value));
    }

    private boolean isIn(Class<?> value) {
        return stream().anyMatch(e -> e.getClass().equals(value));
    }

    boolean contains(Iterable<TYPE> values) {
        return stream(values).allMatch(e -> this.isIn(e, stream()));
    }

    boolean containsAnyOf(Iterable<TYPE> values) {
        return stream(values).anyMatch(e -> this.isIn(e, stream()));
    }

    boolean containsOnly(Iterable<TYPE> values) {
        return this.contains(values) && stream(values).count() == stream().count();
    }

    boolean containsOnlyOnce(Iterable<TYPE> values) {
        return stream(values)
                .allMatch(e -> stream().filter(l -> l.equals(e)).count() == 1);
    }

    boolean containsMoreThanOnce(Iterable<TYPE> values) {
        return stream(values)
                .allMatch(e -> stream().filter(l -> l.equals(e)).count() > 1);
    }

    boolean startsWith(TYPE value) {
        return stream().collect(Collectors.toList()).get(0).equals(value);
    }

    boolean endsWith(TYPE value) {
        List<TYPE> collect = stream().collect(Collectors.toList());
        return collect.get(collect.size() - 1).equals(value);
    }

    boolean isSubsetOf(Iterable<TYPE> values) {
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

    boolean anyMatch(Predicate<? super TYPE> predicate) {
        return stream().anyMatch(predicate);
    }

    boolean allMatch(Predicate<? super TYPE> predicate) {
        return stream().anyMatch(predicate);
    }

    boolean noneMatch(Predicate<? super TYPE> predicate) {
        return stream().anyMatch(predicate);
    }

    boolean hasSize(long value) {
        return stream().count() == value;
    }

    boolean hasSameSizeAs(Iterable<TYPE> values) {
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
