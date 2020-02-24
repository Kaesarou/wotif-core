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

public class ShortArraysJoinCondition extends AbstractIterableJoinCondition<Short, short[]>
        implements IIterableCondition<Short, short[], List<short[]>> {

    public ShortArraysJoinCondition(JoinEnum joinType, short[]... terms) {
        super(joinType, terms);
    }

    @Override
    protected ShortArraysCondition getInstanceOfCondition(short[] term) {
        return new ShortArraysCondition(term);
    }

}
