package org.wotif.core.api.condition.typed.map;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.AbstractJoinCondition;
import org.wotif.core.api.condition.JoinEnum;

import java.util.Map;
import java.util.function.Predicate;

final class MapJoinCondition<KEY, VALUE> extends AbstractJoinCondition<Map<KEY, VALUE>, MapCondition<KEY, VALUE>>
        implements IMapCondition<KEY, VALUE> {

    @SafeVarargs
    public MapJoinCondition(JoinEnum joinType, Map<KEY, VALUE>... terms) {
        super(joinType, terms);
    }

    @Override
    protected MapCondition<KEY, VALUE> getInstanceOfCondition(Map<KEY, VALUE> term) {
        return new MapCondition<>(term);
    }

    @Override
    @SafeVarargs
    final public CompletableResult contains(Map.Entry<KEY, VALUE>... values) {
        return this.functionToApply.apply(m -> m.contains(values));
    }

    @Override
    @SafeVarargs
    final public CompletableResult doesNotContains(Map.Entry<KEY, VALUE>... values) {
        return this.functionToApply.apply(m -> m.doesNotContains(values));
    }

    @Override
    @SafeVarargs
    final public CompletableResult containsKeys(KEY... values) {
        return this.functionToApply.apply(m -> m.containsKeys(values));
    }

    @Override
    @SafeVarargs
    final public CompletableResult doesNotContainsKeys(KEY... values) {
        return this.functionToApply.apply(m -> m.doesNotContainsKeys(values));
    }

    @Override
    @SafeVarargs
    final public CompletableResult containsValues(VALUE... values) {
        return this.functionToApply.apply(m -> m.containsValues(values));
    }

    @Override
    @SafeVarargs
    final public CompletableResult doesNotContainsValues(VALUE... values) {
        return this.functionToApply.apply(m -> m.doesNotContainsValues(values));
    }

    @Override
    final public CompletableResult containsAllEntriesOf(Map<KEY, VALUE> values) {
        return this.functionToApply.apply(m -> m.containsAllEntriesOf(values));
    }

    @Override
    final public CompletableResult doesNotContainsAllEntriesOf(Map<KEY, VALUE> values) {
        return this.functionToApply.apply(m -> m.doesNotContainsAllEntriesOf(values));
    }

    @Override
    @SafeVarargs
    final public CompletableResult containsAnyOf(Map.Entry<KEY, VALUE>... values) {
        return this.functionToApply.apply(m -> m.containsAnyOf(values));
    }

    @Override
    @SafeVarargs
    final public CompletableResult doesNotContainsAnyOf(Map.Entry<KEY, VALUE>... values) {
        return this.functionToApply.apply(m -> m.doesNotContainsAnyOf(values));
    }

    @Override
    final public CompletableResult containsAnyEntriesOf(Map<KEY, VALUE> values) {
        return this.functionToApply.apply(m -> m.containsAnyEntriesOf(values));
    }

    @Override
    final public CompletableResult doesNotContainsAnyEntriesOf(Map<KEY, VALUE> values) {
        return this.functionToApply.apply(m -> m.doesNotContainsAnyEntriesOf(values));
    }

    @Override
    @SafeVarargs
    final public CompletableResult containsOnly(Map.Entry<KEY, VALUE>... values) {
        return this.functionToApply.apply(m -> m.containsOnly(values));
    }

    @Override
    @SafeVarargs
    final public CompletableResult doesNotContainsOnly(Map.Entry<KEY, VALUE>... values) {
        return this.functionToApply.apply(m -> m.doesNotContainsOnly(values));
    }

    @Override
    final public CompletableResult containsOnlyEntriesOf(Map<KEY, VALUE> values) {
        return this.functionToApply.apply(m -> m.containsOnlyEntriesOf(values));
    }

    @Override
    final public CompletableResult doesNotContainsOnlyEntriesOf(Map<KEY, VALUE> values) {
        return this.functionToApply.apply(m -> m.doesNotContainsOnlyEntriesOf(values));
    }

    @Override
    @SafeVarargs
    final public CompletableResult containsOnlyOnceValues(VALUE... values) {
        return this.functionToApply.apply(m -> m.containsOnlyOnceValues(values));
    }

    @Override
    @SafeVarargs
    final public CompletableResult containsMoreThanOnceValues(VALUE... values) {
        return this.functionToApply.apply(m -> m.containsMoreThanOnceValues(values));
    }

    @Override
    final public CompletableResult isEmpty() {
        return this.functionToApply.apply(MapCondition::isEmpty);
    }

    @Override
    final public CompletableResult isNotEmpty() {
        return this.functionToApply.apply(MapCondition::isNotEmpty);
    }

    @Override
    final public CompletableResult hasAnyValuesOfTypes(Class<?>... values) {
        return this.functionToApply.apply(m -> m.hasAnyValuesOfTypes());
    }

    @Override
    final public CompletableResult doesNotHasAnyValuesOfTypes(Class<?>... values) {
        return this.functionToApply.apply(m -> m.doesNotHasAnyValuesOfTypes(values));
    }

    @Override
    final public CompletableResult containsNullValues() {
        return this.functionToApply.apply(MapCondition::containsNullValues);
    }

    @Override
    final public CompletableResult doesNotContainsNullValues() {
        return this.functionToApply.apply(MapCondition::doesNotContainsNullValues);
    }

    @Override
    final public CompletableResult containsOnlyNullValues() {
        return this.functionToApply.apply(MapCondition::containsOnlyNullValues);
    }

    @Override
    final public CompletableResult doesNotContainsOnlyNullValues() {
        return this.functionToApply.apply(MapCondition::doesNotContainsOnlyNullValues);
    }

    @Override
    final public CompletableResult hasDuplicateValues() {
        return this.functionToApply.apply(MapCondition::hasDuplicateValues);
    }

    @Override
    final public CompletableResult doesNotHasDuplicateValues() {
        return this.functionToApply.apply(MapCondition::doesNotHasDuplicateValues);
    }

    @Override
    final public CompletableResult anyValuesMatch(Predicate<VALUE> predicate) {
        return this.functionToApply.apply(m -> m.anyValuesMatch(predicate));
    }

    @Override
    final public CompletableResult allValuesMatch(Predicate<VALUE> predicate) {
        return this.functionToApply.apply(m -> m.allValuesMatch(predicate));
    }

    @Override
    final public CompletableResult noneValuesMatch(Predicate<VALUE> predicate) {
        return this.functionToApply.apply(m -> m.noneValuesMatch(predicate));
    }
}
