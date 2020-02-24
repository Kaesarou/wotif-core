/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.iterable.arrays;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.iterable.AbstractIterableJoinCondition;
import dev.ksarou.wotif.core.condition.typed.iterable.IIterableCondition;

import java.util.List;

public class DoubleArraysJoinCondition extends AbstractIterableJoinCondition<Double, double[]>
        implements IIterableCondition<Double, double[], List<double[]>> {

    public DoubleArraysJoinCondition(JoinEnum joinType, double[]... terms) {
        super(joinType, terms);
    }

    @Override
    protected DoubleArraysCondition getInstanceOfCondition(double[] term) {
        return new DoubleArraysCondition(term);
    }

}
