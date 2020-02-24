/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.map;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.AbstractCondition;

import java.util.Map;
import java.util.function.Predicate;

public class MapCondition<K, V> extends AbstractCondition<Map<K, V>> implements IMapCondition<K, V, Map<K, V>> {

    private InternalMapCondition<K, V> internalMapCondition;

    public MapCondition(Map<K, V> term) {
        super(term);
        this.internalMapCondition = new InternalMapCondition<>(this.term);
    }

    @Override
    @SafeVarargs
    final public Completable<Map<K, V>> contains(Map.Entry<K, V>... values) {
        boolean result = this.internalMapCondition.contains(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    final public Completable<Map<K, V>> doesNotContains(Map.Entry<K, V>... values) {
        boolean result = !this.internalMapCondition.contains(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    final public Completable<Map<K, V>> containsKeys(K... values) {
        boolean result = this.internalMapCondition.containsKeys(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    final public Completable<Map<K, V>> doesNotContainsKeys(K... values) {
        boolean result = !this.internalMapCondition.containsKeys(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    final public Completable<Map<K, V>> containsValues(V... values) {
        boolean result = this.internalMapCondition.containsValues(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    final public Completable<Map<K, V>> doesNotContainsValues(V... values) {
        boolean result = !this.internalMapCondition.containsValues(values);
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> containsAllEntriesOf(Map<K, V> values) {
        boolean result = this.internalMapCondition.containsAllEntriesOf(values);
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> doesNotContainsAllEntriesOf(Map<K, V> values) {
        boolean result = !this.internalMapCondition.containsAllEntriesOf(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    final public Completable<Map<K, V>> containsAnyOf(Map.Entry<K, V>... values) {
        boolean result = this.internalMapCondition.containsAnyOf(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    final public Completable<Map<K, V>> doesNotContainsAnyOf(Map.Entry<K, V>... values) {
        boolean result = !this.internalMapCondition.containsAnyOf(values);
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> containsAnyEntriesOf(Map<K, V> values) {
        boolean result = this.internalMapCondition.containsAnyEntriesOf(values);
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> containsNoneEntriesOf(Map<K, V> values) {
        boolean result = !this.internalMapCondition.containsAnyEntriesOf(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    final public Completable<Map<K, V>> containsOnly(Map.Entry<K, V>... values) {
        boolean result = this.internalMapCondition.containsOnly(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    final public Completable<Map<K, V>> doesNotContainsOnly(Map.Entry<K, V>... values) {
        boolean result = this.internalMapCondition.doesNotContainsOnly(values);
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> containsOnlyEntriesOf(Map<K, V> values) {
        boolean result = this.internalMapCondition.containsOnlyEntriesOf(values);
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> doesNotContainsOnlyEntriesOf(Map<K, V> values) {
        boolean result = this.internalMapCondition.doesNotContainsOnlyEntriesOf(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    final public Completable<Map<K, V>> containsOnlyOnceValues(V... values) {
        boolean result = this.internalMapCondition.containsOnlyOnceValues(values);
        return new Completable<>(term, result);
    }

    @Override
    @SafeVarargs
    final public Completable<Map<K, V>> containsMoreThanOnceValues(V... values) {
        boolean result = this.internalMapCondition.containsMoreThanOnceValues(values);
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> isEmpty() {
        boolean result = this.internalMapCondition.isEmpty();
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> isNotEmpty() {
        boolean result = !this.internalMapCondition.isEmpty();
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> hasAnyValuesOfTypes(Class<?>... values) {
        boolean result = this.internalMapCondition.hasAnyValuesOfTypes(values);
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> doesNotHasAnyValuesOfTypes(Class<?>... values) {
        boolean result = !this.internalMapCondition.hasAnyValuesOfTypes(values);
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> containsNullValues() {
        boolean result = this.internalMapCondition.containsNullValues();
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> doesNotContainsNullValues() {
        boolean result = !this.internalMapCondition.containsNullValues();
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> containsOnlyNullValues() {
        boolean result = this.internalMapCondition.containsOnlyNullValues();
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> doesNotContainsOnlyNullValues() {
        boolean result = !this.internalMapCondition.containsOnlyNullValues();
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> hasDuplicateValues() {
        boolean result = this.internalMapCondition.hasDuplicateValues();
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> doesNotHasDuplicateValues() {
        boolean result = !this.internalMapCondition.hasDuplicateValues();
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> anyValuesMatch(Predicate<V> predicate) {
        boolean result = this.internalMapCondition.anyValuesMatch(predicate);
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> allValuesMatch(Predicate<V> predicate) {
        boolean result = this.internalMapCondition.allValuesMatch(predicate);
        return new Completable<>(term, result);
    }

    @Override
    final public Completable<Map<K, V>> noneValuesMatch(Predicate<V> predicate) {
        boolean result = this.internalMapCondition.noneValuesMatch(predicate);
        return new Completable<>(term, result);
    }

}
