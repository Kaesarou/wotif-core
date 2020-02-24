/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.number.floating.floats;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.typed.number.floating.FloatingCondition;
import dev.ksarou.wotif.core.condition.typed.number.floating.IFloatingCondition;

public class FloatCondition extends FloatingCondition<Float> implements IFloatingCondition<Float, Float> {

    public FloatCondition(Float term) {
        super(term);
    }

    @Override
    protected Float zero() {
        return (float) 0;
    }

    @Override
    public long round() {
        return Math.round(this.term.value());
    }

    @Override
    public Completable<Float> isNumber() {
        return new Completable<>(term, !this.term.value().isNaN());
    }

    @Override
    public Completable<Float> isNaN() {
        return new Completable<>(term, this.term.value().isNaN());
    }

    @Override
    public Completable<Float> isInfinite() {
        return new Completable<>(term, this.term.value().isInfinite());
    }

    @Override
    public Completable<Float> isFinite() {
        return new Completable<>(term, !this.term.value().isInfinite());
    }

}
