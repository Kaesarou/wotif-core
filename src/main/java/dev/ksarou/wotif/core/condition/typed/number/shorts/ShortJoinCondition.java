/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.number.shorts;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.number.AbstractNumberJoinCondition;

public class ShortJoinCondition extends AbstractNumberJoinCondition<Short, ShortCondition> {

    public ShortJoinCondition(JoinEnum joinType, Short... terms) {
        super(joinType, terms);
    }

    @Override
    protected ShortCondition getInstanceOfCondition(Short term) {
        return new ShortCondition(term);
    }

}
