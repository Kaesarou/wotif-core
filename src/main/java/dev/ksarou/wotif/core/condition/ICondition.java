/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
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
