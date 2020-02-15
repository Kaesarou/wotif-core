package org.wotif.core.api.condition.typed.map;

import org.wotif.core.api.Term;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

class InternalMapCondition<K, V> {

    private final Term<Map<K, V>> term;

    InternalMapCondition(Term<Map<K, V>> term) {
        this.term = term;
    }

    private Stream<Map.Entry<K, V>> stream() {
        return this.term.value().entrySet().stream();
    }

    private Stream<Map.Entry<K, V>> stream(Map.Entry<K, V>[] entries) {
        return Arrays.stream(entries);
    }

    private Stream<Map.Entry<K, V>> stream(Map<K, V> map) {
        return map.entrySet().stream();
    }

    private <T> Stream<T> stream(T[] array) {
        return Arrays.stream(array);
    }

    private boolean isIn(Stream<Map.Entry<K, V>> entries, Map.Entry<K, V> entry) {
        return entries.anyMatch(e -> e.equals(entry));
    }

    private boolean isInKeys(K key) {
        return stream().anyMatch(e -> e.getKey().equals(key));
    }

    private boolean isInValues(V value) {
        return stream().anyMatch(e -> e.getValue().equals(value));
    }

    private boolean isInValuesOnlyOnce(V value) {
        return stream().filter(e -> e.getValue().equals(value)).count() == 1;
    }

    private boolean isInValuesMoreThanOnce(V value) {
        return stream().filter(e -> e.getValue().equals(value)).count() > 1;
    }

    private boolean isIn(Class<?> clazz) {
        return stream().anyMatch(e -> e.getValue().getClass().equals(clazz));
    }

    @SafeVarargs
    final boolean contains(Map.Entry<K, V>... values) {
        return stream(values).allMatch(e -> isIn(stream(), e));
    }

    @SafeVarargs
    final boolean containsKeys(K... values) {
        return stream(values).allMatch(this::isInKeys);
    }

    @SafeVarargs
    final boolean containsValues(V... values) {
        return stream(values).allMatch(this::isInValues);
    }

    final boolean containsAllEntriesOf(Map<K, V> values) {
        return stream(values).allMatch(e -> isIn(stream(), e));
    }

    @SafeVarargs
    final boolean containsAnyOf(Map.Entry<K, V>... values) {
        return stream(values).anyMatch(e -> isIn(stream(), e));
    }

    final boolean containsAnyEntriesOf(Map<K, V> values) {
        return stream(values).anyMatch(e -> isIn(stream(), e));
    }

    @SafeVarargs
    final boolean containsOnly(Map.Entry<K, V>... values) {
        return this.contains(values) && stream().count() == stream(values).count();
    }

    @SafeVarargs
    final boolean doesNotContainsOnly(Map.Entry<K, V>... values) {
        return this.contains(values) && stream().count() > stream(values).count();
    }

    final boolean containsOnlyEntriesOf(Map<K, V> values) {
        return containsAllEntriesOf(values) && stream().count() == stream(values).count();
    }

    final boolean doesNotContainsOnlyEntriesOf(Map<K, V> values) {
        return containsAllEntriesOf(values) && stream().count() > stream(values).count();
    }

    @SafeVarargs
    final boolean containsOnlyOnceValues(V... values) {
        return stream(values).allMatch(this::isInValuesOnlyOnce);
    }

    @SafeVarargs
    final boolean containsMoreThanOnceValues(V... values) {
        return stream(values).allMatch(this::isInValuesMoreThanOnce);
    }

    final boolean isEmpty() {
        return this.term.value().isEmpty();
    }

    final boolean hasAnyValuesOfTypes(Class<?>... values) {
        return stream(values).anyMatch(this::isIn);
    }

    final boolean containsNullValues() {
        return stream().anyMatch(e -> e.getValue() == null);
    }

    final boolean containsOnlyNullValues() {
        return stream().allMatch(e -> e.getValue() == null);
    }

    final boolean hasDuplicateValues() {
        return stream().anyMatch(e -> !isInValuesOnlyOnce(e.getValue()));
    }

    final boolean anyValuesMatch(Predicate<V> predicate) {
        return stream().map(Map.Entry::getValue).anyMatch(predicate);
    }

    final boolean allValuesMatch(Predicate<V> predicate) {
        return stream().map(Map.Entry::getValue).allMatch(predicate);
    }

    final boolean noneValuesMatch(Predicate<V> predicate) {
        return stream().map(Map.Entry::getValue).noneMatch(predicate);
    }

}
