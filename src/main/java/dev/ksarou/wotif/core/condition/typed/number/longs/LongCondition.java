/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package dev.ksarou.wotif.core.condition.typed.number.longs;

import dev.ksarou.wotif.core.condition.typed.number.AbstractNumberCondition;

public class LongCondition extends AbstractNumberCondition<Long> {

    public LongCondition(Long term) {
        super(term);
    }

    @Override
    protected Long zero() {
        return 0L;
    }

}
