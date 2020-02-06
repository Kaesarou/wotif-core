package org.wotif.core.api.condition.typed.map;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.ICondition;

import java.util.Map;
import java.util.function.Predicate;

public interface IMapCondition<KEY, VALUE> extends ICondition<Map<KEY, VALUE>> {

    CompletableResult contains(Map.Entry<KEY, VALUE>... values);

    CompletableResult doesNotContains(Map.Entry<KEY, VALUE>... values);

    CompletableResult containsKeys(KEY... values);

    CompletableResult doesNotContainsKeys(KEY... values);

    CompletableResult containsValues(VALUE... values);

    CompletableResult doesNotContainsValues(VALUE... values);

    CompletableResult containsAllEntriesOf(Map<KEY, VALUE> values);

    CompletableResult doesNotContainsAllEntriesOf(Map<KEY, VALUE> values);

    CompletableResult containsAnyOf(Map.Entry<KEY, VALUE>... values);

    CompletableResult doesNotContainsAnyOf(Map.Entry<KEY, VALUE>... values);

    CompletableResult containsAnyEntriesOf(Map<KEY, VALUE> values);

    CompletableResult doesNotContainsAnyEntriesOf(Map<KEY, VALUE> values);

    CompletableResult containsOnly(Map.Entry<KEY, VALUE>... values);

    CompletableResult doesNotContainsOnly(Map.Entry<KEY, VALUE>... values);

    CompletableResult containsOnlyEntriesOf(Map<KEY, VALUE> values);

    CompletableResult doesNotContainsOnlyEntriesOf(Map<KEY, VALUE> values);

    CompletableResult containsOnlyOnceValues(VALUE... values);

    CompletableResult containsMoreThanOnceValues(VALUE... values);

    CompletableResult isEmpty();

    CompletableResult isNotEmpty();

    CompletableResult hasAnyValuesOfTypes(Class<?>... values);

    CompletableResult doesNotHasAnyValuesOfTypes(Class<?>... values);

    CompletableResult containsNullValues();

    CompletableResult doesNotContainsNullValues();

    CompletableResult containsOnlyNullValues();

    CompletableResult doesNotContainsOnlyNullValues();

    CompletableResult hasDuplicateValues();

    CompletableResult doesNotHasDuplicateValues();

    CompletableResult anyValuesMatch(Predicate<? super Map.Entry<KEY, VALUE>> predicate);

    CompletableResult allValuesMatch(Predicate<? super Map.Entry<KEY, VALUE>> predicate);

    CompletableResult noneValuesMatch(Predicate<? super Map.Entry<KEY, VALUE>> predicate);

}
