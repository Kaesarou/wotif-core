/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.number.floating.doubles;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.typed.number.floating.FloatingCondition;
import dev.ksarou.wotif.core.condition.typed.number.floating.IFloatingCondition;

public class DoubleCondition extends FloatingCondition<Double> implements IFloatingCondition<Double, Double> {

    public DoubleCondition(Double term) {
        super(term);
    }

    @Override
    protected Double zero() {
        return (double) 0;
    }

    @Override
    public long round() {
        return Math.round(this.term.value());
    }

    @Override
    public Completable<Double> isNumber() {
        return new Completable<>(term, !this.term.value().isNaN());
    }

    @Override
    public Completable<Double> isNaN() {
        return new Completable<>(term, this.term.value().isNaN());
    }

    @Override
    public Completable<Double> isInfinite() {
        return new Completable<>(term, this.term.value().isInfinite());
    }

    @Override
    public Completable<Double> isFinite() {
        return new Completable<>(term, !this.term.value().isInfinite());
    }
}
