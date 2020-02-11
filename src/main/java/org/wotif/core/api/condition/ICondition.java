package org.wotif.core.api.condition;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.wotif.core.api.CompletableResult;

public interface ICondition<TYPE> {

    CompletableResult isEqualTo(TYPE expected);

    CompletableResult isDifferentFrom(TYPE expected);

    CompletableResult isNull();

    CompletableResult isNotNull();

    CompletableResult isInstanceOf(Class<?> className);

    CompletableResult isNotInstanceOf(Class<?> className);

    CompletableResult hasSameClassAs(@NonNull Object other);

    CompletableResult doesNotHasSameClassAs(@NonNull Object other);

    CompletableResult hasSameHashCodeAs(@NonNull Object other);

    CompletableResult doesNotHasSameHashCodeAs(@NonNull Object other);

    CompletableResult hasToString(String expectedToString);

    CompletableResult doesNotHasToString(String expectedToString);

}
