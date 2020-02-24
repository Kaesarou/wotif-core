/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.booleans;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.ICondition;

public interface IBooleanCondition<R> extends ICondition<Boolean, R> {

    Completable<R> isTrue();

    Completable<R> isFalse();

}
