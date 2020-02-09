package org.wotif.core.api.condition.typed.map;

import org.wotif.core.api.CompletableResult;
import org.wotif.core.api.condition.AbstractCondition;
import java.util.Map;
import java.util.function.Predicate;

public class MapCondition<KEY, VALUE> extends AbstractCondition<Map<KEY, VALUE>> implements IMapCondition<KEY, VALUE> {

    private InternalMapCondition<KEY, VALUE> internalMapCondition;

    public MapCondition(Map<KEY, VALUE> term) {
        super(term);
        this.internalMapCondition = new InternalMapCondition<>(this.term);
    }

    @Override
    @SafeVarargs
    final public CompletableResult contains(Map.Entry<KEY, VALUE>... values) {
        boolean result = this.internalMapCondition.contains(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    final public CompletableResult doesNotContains(Map.Entry<KEY, VALUE>... values) {
        boolean result = !this.internalMapCondition.contains(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    final public CompletableResult containsKeys(KEY... values) {
        boolean result = this.internalMapCondition.containsKeys(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    final public CompletableResult doesNotContainsKeys(KEY... values) {
        boolean result = !this.internalMapCondition.containsKeys(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    final public CompletableResult containsValues(VALUE... values) {
        boolean result = this.internalMapCondition.containsValues(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    final public CompletableResult doesNotContainsValues(VALUE... values) {
        boolean result = !this.internalMapCondition.containsValues(values);
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult containsAllEntriesOf(Map<KEY, VALUE> values) {
        boolean result = this.internalMapCondition.containsAllEntriesOf(values);
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult doesNotContainsAllEntriesOf(Map<KEY, VALUE> values) {
        boolean result = !this.internalMapCondition.containsAllEntriesOf(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    final public CompletableResult containsAnyOf(Map.Entry<KEY, VALUE>... values) {
        boolean result = this.internalMapCondition.containsAnyOf(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    final public CompletableResult doesNotContainsAnyOf(Map.Entry<KEY, VALUE>... values) {
        boolean result = !this.internalMapCondition.containsAnyOf(values);
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult containsAnyEntriesOf(Map<KEY, VALUE> values) {
        boolean result = this.internalMapCondition.containsAnyEntriesOf(values);
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult containsNoneEntriesOf(Map<KEY, VALUE> values) {
        boolean result = !this.internalMapCondition.containsAnyEntriesOf(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    final public CompletableResult containsOnly(Map.Entry<KEY, VALUE>... values) {
        boolean result = this.internalMapCondition.containsOnly(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    final public CompletableResult doesNotContainsOnly(Map.Entry<KEY, VALUE>... values) {
        boolean result = this.internalMapCondition.doesNotContainsOnly(values);
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult containsOnlyEntriesOf(Map<KEY, VALUE> values) {
        boolean result = this.internalMapCondition.containsOnlyEntriesOf(values);
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult doesNotContainsOnlyEntriesOf(Map<KEY, VALUE> values) {
        boolean result = this.internalMapCondition.doesNotContainsOnlyEntriesOf(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    final public CompletableResult containsOnlyOnceValues(VALUE... values) {
        boolean result = this.internalMapCondition.containsOnlyOnceValues(values);
        return new CompletableResult(result);
    }

    @Override
    @SafeVarargs
    final public CompletableResult containsMoreThanOnceValues(VALUE... values) {
        boolean result = this.internalMapCondition.containsMoreThanOnceValues(values);
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult isEmpty() {
        boolean result = this.internalMapCondition.isEmpty();
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult isNotEmpty() {
        boolean result = !this.internalMapCondition.isEmpty();
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult hasAnyValuesOfTypes(Class<?>... values) {
        boolean result = this.internalMapCondition.hasAnyValuesOfTypes(values);
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult doesNotHasAnyValuesOfTypes(Class<?>... values) {
        boolean result = !this.internalMapCondition.hasAnyValuesOfTypes(values);
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult containsNullValues() {
        boolean result = this.internalMapCondition.containsNullValues();
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult doesNotContainsNullValues() {
        boolean result = !this.internalMapCondition.containsNullValues();
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult containsOnlyNullValues() {
        boolean result = this.internalMapCondition.containsOnlyNullValues();
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult doesNotContainsOnlyNullValues() {
        boolean result = !this.internalMapCondition.containsOnlyNullValues();
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult hasDuplicateValues() {
        boolean result = this.internalMapCondition.hasDuplicateValues();
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult doesNotHasDuplicateValues() {
        boolean result = !this.internalMapCondition.hasDuplicateValues();
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult anyValuesMatch(Predicate<VALUE> predicate) {
        boolean result = this.internalMapCondition.anyValuesMatch(predicate);
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult allValuesMatch(Predicate<VALUE> predicate) {
        boolean result = this.internalMapCondition.allValuesMatch(predicate);
        return new CompletableResult(result);
    }

    @Override
    final public CompletableResult noneValuesMatch(Predicate<VALUE> predicate) {
        boolean result = this.internalMapCondition.noneValuesMatch(predicate);
        return new CompletableResult(result);
    }

}
