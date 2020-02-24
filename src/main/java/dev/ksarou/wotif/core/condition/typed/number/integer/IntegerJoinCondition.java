/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.number.integer;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.number.AbstractNumberJoinCondition;

public class IntegerJoinCondition extends AbstractNumberJoinCondition<Integer, IntegerCondition> {

    public IntegerJoinCondition(JoinEnum joinType, Integer... terms) {
        super(joinType, terms);
    }

    @Override
    protected IntegerCondition getInstanceOfCondition(Integer term) {
        return new IntegerCondition(term);
    }

}
