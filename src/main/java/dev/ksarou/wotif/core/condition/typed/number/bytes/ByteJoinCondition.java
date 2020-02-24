/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.number.bytes;

import dev.ksarou.wotif.core.condition.JoinEnum;
import dev.ksarou.wotif.core.condition.typed.number.AbstractNumberJoinCondition;

public class ByteJoinCondition extends AbstractNumberJoinCondition<Byte, ByteCondition> {

    public ByteJoinCondition(JoinEnum joinType, Byte... terms) {
        super(joinType, terms);
    }

    @Override
    protected ByteCondition getInstanceOfCondition(Byte term) {
        return new ByteCondition(term);
    }

}
