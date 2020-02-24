/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.number.floating;

import dev.ksarou.wotif.core.Completable;
import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.number.AbstractNumberJoinCondition;

import java.util.List;

public abstract class FloatingJoinCondition<F extends Number & Comparable<F>>
        extends AbstractNumberJoinCondition<F, FloatingCondition<F>>
        implements IFloatingCondition<F, List<F>> {

    @SafeVarargs
    public FloatingJoinCondition(JoinEnum joinType, F... terms) {
        super(joinType, terms);
    }

    @Override
    public Completable<List<F>> isCloseTo(Integer expected) {
        return this.functionToApply.apply(n -> n.isCloseTo(expected));
    }

    @Override
    public Completable<List<F>> isNotCloseTo(Integer expected) {
        return this.functionToApply.apply(n -> n.isNotCloseTo(expected));
    }

    @Override
    public Completable<List<F>> isNumber() {
        return this.functionToApply.apply(IFloatingCondition::isNumber);
    }

    @Override
    public Completable<List<F>> isNaN() {
        return this.functionToApply.apply(IFloatingCondition::isNaN);
    }

    @Override
    public Completable<List<F>> isInfinite() {
        return this.functionToApply.apply(IFloatingCondition::isInfinite);
    }

    @Override
    public Completable<List<F>> isFinite() {
        return this.functionToApply.apply(IFloatingCondition::isFinite);
    }

}
