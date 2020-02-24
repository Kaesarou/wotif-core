/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.number.floating;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.typed.number.INumberCondition;

public interface IFloatingCondition<F extends Number & Comparable<F>, R>
        extends INumberCondition<F, R> {

    Completable<R> isCloseTo(Integer expected);

    Completable<R> isNotCloseTo(Integer expected);

    Completable<R> isNumber();

    Completable<R> isNaN();

    Completable<R> isInfinite();

    Completable<R> isFinite();

}
