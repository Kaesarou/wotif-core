/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.number.floating;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.typed.number.AbstractNumberCondition;

public abstract class FloatingCondition<F extends Number & Comparable<F>>
        extends AbstractNumberCondition<F> implements IFloatingCondition<F, F> {

    public FloatingCondition(F term) {
        super(term);
    }

    protected abstract long round();

    @Override
    protected abstract F zero();

    @Override
    public Completable<F> isCloseTo(Integer expected) {
        long converted = Long.valueOf(expected);
        boolean value = round() == converted;
        return new Completable<>(term, value);
    }

    @Override
    public Completable<F> isNotCloseTo(Integer expected) {
        long converted = Long.valueOf(expected);
        boolean value = round() != converted;
        return new Completable<>(term, value);
    }
}
