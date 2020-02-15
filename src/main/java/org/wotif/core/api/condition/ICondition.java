package org.wotif.core.api.condition;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.wotif.core.api.CompletableResult;

public interface ICondition<T, R> {

    CompletableResult<R> isEqualTo(T expected);

    CompletableResult<R> isDifferentFrom(T expected);

    CompletableResult<R> isNull();

    CompletableResult<R> isNotNull();

    CompletableResult<R> isInstanceOf(Class<?> className);

    CompletableResult<R> isNotInstanceOf(Class<?> className);

    CompletableResult<R> hasSameClassAs(@NonNull Object other);

    CompletableResult<R> doesNotHasSameClassAs(@NonNull Object other);

    CompletableResult<R> hasSameHashCodeAs(@NonNull Object other);

    CompletableResult<R> doesNotHasSameHashCodeAs(@NonNull Object other);

    CompletableResult<R> hasToString(String expectedToString);

    CompletableResult<R> doesNotHasToString(String expectedToString);

}
