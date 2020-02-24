/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.map;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.ICondition;

import java.util.Map;
import java.util.function.Predicate;

public interface IMapCondition<K, V, R> extends ICondition<Map<K, V>, R> {

    Completable<R> contains(Map.Entry<K, V>... values);

    Completable<R> doesNotContains(Map.Entry<K, V>... values);

    Completable<R> containsKeys(K... values);

    Completable<R> doesNotContainsKeys(K... values);

    Completable<R> containsValues(V... values);

    Completable<R> doesNotContainsValues(V... values);

    Completable<R> containsAllEntriesOf(Map<K, V> values);

    Completable<R> doesNotContainsAllEntriesOf(Map<K, V> values);

    Completable<R> containsAnyOf(Map.Entry<K, V>... values);

    Completable<R> doesNotContainsAnyOf(Map.Entry<K, V>... values);

    Completable<R> containsAnyEntriesOf(Map<K, V> values);

    Completable<R> containsNoneEntriesOf(Map<K, V> values);

    Completable<R> containsOnly(Map.Entry<K, V>... values);

    Completable<R> doesNotContainsOnly(Map.Entry<K, V>... values);

    Completable<R> containsOnlyEntriesOf(Map<K, V> values);

    Completable<R> doesNotContainsOnlyEntriesOf(Map<K, V> values);

    Completable<R> containsOnlyOnceValues(V... values);

    Completable<R> containsMoreThanOnceValues(V... values);

    Completable<R> isEmpty();

    Completable<R> isNotEmpty();

    Completable<R> hasAnyValuesOfTypes(Class<?>... values);

    Completable<R> doesNotHasAnyValuesOfTypes(Class<?>... values);

    Completable<R> containsNullValues();

    Completable<R> doesNotContainsNullValues();

    Completable<R> containsOnlyNullValues();

    Completable<R> doesNotContainsOnlyNullValues();

    Completable<R> hasDuplicateValues();

    Completable<R> doesNotHasDuplicateValues();

    Completable<R> anyValuesMatch(Predicate<V> predicate);

    Completable<R> allValuesMatch(Predicate<V> predicate);

    Completable<R> noneValuesMatch(Predicate<V> predicate);

}
