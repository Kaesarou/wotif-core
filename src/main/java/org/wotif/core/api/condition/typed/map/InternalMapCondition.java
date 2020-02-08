package org.wotif.core.api.condition.typed.map;

import org.wotif.core.api.Term;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

class InternalMapCondition<KEY, VALUE> {

    private Term<Map<KEY, VALUE>> term;

    private Stream<Map.Entry<KEY, VALUE>> stream() {
        return this.term.value().entrySet().stream();
    }

    private Stream<Map.Entry<KEY, VALUE>> stream(Map.Entry<KEY, VALUE>[] entries) {
        return Arrays.stream(entries);
    }

    private Stream<Map.Entry<KEY, VALUE>> stream(Map<KEY, VALUE> map) {
        return map.entrySet().stream();
    }

    private <T> Stream<T> stream(T[] array) {
        return Arrays.stream(array);
    }

    private boolean isIn(Stream<Map.Entry<KEY, VALUE>> entries, Map.Entry<KEY, VALUE> entry) {
        return entries.anyMatch(e -> e.equals(entry));
    }

    private boolean isInKeys(KEY key) {
        return stream().anyMatch(e -> e.getKey().equals(key));
    }

    private boolean isInValues(VALUE value) {
        return stream().anyMatch(e -> e.getValue().equals(value));
    }

    private boolean isInValuesOnlyOnce(VALUE value) {
        return stream().filter(e -> e.getValue().equals(value)).count() == 1;
    }
    private boolean isInValuesMoreThanOnce(VALUE value) {
        return stream().filter(e -> e.getValue().equals(value)).count() > 1;
    }


    private boolean isIn(Class<?> clazz) {
        return stream().anyMatch(e -> e.getValue().getClass().equals(clazz));
    }

    @SafeVarargs
    final boolean contains(Map.Entry<KEY, VALUE>... values) {
        return stream(values).allMatch(e -> isIn(stream(), e));
    }

    @SafeVarargs
    final boolean containsKeys(KEY... values) {
        return stream(values).allMatch(this::isInKeys);
    }

    @SafeVarargs
    final boolean containsValues(VALUE... values) {
        return stream(values).allMatch(this::isInValues);
    }

    final boolean containsAllEntriesOf(Map<KEY, VALUE> values) {
        return stream(values).allMatch(e -> isIn(stream(), e));
    }

    @SafeVarargs
    final boolean containsAnyOf(Map.Entry<KEY, VALUE>... values) {
        return stream(values).anyMatch(e -> isIn(stream(), e));
    }

    final boolean containsAnyEntriesOf(Map<KEY, VALUE> values) {
        return stream(values).anyMatch(e -> isIn(stream(), e));
    }

    @SafeVarargs
    final boolean containsOnly(Map.Entry<KEY, VALUE>... values) {
        return this.contains(values) && stream().count() == stream(values).count();
    }

    @SafeVarargs
    final boolean doesNotContainsOnly(Map.Entry<KEY, VALUE>... values) {
        return this.contains(values) && stream().count() > stream(values).count();
    }

    final boolean containsOnlyEntriesOf(Map<KEY, VALUE> values) {
        return containsAllEntriesOf(values) && stream().count() == stream(values).count();
    }

    final boolean doesNotContainsOnlyEntriesOf(Map<KEY, VALUE> values) {
        return containsAllEntriesOf(values) && stream().count() > stream(values).count();
    }

    @SafeVarargs
    final boolean containsOnlyOnceValues(VALUE... values) {
        return stream(values).allMatch(this::isInValuesOnlyOnce);
    }

    @SafeVarargs
    final boolean containsMoreThanOnceValues(VALUE... values) {
        return stream(values).allMatch(this::isInValuesMoreThanOnce);
    }

    final boolean isEmpty() {
        return this.term.value().isEmpty();
    }

    final boolean hasAnyValuesOfTypes(Class<?>... values) {
        return stream(values).anyMatch(this::isIn);
    }

    final boolean containsNullValues() {
        return stream().anyMatch(Objects::isNull);
    }

    final boolean containsOnlyNullValues() {
        return stream().allMatch(Objects::isNull);
    }

    final boolean hasDuplicateValues() {
        return stream().anyMatch(e -> !isInValuesOnlyOnce(e.getValue()));
    }

    final boolean anyValuesMatch(Predicate<VALUE> predicate) {
        return stream().map(Map.Entry::getValue).anyMatch(predicate);
    }

    final boolean allValuesMatch(Predicate<VALUE> predicate) {
        return stream().map(Map.Entry::getValue).allMatch(predicate);
    }

    final boolean noneValuesMatch(Predicate<VALUE> predicate) {
        return stream().map(Map.Entry::getValue).noneMatch(predicate);
    }

}
