/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.number.floating.doubles;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.number.floating.FloatingJoinCondition;
import dev.ksarou.wotif.core.condition.typed.number.floating.IFloatingCondition;

import java.util.List;

public class DoubleJoinCondition extends FloatingJoinCondition<Double>
        implements IFloatingCondition<Double, List<Double>> {

    public DoubleJoinCondition(JoinEnum joinType, Double... terms) {
        super(joinType, terms);
    }

    @Override
    protected DoubleCondition getInstanceOfCondition(Double term) {
        return new DoubleCondition(term);
    }

}
