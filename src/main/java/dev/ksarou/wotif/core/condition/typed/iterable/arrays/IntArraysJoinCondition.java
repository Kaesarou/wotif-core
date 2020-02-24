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

public class IntArraysJoinCondition extends AbstractIterableJoinCondition<Integer, int[]>
        implements IIterableCondition<Integer, int[], List<int[]>> {

    public IntArraysJoinCondition(JoinEnum joinType, int[]... terms) {
        super(joinType, terms);
    }

    @Override
    protected IntArraysCondition getInstanceOfCondition(int[] term) {
        return new IntArraysCondition(term);
    }

}
