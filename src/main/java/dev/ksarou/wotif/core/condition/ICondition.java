package dev.ksarou.wotif.core.condition;

import dev.ksarou.wotif.core.Completable;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface ICondition<T, R> {

    Completable<R> isEqualTo(T expected);

    Completable<R> isDifferentFrom(T expected);

    Completable<R> isNull();

    Completable<R> isNotNull();

    Completable<R> isInstanceOf(Class<?> className);

    Completable<R> isNotInstanceOf(Class<?> className);

    Completable<R> hasSameClassAs(@NonNull Object other);

    Completable<R> doesNotHasSameClassAs(@NonNull Object other);

    Completable<R> hasSameHashCodeAs(@NonNull Object other);

    Completable<R> doesNotHasSameHashCodeAs(@NonNull Object other);

    Completable<R> hasToString(String expectedToString);

    Completable<R> doesNotHasToString(String expectedToString);

}
