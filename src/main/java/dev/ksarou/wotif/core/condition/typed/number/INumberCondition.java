/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.number;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.typed.IComparableCondition;

public interface INumberCondition<N extends Number & Comparable<N>, R> extends IComparableCondition<N, R> {

    Completable<R> isZero();

    Completable<R> isDifferentFromZero();

    Completable<R> isPositive();

    Completable<R> isNegative();

}
