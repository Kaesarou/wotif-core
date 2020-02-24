/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.ICondition;

public interface IComparableCondition<T extends Comparable<T>, R>
        extends ICondition<T, R> {

    Completable<R> isLessThen(T termToCompare);

    Completable<R> isGreaterThen(T termToCompare);

    Completable<R> isBetween(T start, T end);

    Completable<R> isNotBetween(T start, T end);

    Completable<R> isStrictlyBetween(T start, T end);

    @Override
    Completable<R> isEqualTo(T expected);

    @Override
    Completable<R> isDifferentFrom(T expected);

}
