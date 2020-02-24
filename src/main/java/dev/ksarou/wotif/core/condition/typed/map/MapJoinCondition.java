/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.map;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.AbstractJoinCondition;
import dev.ksarou.wotif.core.condition.JoinEnum;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class MapJoinCondition<K, V> extends AbstractJoinCondition<Map<K, V>, MapCondition<K, V>>
        implements IMapCondition<K, V, List<Map<K, V>>> {

    @SafeVarargs
    public MapJoinCondition(JoinEnum joinType, Map<K, V>... terms) {
        super(joinType, terms);
    }

    @Override
    protected MapCondition<K, V> getInstanceOfCondition(Map<K, V> term) {
        return new MapCondition<>(term);
    }

    @Override
    @SafeVarargs
    final public Completable<List<Map<K, V>>> contains(Map.Entry<K, V>... values) {
        return this.functionToApply.apply(m -> m.contains(values));
    }

    @Override
    @SafeVarargs
    final public Completable<List<Map<K, V>>> doesNotContains(Map.Entry<K, V>... values) {
        return this.functionToApply.apply(m -> m.doesNotContains(values));
    }

    @Override
    @SafeVarargs
    final public Completable<List<Map<K, V>>> containsKeys(K... values) {
        return this.functionToApply.apply(m -> m.containsKeys(values));
    }

    @Override
    @SafeVarargs
    final public Completable<List<Map<K, V>>> doesNotContainsKeys(K... values) {
        return this.functionToApply.apply(m -> m.doesNotContainsKeys(values));
    }

    @Override
    @SafeVarargs
    final public Completable<List<Map<K, V>>> containsValues(V... values) {
        return this.functionToApply.apply(m -> m.containsValues(values));
    }

    @Override
    @SafeVarargs
    final public Completable<List<Map<K, V>>> doesNotContainsValues(V... values) {
        return this.functionToApply.apply(m -> m.doesNotContainsValues(values));
    }

    @Override
    final public Completable<List<Map<K, V>>> containsAllEntriesOf(Map<K, V> values) {
        return this.functionToApply.apply(m -> m.containsAllEntriesOf(values));
    }

    @Override
    final public Completable<List<Map<K, V>>> doesNotContainsAllEntriesOf(Map<K, V> values) {
        return this.functionToApply.apply(m -> m.doesNotContainsAllEntriesOf(values));
    }

    @Override
    @SafeVarargs
    final public Completable<List<Map<K, V>>> containsAnyOf(Map.Entry<K, V>... values) {
        return this.functionToApply.apply(m -> m.containsAnyOf(values));
    }

    @Override
    @SafeVarargs
    final public Completable<List<Map<K, V>>> doesNotContainsAnyOf(Map.Entry<K, V>... values) {
        return this.functionToApply.apply(m -> m.doesNotContainsAnyOf(values));
    }

    @Override
    final public Completable<List<Map<K, V>>> containsAnyEntriesOf(Map<K, V> values) {
        return this.functionToApply.apply(m -> m.containsAnyEntriesOf(values));
    }

    @Override
    final public Completable<List<Map<K, V>>> containsNoneEntriesOf(Map<K, V> values) {
        return this.functionToApply.apply(m -> m.containsNoneEntriesOf(values));
    }

    @Override
    @SafeVarargs
    final public Completable<List<Map<K, V>>> containsOnly(Map.Entry<K, V>... values) {
        return this.functionToApply.apply(m -> m.containsOnly(values));
    }

    @Override
    @SafeVarargs
    final public Completable<List<Map<K, V>>> doesNotContainsOnly(Map.Entry<K, V>... values) {
        return this.functionToApply.apply(m -> m.doesNotContainsOnly(values));
    }

    @Override
    final public Completable<List<Map<K, V>>> containsOnlyEntriesOf(Map<K, V> values) {
        return this.functionToApply.apply(m -> m.containsOnlyEntriesOf(values));
    }

    @Override
    final public Completable<List<Map<K, V>>> doesNotContainsOnlyEntriesOf(Map<K, V> values) {
        return this.functionToApply.apply(m -> m.doesNotContainsOnlyEntriesOf(values));
    }

    @Override
    @SafeVarargs
    final public Completable<List<Map<K, V>>> containsOnlyOnceValues(V... values) {
        return this.functionToApply.apply(m -> m.containsOnlyOnceValues(values));
    }

    @Override
    @SafeVarargs
    final public Completable<List<Map<K, V>>> containsMoreThanOnceValues(V... values) {
        return this.functionToApply.apply(m -> m.containsMoreThanOnceValues(values));
    }

    @Override
    final public Completable<List<Map<K, V>>> isEmpty() {
        return this.functionToApply.apply(MapCondition::isEmpty);
    }

    @Override
    final public Completable<List<Map<K, V>>> isNotEmpty() {
        return this.functionToApply.apply(MapCondition::isNotEmpty);
    }

    @Override
    final public Completable<List<Map<K, V>>> hasAnyValuesOfTypes(Class<?>... values) {
        return this.functionToApply.apply(m -> m.hasAnyValuesOfTypes());
    }

    @Override
    final public Completable<List<Map<K, V>>> doesNotHasAnyValuesOfTypes(Class<?>... values) {
        return this.functionToApply.apply(m -> m.doesNotHasAnyValuesOfTypes(values));
    }

    @Override
    final public Completable<List<Map<K, V>>> containsNullValues() {
        return this.functionToApply.apply(MapCondition::containsNullValues);
    }

    @Override
    final public Completable<List<Map<K, V>>> doesNotContainsNullValues() {
        return this.functionToApply.apply(MapCondition::doesNotContainsNullValues);
    }

    @Override
    final public Completable<List<Map<K, V>>> containsOnlyNullValues() {
        return this.functionToApply.apply(MapCondition::containsOnlyNullValues);
    }

    @Override
    final public Completable<List<Map<K, V>>> doesNotContainsOnlyNullValues() {
        return this.functionToApply.apply(MapCondition::doesNotContainsOnlyNullValues);
    }

    @Override
    final public Completable<List<Map<K, V>>> hasDuplicateValues() {
        return this.functionToApply.apply(MapCondition::hasDuplicateValues);
    }

    @Override
    final public Completable<List<Map<K, V>>> doesNotHasDuplicateValues() {
        return this.functionToApply.apply(MapCondition::doesNotHasDuplicateValues);
    }

    @Override
    final public Completable<List<Map<K, V>>> anyValuesMatch(Predicate<V> predicate) {
        return this.functionToApply.apply(m -> m.anyValuesMatch(predicate));
    }

    @Override
    final public Completable<List<Map<K, V>>> allValuesMatch(Predicate<V> predicate) {
        return this.functionToApply.apply(m -> m.allValuesMatch(predicate));
    }

    @Override
    final public Completable<List<Map<K, V>>> noneValuesMatch(Predicate<V> predicate) {
        return this.functionToApply.apply(m -> m.noneValuesMatch(predicate));
    }
}
