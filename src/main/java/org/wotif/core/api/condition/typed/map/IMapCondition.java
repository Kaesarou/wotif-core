package org.wotif.core.api.condition.typed.map;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.ICondition;

import java.util.Map;
import java.util.function.Predicate;

public interface IMapCondition<K, V, R> extends ICondition<Map<K, V>, R> {

    CompletableResult<R> contains(Map.Entry<K, V>... values);

    CompletableResult<R> doesNotContains(Map.Entry<K, V>... values);

    CompletableResult<R> containsKeys(K... values);

    CompletableResult<R> doesNotContainsKeys(K... values);

    CompletableResult<R> containsValues(V... values);

    CompletableResult<R> doesNotContainsValues(V... values);

    CompletableResult<R> containsAllEntriesOf(Map<K, V> values);

    CompletableResult<R> doesNotContainsAllEntriesOf(Map<K, V> values);

    CompletableResult<R> containsAnyOf(Map.Entry<K, V>... values);

    CompletableResult<R> doesNotContainsAnyOf(Map.Entry<K, V>... values);

    CompletableResult<R> containsAnyEntriesOf(Map<K, V> values);

    CompletableResult<R> containsNoneEntriesOf(Map<K, V> values);

    CompletableResult<R> containsOnly(Map.Entry<K, V>... values);

    CompletableResult<R> doesNotContainsOnly(Map.Entry<K, V>... values);

    CompletableResult<R> containsOnlyEntriesOf(Map<K, V> values);

    CompletableResult<R> doesNotContainsOnlyEntriesOf(Map<K, V> values);

    CompletableResult<R> containsOnlyOnceValues(V... values);

    CompletableResult<R> containsMoreThanOnceValues(V... values);

    CompletableResult<R> isEmpty();

    CompletableResult<R> isNotEmpty();

    CompletableResult<R> hasAnyValuesOfTypes(Class<?>... values);

    CompletableResult<R> doesNotHasAnyValuesOfTypes(Class<?>... values);

    CompletableResult<R> containsNullValues();

    CompletableResult<R> doesNotContainsNullValues();

    CompletableResult<R> containsOnlyNullValues();

    CompletableResult<R> doesNotContainsOnlyNullValues();

    CompletableResult<R> hasDuplicateValues();

    CompletableResult<R> doesNotHasDuplicateValues();

    CompletableResult<R> anyValuesMatch(Predicate<V> predicate);

    CompletableResult<R> allValuesMatch(Predicate<V> predicate);

    CompletableResult<R> noneValuesMatch(Predicate<V> predicate);

}
